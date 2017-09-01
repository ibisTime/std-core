package com.cdkj.core.dao;

import com.cdkj.core.dao.base.IBaseDAO;
import com.cdkj.core.domain.News;

/**
 * @author: shan 
 * @since: 2016年12月8日 下午5:28:55 
 * @history:
 */
public interface INewsDAO extends IBaseDAO<News> {
    String NAMESPACE = INewsDAO.class.getName().concat(".");

    public int update(News data);

    public int updateScanNum(News data);

    public int updateCommentNum(News data);

    public int updateLocation(News data);

    public int putOn(News data);

    public int putOff(News data);
}
