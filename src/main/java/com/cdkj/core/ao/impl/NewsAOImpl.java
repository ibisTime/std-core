package com.cdkj.core.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.core.ao.INewsAO;
import com.cdkj.core.bo.INewsBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.domain.News;
import com.cdkj.core.dto.req.XN801000Req;
import com.cdkj.core.dto.req.XN801002Req;
import com.cdkj.core.enums.EGeneratePrefix;
import com.cdkj.core.enums.ENewsStatus;
import com.cdkj.core.exception.BizException;

@Service
public class NewsAOImpl implements INewsAO {

    @Autowired
    INewsBO newsBO;

    @Override
    public String addNews(XN801000Req req) {
        String code = OrderNoGenerater.generate(EGeneratePrefix.News.getCode());
        News data = new News();
        data.setCode(code);
        data.setType(req.getType());
        data.setTitle(req.getTitle());
        data.setKeywords(req.getKeywords());
        data.setContent(req.getContent());
        data.setAdvPic(req.getAdvPic());
        data.setPic(req.getPic());
        data.setScanNum(0);
        data.setCommentNum(0);
        data.setStatus(ENewsStatus.TO_PUBLISH.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setCompanyCode(req.getCompanyCode());
        data.setSystemCode(req.getSystemCode());
        newsBO.saveNews(data);
        return code;
    }

    @Override
    public void dropNews(String code) {
        News data = newsBO.getNews(code);
        if (ENewsStatus.TO_PUBLISH.getCode().equals(data.getStatus())
                || ENewsStatus.PUBLISH_NO.getCode().equals(data.getStatus())) {
            newsBO.removeNews(code);
        } else {
            throw new BizException("xn0000", "该资讯已上架，请先下架");
        }
    }

    @Override
    public void editNews(XN801002Req req) {
        News data = newsBO.getNews(req.getCode());
        if (!ENewsStatus.PUBLISH_YES.getCode().equals(data.getStatus())) {
            data.setTitle(req.getTitle());
            data.setKeywords(req.getKeywords());
            data.setContent(req.getContent());
            data.setAdvPic(req.getAdvPic());
            data.setPic(req.getPic());
            data.setUpdater(req.getUpdater());
            data.setUpdateDatetime(new Date());
            newsBO.refreshNews(data);
        } else {
            throw new BizException("xn0000", "该资讯已上架，请先下架");
        }
    }

    @Override
    public Paginable<News> queryNewsPage(int start, int limit, News condition) {
        return newsBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<News> queryNewsList(News condition) {
        return newsBO.queryNewsList(condition);
    }

    @Override
    public News getNews(String code) {
        return newsBO.getNews(code);
    }

    @Override
    public void putOn(String code, String location, Integer orderNo,
            String updater, String remark) {
        News data = newsBO.getNews(code);
        if (!ENewsStatus.PUBLISH_YES.getCode().equals(data.getStatus())) {
            newsBO.putOn(code, location, orderNo, updater, remark);
        } else {
            throw new BizException("xn0000", "该资讯已上架，无需重复上架");
        }
    }

    @Override
    public void putOff(String code, String updater, String remark) {
        News data = newsBO.getNews(code);
        if (ENewsStatus.PUBLISH_YES.getCode().equals(data.getStatus())) {
            newsBO.putOff(code, updater, remark);
        } else {
            throw new BizException("xn0000", "该资讯还未上架,不能下架");
        }
    }

    @Override
    public void scan(String code, String userId) {
    }

    @Override
    public void comment(String type, String newsCode, String userId) {

    }
}
