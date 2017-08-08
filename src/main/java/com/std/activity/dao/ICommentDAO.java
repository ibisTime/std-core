package com.std.activity.dao;

import com.std.activity.dao.base.IBaseDAO;
import com.std.activity.domain.Comment;

public interface ICommentDAO extends IBaseDAO<Comment> {
    String NAMESPACE = ICommentDAO.class.getName().concat(".");

    int update(Comment data);

    int approveComment(Comment data);
}
