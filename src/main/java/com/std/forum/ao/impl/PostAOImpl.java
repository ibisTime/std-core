/**
4 * @Title PostAOImpl.java 
 * @Package com.std.forum.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午7:52:36 
 * @version V1.0   
 */
package com.std.forum.ao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.forum.ao.IPostAO;
import com.std.forum.bo.ICommentBO;
import com.std.forum.bo.IKeywordBO;
import com.std.forum.bo.ILevelRuleBO;
import com.std.forum.bo.IPostBO;
import com.std.forum.bo.IPostTalkBO;
import com.std.forum.bo.IRuleBO;
import com.std.forum.bo.ISplateBO;
import com.std.forum.bo.IUserBO;
import com.std.forum.bo.base.Page;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Comment;
import com.std.forum.domain.LevelRule;
import com.std.forum.domain.Post;
import com.std.forum.domain.PostTalk;
import com.std.forum.domain.Splate;
import com.std.forum.domain.User;
import com.std.forum.enums.EBoolean;
import com.std.forum.enums.EDirection;
import com.std.forum.enums.ELocation;
import com.std.forum.enums.EPostStatus;
import com.std.forum.enums.EPostType;
import com.std.forum.enums.EReaction;
import com.std.forum.enums.ERuleType;
import com.std.forum.enums.ETalkType;
import com.std.forum.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午7:52:36 
 * @history:
 */
@Service
public class PostAOImpl implements IPostAO {

    @Autowired
    protected IPostBO postBO;

    @Autowired
    protected IPostTalkBO postTalkBO;

    @Autowired
    protected ICommentBO commentBO;

    @Autowired
    protected IKeywordBO keywordBO;

    @Autowired
    protected IUserBO userBO;

    @Autowired
    protected ISplateBO splateBO;

    @Autowired
    protected IRuleBO ruleBO;

    @Autowired
    protected ILevelRuleBO levelRuleBO;

    // 1.发布帖子
    // 判断是否发帖
    // 1、发帖，内容过滤，等级判断是否审核
    // 2、草稿保存
    @Override
    @Transactional
    public String publishPost(String title, String content, String pic,
            String plateCode, String publisher, String isPublish) {
        // 判断版块是否存在
        Splate splate = splateBO.getSplate(plateCode);
        String code = null;
        if (EBoolean.NO.getCode().equals(isPublish)) {// 保存草稿
            code = postBO.savePost(title, content, pic, splate.getCode(),
                publisher, EPostStatus.DRAFT.getCode());
        } else {// 直接发布
            code = doPublishPost(null, splate, title, content, pic, publisher);
        }
        return code;
    }

    // 2.草稿发布帖子
    @Override
    @Transactional
    public String draftPublishPost(String code, String title, String content,
            String pic, String plateCode, String publisher, String isPublish) {
        // 判断版块是否存在
        Splate splate = splateBO.getSplate(plateCode);
        if (EBoolean.NO.getCode().equals(isPublish)) {// 继续草稿
            postBO.refreshPost(code, title, content, pic, plateCode, publisher,
                EPostStatus.DRAFT.getCode());
        } else {
            doPublishPost(code, splate, title, content, pic, publisher);
        }
        return code;
    }

