package com.cdkj.core.dto.req;

/**
 * 新增池
 * @author: myb858 
 * @since: 2017年3月28日 下午5:35:39 
 * @history:
 */
public class XN801130Req {

    // 名称(必填)
    private String activityCode;

    // 金额
    private String czAmount;

    // 金额
    private String amount;

    // 最近入金人
    private String addUser;

    // 备注
    private String remark;

    // 所属公司编号
    private String companyCode;

    // 所属系统编号
    private String systemCode;

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

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getCzAmount() {
        return czAmount;
    }

    public void setCzAmount(String czAmount) {
        this.czAmount = czAmount;
    }

}
