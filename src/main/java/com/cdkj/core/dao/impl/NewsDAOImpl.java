package com.cdkj.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.core.dao.INewsDAO;
import com.cdkj.core.dao.base.support.AMybatisTemplate;
import com.cdkj.core.domain.News;

/**
 * 资讯
 * @author: shan 
 * @since: 2016年12月8日 下午8:01:03 
 * @history:
 */
@Repository("newsDAOImpl")
public class NewsDAOImpl extends AMybatisTemplate implements INewsDAO {

    /**
     * @see com.cdkj.core.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(News data) {
        return super.insert(NAMESPACE.concat("insert_news"), data);
    }

    /**
     * @see com.cdkj.core.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(News data) {
        return super.delete(NAMESPACE.concat("delete_news"), data);
    }

    /**
     * @see com.cdkj.core.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public News select(News condition) {
        return super.select(NAMESPACE.concat("select_news"), condition,
            News.class);
    }

    /**
     * @see com.cdkj.core.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(News condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_news_count"),
            condition);
    }

    /**
     * @see com.cdkj.core.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<News> selectList(News condition) {
        return super.selectList(NAMESPACE.concat("select_news"), condition,
            News.class);
    }

    /**
     * @see com.cdkj.core.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<News> selectList(News condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_news"), start, count,
            condition, News.class);
    }

    /**
     * @see com.cdkj.core.dao.INewsDAO#update(com.cdkj.core.domain.News)
     */
    @Override
    public int update(News data) {
        return super.update(NAMESPACE.concat("update_news"), data);
    }

    /**
     * 
     * @see com.cdkj.core.dao.INewsDAO#updateScanNum(com.cdkj.core.domain.News)
     */
    @Override
    public int updateScanNum(News data) {
        return super.update(NAMESPACE.concat("update_newsScan"), data);
    }

    /**
     * 
     * @see com.cdkj.core.dao.INewsDAO#updateCommentNum(com.cdkj.core.domain.News)
     */
    @Override
    public int updateCommentNum(News data) {
        return super.update(NAMESPACE.concat("update_newsComment"), data);
    }

    /**
     * 
     * @see com.cdkj.core.dao.INewsDAO#updateLocation(com.cdkj.core.domain.News)
     */
    @Override
    public int updateLocation(News data) {
        return super.update(NAMESPACE.concat("update_newsLocation"), data);
    }

    @Override
    public int putOn(News data) {
        return super.update(NAMESPACE.concat("update_putOn"), data);
    }

    @Override
    public int putOff(News data) {
        return super.update(NAMESPACE.concat("update_putOff"), data);
    }

}
