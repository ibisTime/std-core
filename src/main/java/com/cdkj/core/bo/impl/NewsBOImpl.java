package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.INewsBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.dao.INewsDAO;
import com.cdkj.core.domain.News;
import com.cdkj.core.enums.ENewsStatus;
import com.cdkj.core.exception.BizException;

/**
 * @author: shan 
 * @since: 2016年12月8日 下午9:15:49 
 * @history:
 */
@Component
public class NewsBOImpl extends PaginableBOImpl<News> implements INewsBO {

    @Autowired
    private INewsDAO newsDAO;

    @Override
    public void saveNews(News data) {
        if (data != null) {
            newsDAO.insert(data);
        }
    }

    @Override
    public int removeNews(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            News data = new News();
            data.setCode(code);
            count = newsDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshNews(News data) {
        int count = 0;
        if (data != null) {
            count = newsDAO.update(data);
        }
        return count;
    }

    @Override
    public int putOn(String code, String location, Integer orderNo,
            String updater, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            News data = new News();
            data.setCode(code);
            data.setStatus(ENewsStatus.PUBLISH_YES.getCode());
            data.setLocation(location);
            data.setOrderNo(orderNo);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            count = newsDAO.putOn(data);
        }
        return count;
    }

    @Override
    public int putOff(String code, String updater, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            News data = new News();
            data.setCode(code);
            data.setStatus(ENewsStatus.PUBLISH_NO.getCode());
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            count = newsDAO.putOff(data);
        }
        return count;
    }

    @Override
    public int addScanNum(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            News data = new News();
            data.setCode(code);
            count = newsDAO.updateScanNum(data);
        }
        return count;
    }

    @Override
    public int addCommentNum(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            News data = new News();
            data.setCode(code);
            count = newsDAO.updateCommentNum(data);
        }
        return count;
    }

    @Override
    public List<News> queryNewsList(News data) {
        return newsDAO.selectList(data);
    }

    @Override
    public News getNews(String code) {
        News news = null;
        if (StringUtils.isNotBlank(code)) {
            News data = new News();
            data.setCode(code);
            news = newsDAO.select(data);
            if (null == news) {
                throw new BizException("xn702002", "资讯不存在");
            }
        }
        return news;
    }

}
