package com.cdkj.core.dto.req;

/**
 * 入金
 * @author: myb858 
 * @since: 2017年3月28日 下午5:35:39 
 * @history:
 */
public class XN801131Req {

    // 编号(必填)
    private String code;

    // 金额
    private String czAmount;

    // 金额
    private String amount;

    // 最近入金人
    private String addUser;

    // 备注
    private String remark;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCzAmount() {
        return czAmount;
    }

    public void setCzAmount(String czAmount) {
        this.czAmount = czAmount;
    }

}
