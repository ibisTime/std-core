package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.ICommentBO;
import com.cdkj.core.bo.IKeywordBO;
import com.cdkj.core.bo.IUserBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.dao.ICommentDAO;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.domain.User;
import com.cdkj.core.enums.ECommentStatus;
import com.cdkj.core.enums.ECommentType;
import com.cdkj.core.enums.EPrefixCode;
import com.cdkj.core.enums.EReaction;
import com.cdkj.core.exception.BizException;

@Component
public class CommentBOImpl extends PaginableBOImpl<Comment> implements
        ICommentBO {

    @Autowired
    private ICommentDAO commentDAO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IKeywordBO keywordBO;

    @Override
    public void saveComment(Comment data) {
        commentDAO.insert(data);
    }

    @Override
    public void saveComment(String userId, ECommentType type, String content,
            String parentCommentCode, String entityCode, String companyCode,
            String systemCode) {
        User user = userBO.getRemoteUser(userId);
        // 判断是否含有关键字
        EReaction result = keywordBO.checkContent(content);
        String code = OrderNoGenerater
            .generateME(EPrefixCode.COMMENT.getCode());
        Comment data = new Comment();
        data.setCode(code);
        data.setType(type.getCode());
        data.setContent(content);

        String status = ECommentStatus.PUBLISHED.getCode();
        if (EReaction.REFUSE.getCode().equals(result.getCode())) {
            status = ECommentStatus.FILTERED.getCode();
            code = code + "||" + parentCommentCode + "||" + "||filter";
        }
        data.setStatus(status);

        data.setCommenter(user.getUserId());
        String commenterName = user.getMobile();
        if (StringUtils.isBlank(commenterName)) {
            commenterName = user.getNickname();
        }
        data.setCommenterName(commenterName);
        data.setCommentDatetime(new Date());
        data.setParentCode(parentCommentCode);
        data.setEntityCode(entityCode);

        data.setCompanyCode(companyCode);
        data.setSystemCode(systemCode);
        commentDAO.insert(data);
    }

    @Override
    public void removeComment(Comment data) {
        if (null != data) {
            commentDAO.delete(data);
        }
    }

    @Override
    public void approveComment(Comment data, String status, String approver,
            String remark) {
        data.setStatus(status);
        data.setApprover(approver);
        data.setApproveDatetime(new Date());
        data.setRemark(remark);
        commentDAO.approveComment(data);
    }

    @Override
    public List<Comment> queryCommentList(Comment condition) {
        return commentDAO.selectList(condition);
    }

    @Override
    public List<Comment> queryCommentList(String entityCode,
            ECommentStatus status, String companyCode, String systemCode) {
        Comment condition = new Comment();
        condition.setEntityCode(entityCode);
        condition.setStatus(ECommentStatus.PUBLISHALL.getCode());
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        return commentDAO.selectList(condition);
    }

    @Override
    public int getTotalCountComment(String entityCode, ECommentStatus status,
            String companyCode, String systemCode) {
        Comment condition = new Comment();
        condition.setEntityCode(entityCode);
        condition.setStatus(ECommentStatus.PUBLISHALL.getCode());
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        return commentDAO.selectTotalCount(condition).intValue();
    }

    @Override
    public Comment getComment(String code) {
        Comment data = null;
        if (StringUtils.isNotBlank(code)) {
            Comment condition = new Comment();
            condition.setCode(code);
            data = commentDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "评论不存在");
            }
        }
        return data;
    }

    @Override
    public Long queryTotalScore(Comment condition) {
        return commentDAO.selectTotalScore(condition);
    }

    @Override
    public Comment getRichComment(Comment comment) {
        User commentUser = userBO.getRemoteUser(comment.getCommenter());
        comment.setCommenterName(commentUser.getMobile());
        comment.setNickname(commentUser.getNickname());
        comment.setPhoto(commentUser.getPhoto());
        if (!comment.getParentCode().equals(comment.getEntityCode())) {
            Comment parentComment = getComment(comment.getParentCode());
            User parentUser = userBO
                .getRemoteUser(parentComment.getCommenter());
            parentComment.setCommenterName(parentUser.getMobile());
            parentComment.setNickname(parentUser.getNickname());
            parentComment.setPhoto(parentUser.getPhoto());
            comment.setParentComment(parentComment);
        }
        return comment;
    }

    // @Override
    // public void orderCommentList(List<Comment> commentList) {
    // for (int i = 0; i < commentList.size(); i++) {
    // for (int j = i + 1; j < commentList.size(); j++) {
    // if (commentList.get(i).getCommentDatetime().getTime() > commentList
    // .get(j).getCommentDatetime().getTime()) {
    // Comment temp = new Comment();
    // temp = commentList.get(i);
    // commentList.set(i, commentList.get(j));
    // commentList.set(j, temp);
    // }
    // }
    // }
    // }
}
