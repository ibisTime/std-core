package com.cdkj.core.domain;

import java.util.Date;

import com.cdkj.core.dao.base.ABaseDO;

/**
* 交互
* @author: shan 
* @since: 2017-09-01 13:42:25
* @history:
*/
public class Interact extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 实体类型
    private String category;

    // 分类(1 点赞 2 收藏 3 浏览)
    private String type;

    // 实体编号
    private String entityCode;

    // 交互人
    private String interacter;

    // 交互时间
    private Date interactDatetime;

    // 公司编号
    private String companyCode;

    // 系统编号
    private String systemCode;

    // *************db properties**************
    // 字符日期
    private Long interactDatetimeTimes;

    // 资讯
    private News news;

    private Date startInteractDate;

    private Date endInteractDate;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Long getInteractDatetimeTimes() {
        return interactDatetimeTimes;
    }

    public void setInteractDatetimeTimes(Long interactDatetimeTimes) {
        this.interactDatetimeTimes = interactDatetimeTimes;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setInteracter(String interacter) {
        this.interacter = interacter;
    }

    public String getInteracter() {
        return interacter;
    }

    public void setInteractDatetime(Date interactDatetime) {
        this.interactDatetime = interactDatetime;
    }

    public Date getInteractDatetime() {
        return interactDatetime;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getStartInteractDate() {
        return startInteractDate;
    }

    public void setStartInteractDate(Date startInteractDate) {
        this.startInteractDate = startInteractDate;
    }

    public Date getEndInteractDate() {
        return endInteractDate;
    }

    public void setEndInteractDate(Date endInteractDate) {
        this.endInteractDate = endInteractDate;
    }

}