    private String doPublishPost(String code, Splate splate, String title,
            String content, String pic, String publisher) {
        String status = null;
        // 对标题和内容进行关键字过滤
        EReaction reaction1 = keywordBO.checkContent(title);
        EReaction reaction2 = keywordBO.checkContent(content);
        if (EReaction.REFUSE.getCode().equals(reaction1.getCode())
                || EReaction.REFUSE.getCode().equals(reaction2.getCode())) {
            status = EPostStatus.FILTERED.getCode();
        } else {
            // 判断用户等级，是否审核
            User user = userBO.getRemoteUser(publisher);
            LevelRule levelRule = levelRuleBO.getLevelRule(user.getLevel());
            if (EBoolean.YES.getCode().equals(levelRule.getEffect())) {
                status = EPostStatus.todoAPPROVE.getCode();
            } else {
                status = EPostStatus.PUBLISHED.getCode();
            }
        }
        if (StringUtils.isNotBlank(code)) {
            postBO.refreshPost(code, title, content, pic, splate.getCode(),
                publisher, status);
        } else {
            code = postBO.savePost(title, content, pic, splate.getCode(),
                publisher, status);
        }
        // 告知前端被过滤了
        if (EPostStatus.FILTERED.getCode().equals(status)) {
            code = code + ";filter:true";
        }
        // 发帖加积分
        if (EPostStatus.PUBLISHED.getCode().equals(status)) {
            userBO.doTransfer(publisher, EDirection.PLUS.getCode(),
                ERuleType.FT.getCode(), code);
        }
        return code;

    }

    @Override
    @Transactional
    public void dropPostList(List<String> codeList, String userId, String type) {
        for (String code : codeList) {
            dropPost(code, userId, type);
        }
    }

    @Override
    @Transactional
    public void dropPost(String code, String userId, String type) {
        Post post = null;
        Splate splate = null;
        Comment comment = null;
        String publisher = null;
        if (EPostType.PL.getCode().equals(type)) {
            comment = commentBO.getComment(code);
            publisher = comment.getCommer();
            post = postBO.getPost(comment.getPostCode());
        } else {
            post = postBO.getPost(code);
            publisher = post.getPublisher();
            List<PostTalk> talkList = postTalkBO.queryPostTalkSingleList(
                post.getCode(), null, null);
            for (PostTalk postTalk : talkList) {
                postTalkBO.removePostTalk(postTalk.getCode());
            }
        }
        splate = splateBO.getSplate(post.getPlateCode());
        String companyCode = splate.getCompanyCode();
        User res = userBO.getRemoteUser(userId);
        // if (EUserKind.Operator.getCode().equals(res.getKind())) {
        // if (!companyCode.equals(res.getCompanyCode())) {
        // throw new BizException("xn000000", "当前用户不是该帖子的管理员，无法删除");
        // }
        // } else {
        List<Splate> plateList = splateBO.getPlateByUserId(userId);
        Map<String, Splate> map = new HashMap<String, Splate>();
        for (Splate data : plateList) {
            map.put(data.getCode(), data);
        }
        if (null == map.get(splate.getCode()) && !userId.equals(publisher)) {
            throw new BizException("xn000000", "当前用户不是该版块版主或发布用户，无法删除");
        }
        // }
        if (EPostType.TZ.getCode().equals(type)) {
            postBO.removePost(code);
            // 删除帖子相关的评论
            commentBO.removeCommentByPost(code);
        } else if (EPostType.PL.getCode().equals(type)) {
            commentBO.removeComment(code);
            // 删除下级，下下级评论
            List<Comment> commentList = new ArrayList<Comment>();
            searchCycleComment(code, commentList, null);
            for (Comment data : commentList) {
                commentBO.removeComment(data.getCode());
            }
        }
    }

    private void searchCycleComment(String parentCode, List<Comment> list,
            String status) {
        List<Comment> nextList = commentBO.queryCommentList(parentCode, status);
        if (CollectionUtils.isNotEmpty(nextList)) {
            list.addAll(nextList);
            for (int i = 0; i < nextList.size(); i++) {
                searchCycleComment(nextList.get(i).getCode(), list, status);
            }
        }
    }

    @Override
    @Transactional
    public void setPostLocation(String code, String location, Integer orderNo) {
        Post post = postBO.getPost(code);
        String postLocation = post.getLocation();
        if (!post.getLocation().contains(location)) {
            postLocation = post.getLocation().concat(location);
        } else {
            postLocation = post.getLocation().replace(location, "");
        }
        postBO.refreshPostLocation(code, postLocation, orderNo);
        String[] locationArr = location.split(",");
        for (String JH : locationArr) {
            // 设置精华加积分(前面已判断是否重复加)
            if (ELocation.JH.getCode().equals(JH)) {
                userBO.doTransfer(post.getPublisher(),
                    EDirection.PLUS.getCode(), ERuleType.JH.getCode(), code);
            }
        }
    }

