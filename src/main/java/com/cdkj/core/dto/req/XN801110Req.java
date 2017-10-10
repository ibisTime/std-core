package com.cdkj.core.dto.req;

/**
 * 优惠券发放
 * @author: asus 
 * @since: 2017年10月10日 下午2:34:10 
 * @history:
 */
public class XN801110Req {
    // 发放给谁（必填）
    private String toUser;

    // 面值（必填）
    private String parValue;

    // 有效期始（必填）
    private String startDatetime;

    // 有效期止（必填）
    private String endDatetime;

    // 发放人（必填）
    private String releaser;

    // 备注（选填）
    private String remark;

    // 所属公司（必填）
    private String companyCode;

    // 系统编号（必填）
    private String systemCode;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getParValue() {
        return parValue;
    }

    public void setParValue(String parValue) {
        this.parValue = parValue;
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

    public String getReleaser() {
        return releaser;
    }

    public void setReleaser(String releaser) {
        this.releaser = releaser;
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
