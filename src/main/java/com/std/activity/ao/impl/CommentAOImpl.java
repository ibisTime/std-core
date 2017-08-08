package com.std.activity.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.activity.ao.ICommentAO;
import com.std.activity.bo.IAccountBO;
import com.std.activity.bo.ICommentBO;
import com.std.activity.bo.IKeywordBO;
import com.std.activity.bo.ISYSConfigBO;
import com.std.activity.bo.IUserBO;
import com.std.activity.bo.base.Paginable;
import com.std.activity.domain.Comment;
import com.std.activity.dto.req.XN622200Req;
import com.std.activity.enums.EBoolean;
import com.std.activity.enums.ECommentStatus;
import com.std.activity.enums.EPrefixCode;
import com.std.activity.enums.EReaction;
import com.std.activity.exception.BizException;

@Service
public class CommentAOImpl implements ICommentAO {

    @Autowired
    private ICommentBO commentBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IKeywordBO keywordBO;

    @Autowired
    private IAccountBO accountBO;

    @Override
    @Transactional
    public String comment(String content, List<XN622200Req> itemScoreList,
            String commer, String orderCode) {
        userBO.getRemoteUser(commer);
        // 判断是否含有关键字
        String status = ECommentStatus.PUBLISHED.getCode();
        EReaction result = keywordBO.checkContent(content);
        if (EReaction.REFUSE.getCode().equals(result.getCode())) {
            status = ECommentStatus.FILTERED.getCode();
        }
        String code = null;
        if (orderCode.startsWith(EPrefixCode.PERCOURSEORDER.getCode())) {

        } else if (orderCode.startsWith(EPrefixCode.ORGCOURSEORDER.getCode())) {

        }
        return code;
    }

    @Override
    public void approveComment(String code, String result, String approver,
            String remark) {
        Comment data = commentBO.getComment(code);
        if (!ECommentStatus.FILTERED.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "评论已在可审核范围内,不能审核");
        }
        String status = ECommentStatus.APPROVE_YES.getCode();
        if (EBoolean.NO.getCode().equals(result)) {
            status = ECommentStatus.APPROVE_NO.getCode();
        }
        commentBO.approveComment(data, status, approver, remark);
    }

    @Override
    public void dropComment(String code) {
        if (!commentBO.isCommentExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        commentBO.removeComment(code);
    }

    @Override
    public Paginable<Comment> queryCommentPage(int start, int limit,
            Comment condition) {
        Paginable<Comment> page = commentBO.getPaginable(start, limit,
            condition);
        List<Comment> commentList = page.getList();
        for (Comment comment : commentList) {
        }
        return page;
    }

    @Override
    public List<Comment> queryCommentList(Comment condition) {
        return commentBO.queryCommentList(condition);
    }

    @Override
    public Comment getComment(String code) {
        Comment comment = commentBO.getComment(code);
        return comment;
    }

    @Override
    public int avgCommentScore(String coachCode, String productCode) {
        List<Comment> list = commentBO.queryCommentList(coachCode, productCode);
        int avgNum = 0;
        int totalScore = 0;
        if (CollectionUtils.isNotEmpty(list)) {
            for (Comment comment : list) {
                totalScore = totalScore + comment.getScore();
            }
            avgNum = totalScore / list.size();
        }
        return avgNum;
    }
}
