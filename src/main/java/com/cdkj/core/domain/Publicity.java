package com.cdkj.core.domain;

import java.util.Date;

import com.cdkj.core.dao.base.ABaseDO;

/**
* 宣传类活动
* @author: shan 
* @since: 2017-10-10 10:37:34
* @history:
*/
public class Publicity extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型
    private String type;

    // 图片
    private String advPic;

    // 图文详情
    private String description;

    // 开始时间
    private Date startDatetime;

    // 结束时间
    private Date endDatetime;

    // value1
    private Double value1;

    // value2
    private Double value2;

    // value3
    private Double value3;

    // UI位置
    private String location;

    // 顺序
    private Integer orderNo;

    // 状态
    private String status;

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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setValue1(Double value1) {
        this.value1 = value1;
    }

    public Double getValue1() {
        return value1;
    }

    public void setValue2(Double value2) {
        this.value2 = value2;
    }

    public Double getValue2() {
        return value2;
    }

    public void setValue3(Double value3) {
        this.value3 = value3;
    }

    public Double getValue3() {
        return value3;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
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

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

}
