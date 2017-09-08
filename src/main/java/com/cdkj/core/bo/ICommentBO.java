package com.cdkj.core.bo;

import java.util.List;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.Comment;

public interface ICommentBO extends IPaginableBO<Comment> {

    public void saveComment(Comment data);

    public void removeComment(Comment data);

    public void approveComment(Comment data, String status, String approver,
            String remark);

    public List<Comment> queryCommentList(Comment condition);

    public Comment getComment(String code);

    public Long queryTotalScore(Comment condition);
}