    // 批量审核帖子
    @Override
    public void approvePostList(List<String> codeList, String approver,
            String approveResult, String approveNote, String type) {
        for (String code : codeList) {
            this.approvePost(code, approver, approveResult, approveNote, type);
        }
    }

    public void approvePost(String code, String approver, String approveResult,
            String approveNote, String type) {
        if (EPostType.TZ.getCode().equals(type)) {
            Post post = postBO.getPost(code);
            if (EBoolean.YES.getCode().equals(approveResult)
                    && !EPostStatus.todoAPPROVE.getCode().equals(
                        post.getStatus())
                    && !EPostStatus.toReportAPPROVE.getCode().equals(
                        post.getStatus())) {
                throw new BizException("xn000000", "帖子不是待审核状态");
            }
            postBO.refreshPostApprove(code, approver, approveResult,
                approveNote);
            // 审核通过加积分
            if (EPostStatus.todoAPPROVE.getCode().equals(post.getStatus())
                    && EBoolean.YES.getCode().equals(approveResult)) {
                userBO.doTransfer(post.getPublisher(),
                    EDirection.PLUS.getCode(), ERuleType.FT.getCode(), code);
            }
            // 被举报，确认存在问题，扣积分
            if (EPostStatus.toReportAPPROVE.getCode().equals(post.getStatus())
                    && EBoolean.NO.getCode().equals(approveResult)) {
                userBO.doTransfer(post.getPublisher(),
                    EDirection.MINUS.getCode(), ERuleType.TZWG.getCode(), code);
            }
        } else if (EPostType.PL.getCode().equals(type)) {
            type = ETalkType.PLJB.getCode();
            Comment comment = commentBO.getComment(code);
            if (!EPostStatus.todoAPPROVE.getCode().equals(comment.getStatus())
                    && !EPostStatus.toReportAPPROVE.getCode().equals(
                        comment.getStatus())) {
                throw new BizException("xn000000", "评论状态不是待审核状态");
            }
            commentBO.refreshCommentApprove(code, approveResult, approver,
                approveNote);
            // 被举报，确认存在问题，扣积分
            if (EPostStatus.toReportAPPROVE.getCode().equals(
                comment.getStatus())
                    && EBoolean.NO.getCode().equals(approveResult)) {
                userBO.doTransfer(comment.getCommer(),
                    EDirection.MINUS.getCode(), ERuleType.PLWG.getCode(), code);
            }
        }
    }

    // 是否锁帖
    @Override
    public void lockPost(List<String> codeList) {
        for (String code : codeList) {
            Post post = postBO.getPost(code);
            // 1 锁帖 0 正常帖
            boolean flag = false;
            if (EBoolean.YES.getCode().equals(post.getIsLock())) {
                flag = true;
            }
            postBO.refreshPostLock(code, flag);
        }
    }

    @Override
    public void editPostPlate(List<String> codeList, String plateCode) {
        for (String code : codeList) {
            postBO.getPost(code);
            Splate splate = splateBO.getSplate(plateCode);
            if (EBoolean.NO.getCode().equals(splate.getStatus())) {
                throw new BizException("xn000000", "该版块状态为未启用");
            }
            postBO.refreshPostPlate(code, plateCode);
        }
    }

    // 分页查
    @Override
    public Paginable<Post> queryPostPage(int start, int limit, Post condition) {
        condition.setLocation(setLocation(condition.getLocation()));
        Paginable<Post> postPage = postBO.getPaginable(start, limit, condition);
        List<Post> postList = postPage.getList();
        for (Post post : postList) {
            cutPic(post);
            getPartInfo(post, condition.getUserId());
            this.fullPost(post);
            this.fullUser(post);
        }
        return postPage;
    }

