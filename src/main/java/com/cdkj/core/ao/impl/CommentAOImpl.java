package com.cdkj.core.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.bo.IAccountBO;
import com.cdkj.core.bo.ICommentBO;
import com.cdkj.core.bo.IKeywordBO;
import com.cdkj.core.bo.ISYSConfigBO;
import com.cdkj.core.bo.IUserBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.enums.EBoolean;
import com.cdkj.core.enums.ECommentStatus;
import com.cdkj.core.enums.EPrefixCode;
import com.cdkj.core.enums.EReaction;
import com.cdkj.core.exception.BizException;

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
    public String comment(String content, String commer, String orderCode) {
        userBO.getRemoteUser(commer);
        // 判断是否含有关键字
        String status = ECommentStatus.PUBLISHED.getCode();
        EReaction result = keywordBO.checkContent(content);
        if (EReaction.REFUSE.getCode().equals(result.getCode())) {
            status = ECommentStatus.FILTERED.getCode();
        }
        Comment data = new Comment();
        String code = OrderNoGenerater.generate(EPrefixCode.COMMENT.getCode());
        data.setCode(code);
        data.setContent(content);
        data.setStatus(status);
        data.setCommer(commer);
        data.setCommentDatetime(new Date());
        commentBO.saveComment(data);
        if (ECommentStatus.FILTERED.getCode().equals(status)) {
            code = code + "; filter";
        }
        return code;
    }

    @Override
    public void approveComment(String code, String result, String approver,
            String remark) {
        Comment data = commentBO.getComment(code);
        if (!ECommentStatus.FILTERED.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "评论不在可审核范围内,不能审核");
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

}
