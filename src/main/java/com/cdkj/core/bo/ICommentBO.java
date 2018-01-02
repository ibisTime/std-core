package com.cdkj.core.bo;

import java.util.List;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.enums.ECommentStatus;
import com.cdkj.core.enums.ECommentType;

public interface ICommentBO extends IPaginableBO<Comment> {

    public void saveComment(Comment data);

    public void saveComment(String userId, ECommentType type, String content,
            String parentCommentCode, String entityCode, String entityName,
            String companyCode, String systemCode);

    public void removeComment(Comment data);

    public void approveComment(Comment data, String status, String approver,
            String remark);

    public void searchCycleComment(String parentCode, List<Comment> list);

    public List<Comment> queryCommentList(Comment condition);

    public List<Comment> queryCommentList(String entityCode,
            ECommentStatus status, String companyCode, String systemCode);

    public Comment getComment(String code);

    public Long queryTotalScore(Comment condition);

    public Comment getRichComment(Comment comment);

    public Comment getNextComment(Comment comment);

    public List<Comment> queryChildComment(String parentCode);

    public int getTotalCountComment(String entityCode, ECommentStatus status,
            String companyCode, String systemCode);
}
