package com.cdkj.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.core.dao.ICommentDAO;
import com.cdkj.core.dao.base.support.AMybatisTemplate;
import com.cdkj.core.domain.Comment;

@Repository("commentDAOImpl")
public class CommentDAOImpl extends AMybatisTemplate implements ICommentDAO {

    @Override
    public int insert(Comment data) {
        return super.insert(NAMESPACE.concat("insert_comment"), data);
    }

    @Override
    public int delete(Comment data) {
        return 0;
    }

    @Override
    public Comment select(Comment condition) {
        return super.select(NAMESPACE.concat("select_comment"), condition,
            Comment.class);
    }

    @Override
    public Long selectTotalCount(Comment condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_comment_count"),
            condition);
    }

    @Override
    public List<Comment> selectList(Comment condition) {
        return super.selectList(NAMESPACE.concat("select_comment"), condition,
            Comment.class);
    }

    @Override
    public List<Comment> selectList(Comment condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_comment"), start,
            count, condition, Comment.class);
    }

    @Override
    public int approveComment(Comment data) {
        return super.update(NAMESPACE.concat("update_approve"), data);
    }
}
