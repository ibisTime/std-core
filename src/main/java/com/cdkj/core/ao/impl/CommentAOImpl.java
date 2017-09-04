package com.cdkj.core.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.bo.ICommentBO;
import com.cdkj.core.bo.IKeywordBO;
import com.cdkj.core.bo.IUserBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.domain.User;
import com.cdkj.core.dto.req.XN801020Req;
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
    private IKeywordBO keywordBO;

    @Autowired
    private IUserBO userBO;

    @Override
    @Transactional
    public String comment(XN801020Req req) {
        // 判断是否含有关键字
        String status = ECommentStatus.PUBLISHED.getCode();
        EReaction result = keywordBO.checkContent(req.getContent());
        if (EReaction.REFUSE.getCode().equals(result.getCode())) {
            status = ECommentStatus.FILTERED.getCode();
        }
        Comment data = new Comment();
        String code = OrderNoGenerater.generate(EPrefixCode.COMMENT.getCode());
        data.setCode(code);
        data.setType(req.getType());
        data.setContent(req.getContent());
        data.setStatus(status);
        data.setCommenter(req.getCommenter());
        data.setCommenterName(req.getCommenterName());
        data.setCommentDatetime(new Date());
        data.setParentCode(req.getParentCode());
        data.setOrderCode(req.getOrderCode());
        data.setEntityCode(req.getEntityCode());
        data.setEntityName(req.getEntityName());
        data.setCompanyCode(req.getCompanyCode());
        data.setSystemCode(req.getSystemCode());
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
            throw new BizException("xn0000", "该评论不是待审核状态,不能审核");
        }
        String status = ECommentStatus.APPROVE_YES.getCode();
        if (EBoolean.NO.getCode().equals(result)) {
            status = ECommentStatus.APPROVE_NO.getCode();
        }
        commentBO.approveComment(data, status, approver, remark);
    }

    @Override
    public void dropComment(String code) {
        Comment comment = commentBO.getComment(code);
        commentBO.removeComment(comment);
    }

    @Override
    public Paginable<Comment> queryCommentPage(int start, int limit,
            Comment condition) {
        Paginable<Comment> page = commentBO.getPaginable(start, limit,
            condition);
        List<Comment> commentList = page.getList();
        for (Comment comment : commentList) {
            User user = userBO.getRemoteUser(comment.getCommenter());
            comment.setNickname(user.getNickname());
            comment.setPhoto(user.getPhoto());
        }
        return page;
    }

    @Override
    public Comment getComment(String code) {
        Comment comment = commentBO.getComment(code);
        User user = userBO.getRemoteUser(comment.getCommenter());
        comment.setNickname(user.getNickname());
        comment.setPhoto(user.getPhoto());
        return comment;
    }
}