    // 列表查
    @Override
    public List<Post> queryPostList(Post condition) {
        condition.setLocation(setLocation(condition.getLocation()));
        List<Post> postList = postBO.queryPostList(condition);
        for (Post post : postList) {
            this.cutPic(post);
            this.getPartInfo(post, condition.getUserId());
            this.fullUser(post);
            this.fullPost(post);
        }
        return postList;
    }

    private void fullPost(Post post) {
        List<Comment> commentList = commentBO.queryCommentLimitList(post
            .getCode());
        for (Comment comment : commentList) {
            this.fullUser(comment);
        }
        post.setCommentList(commentList);
        List<PostTalk> postTalkList = postTalkBO.queryPostTalkLimitList(post
            .getCode());
        for (PostTalk postTalk : postTalkList) {
            this.fullUser(postTalk);
        }
        post.setLikeList(postTalkList);
    }

    private String setLocation(String location) {
        if (StringUtils.isNotBlank(location)) {
            String[] desc = location.split(",");
            for (int i = 0; i < desc.length; i++) {
                location = desc[i] + "%";
            }
        }
        return location;
    }

    private void fullUser(Comment comment) {
        User user = userBO.getRemoteUser(comment.getCommer());
        comment.setNickname(user.getNickname());
        comment.setPhoto(user.getPhoto());
        comment.setLoginName(user.getLoginName());
    }

    private void fullUser(PostTalk postTalk) {
        User user = userBO.getRemoteUser(postTalk.getTalker());
        postTalk.setNickname(user.getNickname());
        postTalk.setPhoto(user.getPhoto());
    }

    private void fullUser(Post post) {
        User user = userBO.getRemoteUser(post.getPublisher());
        post.setNickname(user.getNickname());
        post.setPhoto(user.getPhoto());
        post.setLoginName(user.getLoginName());
    }

    private void fullSplate(Post post) {
        Splate splate = splateBO.getSplate(post.getPlateCode());
        post.setPlateName(splate.getName());
    }

    @Override
    public Post getPost(String code, String userId, String commStatus) {
        Post post = postBO.getPost(code);
        this.cutPic(post);
        this.getPartInfo(post, userId);
        this.fullUser(post);
        this.fullPost(post);
        return post;
    }

    @Override
    public Post getPost(String code) {
        Post post = postBO.getPost(code);
        this.cutPic(post);
        this.fullUser(post);
        return post;
    }

    private void cutPic(Post post) {
        String pic = post.getPic();
        if (StringUtils.isNotBlank(pic)) {
            String[] picArr = pic.split("\\|\\|");
            post.setPicArr(picArr);
            post.setPic(null);
        }
    }

    /**
     * 获取数据
     * @param post
     * @param userId
     * @param commStatus
     * @param size 
     * @create: 2017年3月8日 下午1:46:33 xieyj
     * @history:
     */
    private void getPartInfo(Post post, String userId) {
        String code = post.getCode();
        // 设置查询点赞记录条件
        post.setIsDZ(EBoolean.NO.getCode());
        post.setIsSC(EBoolean.NO.getCode());
        if (StringUtils.isNotBlank(userId)) {
            PostTalk dzPostTalk = postTalkBO.getPostTalkByCondition(code,
                userId, ETalkType.DZ.getCode());
            if (null != dzPostTalk) {
                post.setIsDZ(EBoolean.YES.getCode());
            }
            PostTalk scPostTalk = postTalkBO.getPostTalkByCondition(code,
                userId, ETalkType.SC.getCode());
            if (null != scPostTalk) {
                post.setIsSC(EBoolean.YES.getCode());
            }
        }
    }

    private void orderCommentList(List<Comment> commentList) {
        for (int i = 0; i < commentList.size(); i++) {
            for (int j = i + 1; j < commentList.size(); j++) {
                if (commentList.get(i).getCommDatetime().getTime() > commentList
                    .get(j).getCommDatetime().getTime()) {
                    Comment temp = new Comment();
                    temp = commentList.get(i);
                    commentList.set(i, commentList.get(j));
                    commentList.set(j, temp);
                }
            }
        }
    }

