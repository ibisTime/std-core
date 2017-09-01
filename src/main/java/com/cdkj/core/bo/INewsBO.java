package com.cdkj.core.bo;

import java.util.List;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.News;

public interface INewsBO extends IPaginableBO<News> {

    // 新增资讯
    public void saveNews(News data);

    // 删除资讯
    public int removeNews(String code);

    // 修改资讯
    public int refreshNews(News data);

    // 上架
    public int putOn(String code, String location, Integer orderNo,
            String updater, String remark);

    // 下架
    public int putOff(String code, String updater, String remark);

    // 增加浏览量
    public int addScanNum(String code);

    // 增加评论数
    public int addCommentNum(String code);

    // 列表查询资讯
    public List<News> queryNewsList(News data);

    // 详情查询资讯
    public News getNews(String code);
}
