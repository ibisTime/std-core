package com.cdkj.core.domain;

import java.util.Date;

import com.cdkj.core.dao.base.ABaseDO;

/**
* 优惠券
* @author: shan 
* @since: 2017-10-10 11:07:30
* @history:
*/
public class Coupon extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 归属人
    private String toUser;

    // 面值
    private Integer parValue;

    // 有效期始
    private Date startDatetime;

    // 有效期止
    private Date endDatetime;

    // 使用条件类型
    private String useRange;

    // 状态
    private String status;

    // 发放人
    private String releaser;

    // 发放时间
    private Date releaseDatetime;

    // 回收人
    private String updater;

    // 回收时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 公司编号
    private String companyCode;

    // 系统编号
    private String systemCode;

    // *********db************
    // 用户
    private User user;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public Integer getParValue() {
        return parValue;
    }

    public void setParValue(Integer parValue) {
        this.parValue = parValue;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getUseRange() {
        return useRange;
    }

    public void setUseRange(String useRange) {
        this.useRange = useRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReleaser() {
        return releaser;
    }

    public void setReleaser(String releaser) {
        this.releaser = releaser;
    }

    public Date getReleaseDatetime() {
        return releaseDatetime;
    }

    public void setReleaseDatetime(Date releaseDatetime) {
        this.releaseDatetime = releaseDatetime;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