    @Override
    public Paginable<Post> querySCPostPage(int start, int limit, Post condition) {
        condition.setType(ETalkType.SC.getCode());
        Paginable<Post> postPage = null;
        List<Post> list = postBO.selectSCList(condition);
        postPage = new Page<Post>(start, limit, list.size());
        List<Post> dataList = postBO.queryPostSCList(condition,
            postPage.getStart(), postPage.getPageSize());
        postPage.setList(dataList);
        // Paginable<Post> postPage = postBO.getPaginable(start, limit,
        // condition);
        List<Post> postList = postPage.getList();
        for (Post post : postList) {
            cutPic(post);
            this.getPartInfo(post, condition.getUserId());
            this.fullUser(post);
            this.fullPost(post);
        }
        return postPage;
    }

    @Override
    public List<Post> querySCPostList(String talker) {
        Post condition = new Post();
        condition.setType(ETalkType.SC.getCode());
        condition.setTalker(talker);
        List<Post> postList = postBO.selectSCList(condition);
        for (Post post : postList) {
            this.fullSplate(post);
            this.cutPic(post);
            this.getPartInfo(post, condition.getUserId());
            this.fullUser(post);
            this.fullPost(post);
        }
        return postList;
    }

    /** 
     * @see com.std.forum.ao.IPostAO#readPost(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void readPost(String postCode) {
        Post post = postBO.getPost(postCode);
        postBO.refreshPostSumRead(postCode, post.getSumRead() + 1);
    }

    @Override
    public Post getPostByCommentCode(String commentCode, String userId) {
        Post post = null;
        Comment comment = commentBO.getComment(commentCode);
        post = postBO.getPost(comment.getPostCode());
        getPartInfo(post, userId);
        fullUser(post);
        return post;
    }

    @Override
    public Long getMyPostCount(String userId, String status) {
        return postBO.getMyPostCount(userId, status);
    }

    @Override
    public void returnPost(List<String> codeList, String type) {
        for (String code : codeList) {
            if (EPostType.TZ.getCode().equals(type)) {
                Post post = postBO.getPost(code);
                if (!EPostStatus.APPROVE_NO.getCode().equals(post.getStatus())) {
                    throw new BizException("xn000000", "该帖子不是待回收状态");
                }
                postBO.refreshPostReturn(code);
            } else {
                Comment comment = commentBO.getComment(code);
                if (!EPostStatus.APPROVE_NO.getCode().equals(
                    comment.getStatus())) {
                    throw new BizException("xn000000", "该评论不是待回收状态");
                }
                commentBO.refreshCommentReturn(code);
            }
        }
    }

    @Override
    public Paginable<Post> queryTDPostPage(int start, int limit,
            Post condition, String userId) {
        Paginable<Post> page = null;
        User user = userBO.getRemoteUser(userId);
        condition.setKeyword("@" + user.getNickname());
        List<Post> List = postBO.selectTDList(condition);
        page = new Page<Post>(start, limit, List.size());
        List<Post> dataList = postBO.queryTDPostList(condition,
            page.getStart(), page.getPageSize());
        page.setList(dataList);
        List<Post> list = page.getList();
        for (Post post : list) {
            cutPic(post);
            this.getPartInfo(post, condition.getUserId());
            this.fullUser(post);
            this.fullPost(post);
        }
        return page;
    }

    @Override
    public Paginable<Post> queryOSSPostPage(int start, int limit, Post condition) {
        condition.setLocation(setLocation(condition.getLocation()));
        Paginable<Post> postPage = postBO.getPaginable(start, limit, condition);
        List<Post> postList = postPage.getList();
        for (Post post : postList) {
            cutPic(post);
            this.fullUser(post);
        }
        return postPage;
    }

}
