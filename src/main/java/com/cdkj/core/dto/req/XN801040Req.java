package com.cdkj.core.dto.req;

/**
 * 新增送币类活动
 * @author: asus 
 * @since: 2017年10月10日 下午1:17:24 
 * @history:
 */
public class XN801040Req {
    // 类型(必填)
    private String type;

    // 标题(必填)
    private String title;

    // 缩率图(必填)
    private String advPic;

    // 广告语(必填)
    private String slogn;

    // 图文详情(必填)
    private String description;

    // 开始时间(必填)
    private String startDatetime;

    // 结束时间(必填)
    private String endDatetime;

    // 币种(必填)
    private String currency;

    // 赠送数量(必填)
    private String number;

    // 间接推荐人赠送数量
    private String indirectNumber;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

    // 公司编号(必填)
    private String companyCode;

    // 系统编号(必填)
    private String systemCode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public String getIndirectNumber() {
        return indirectNumber;
    }

    public void setIndirectNumber(String indirectNumber) {
        this.indirectNumber = indirectNumber;
    }

    public String getSlogn() {
        return slogn;
    }

    public void setSlogn(String slogn) {
        this.slogn = slogn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
