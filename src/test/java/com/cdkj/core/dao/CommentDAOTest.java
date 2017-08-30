package com.cdkj.core.dao;

import java.util.List;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBeanByType;

import com.cdkj.core.dao.ICommentDAO;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.base.ADAOTest;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 上午11:01:50 
 * @history:
 */
public class CommentDAOTest extends ADAOTest {
    @SpringBeanByType
    private ICommentDAO commentDAO;

    @Test
    public void selectList() {
        Comment condition = new Comment();
        List<Comment> list = commentDAO.selectList(condition);
        logger.info("select : {}", list.size());
    }
}
