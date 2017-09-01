package com.cdkj.core.ao;

import java.util.List;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.News;
import com.cdkj.core.dto.req.XN801000Req;
import com.cdkj.core.dto.req.XN801002Req;

public interface INewsAO {
    static String DEFAULT_ORDER_COLUMN = "code";

    // 新增资讯
    public String addNews(XN801000Req req);

    // 删除资讯
    public void dropNews(String code);

    // 修改资讯
    public void editNews(XN801002Req req);

    // 上架
    public void putOn(String code, String location, Integer orderNo,
            String updater, String remark);

    // 下架
    public void putOff(String code, String updater, String remark);

    // 浏览
    public void scan(String code, String userId);

    // 评论
    public void comment(String type, String newsCode, String userId);

    public Paginable<News> queryNewsPage(int start, int limit, News condition);

    public List<News> queryNewsList(News condition);

    public News getNews(String code);
}
