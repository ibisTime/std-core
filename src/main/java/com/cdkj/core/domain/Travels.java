package com.cdkj.core.domain;

import java.util.Date;

import com.cdkj.core.dao.base.ABaseDO;

/**
* 游记
* @author: xieyj
* @since: 2017年12月04日 19:43:33
* @history:
*/
public class Travels extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 标题(选填)
    private String title;

    // 描述
    private String description;

    // 图片
    private String pic;

    // 位置
    private String location;

    // 序号
    private String orderNo;

    // 收藏次数
    private Integer collectionTimes;

    // 点赞次数
    private Integer likeTimes;

    // 打赏次数
    private Integer dsTimes;

    // 状态
    private String status;

    // 发布人
    private String publisher;

    // 发布时间
    private Date publishDatetime;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 公司编号
    private String companyCode;

    // 系统编号
    private String systemCode;

    // ****** db properties ******
    private String userId;

    private User publishUser;// 发布人

    private Integer commentTimes;// 评论次数

    // 当前用户是否点赞
    private String isLike;

    public String getIsLike() {
        return isLike;
    }

    public void setIsLike(String isLike) {
        this.isLike = isLike;
    }

    public Integer getCommentTimes() {
        return commentTimes;
    }

    public void setCommentTimes(Integer commentTimes) {
        this.commentTimes = commentTimes;
    }

    public User getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(User publishUser) {
        this.publishUser = publishUser;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCollectionTimes() {
        return collectionTimes;
    }

    public void setCollectionTimes(Integer collectionTimes) {
        this.collectionTimes = collectionTimes;
    }

    public Integer getLikeTimes() {
        return likeTimes;
    }

    public void setLikeTimes(Integer likeTimes) {
        this.likeTimes = likeTimes;
    }

    public Integer getDsTimes() {
        return dsTimes;
    }

    public void setDsTimes(Integer dsTimes) {
        this.dsTimes = dsTimes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDatetime() {
        return publishDatetime;
    }

    public void setPublishDatetime(Date publishDatetime) {
        this.publishDatetime = publishDatetime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
