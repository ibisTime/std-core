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

    // 类型
    private String type;

    // 种类
    private String kind;

    // 实体编号
    private String entityCode;

    // 对应用户(打赏用的)
    private String toUser;

    // 交互人
    private String interacter;

    // 交互时间
    private Date interactDatetime;

    // 打赏金额
    private Long quantity;

    // 备注
    private String remark;

    // 公司编号
    private String companyCode;

    // 系统编号
    private String systemCode;

    // *************db properties**************
    // 字符日期
    private Long interactDatetimeTimes;

    // 资讯
    private News news;

    // 交互人名称
    private String interacterName;

    // 昵称
    private String nickname;

    // 头像
    private String photo;

    // 交互时间起
    private Date interactDatetimeStart;

    // 交互时间止
    private Date interactDatetimeEnd;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public Date getInteractDatetimeStart() {
        return interactDatetimeStart;
    }

    public void setInteractDatetimeStart(Date interactDatetimeStart) {
        this.interactDatetimeStart = interactDatetimeStart;
    }

    public Date getInteractDatetimeEnd() {
        return interactDatetimeEnd;
    }

    public void setInteractDatetimeEnd(Date interactDatetimeEnd) {
        this.interactDatetimeEnd = interactDatetimeEnd;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getInteracterName() {
        return interacterName;
    }

    public void setInteracterName(String interacterName) {
        this.interacterName = interacterName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

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

}
