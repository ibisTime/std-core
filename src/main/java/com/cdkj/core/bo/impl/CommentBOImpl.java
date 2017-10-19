package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.ICommentBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.dao.ICommentDAO;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.exception.BizException;

@Component
public class CommentBOImpl extends PaginableBOImpl<Comment> implements
        ICommentBO {

    @Autowired
    private ICommentDAO commentDAO;

    @Override
    public void saveComment(Comment data) {
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
    public Long getTotalCount(String entityCode, String companyCode,
            String systemCode) {
        Comment condition = new Comment();
        condition.setEntityCode(entityCode);
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        return commentDAO.selectTotalCount(condition);
    }

    @Override
    public List<Comment> queryCommentList(String orderCode, String companyCode,
            String systemCode) {
        Comment condition = new Comment();
        condition.setOrderCode(orderCode);
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        return commentDAO.selectList(condition);
    }

}
