package com.cdkj.core.dto.req;

import java.util.List;

public class XN801920Req {
    // 编号(必填)
    private List<String> idList;

    // 首重(必填)
    private String startWeight;

    // 首重价格(必填)
    private String startPrice;

    // 递增重量(必填)
    private String addWeight;

    // 递增价格(必填)
    private String addPrice;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

    // 所属公司编号(必填)
    private String companyCode;

    // 系统编号(必填)
    private String systemCode;

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public String getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(String startWeight) {
        this.startWeight = startWeight;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getAddWeight() {
        return addWeight;
    }

    public void setAddWeight(String addWeight) {
        this.addWeight = addWeight;
    }

    public String getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(String addPrice) {
        this.addPrice = addPrice;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
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
