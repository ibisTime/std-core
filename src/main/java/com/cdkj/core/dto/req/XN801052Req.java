package com.cdkj.core.dto.req;

/**
 * 列表查询送币类活动
 * @author: asus 
 * @since: 2017年10月10日 下午2:26:24 
 * @history:
 */
public class XN801052Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 3834715350905993295L;

    // 类型（选填）
    private String type;

    // 币种（选填）
    private String currency;

    // 开始时间（选填）
    private String startDatetime;

    // 结束时间（选填）
    private String endDatetime;

    // UI位置（选填）
    private String location;

    // 状态（选填）
    private String status;

    // 公司编号（必填）
    private String companyCode;

    // 系统编号（必填）
    private String systemCode;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
