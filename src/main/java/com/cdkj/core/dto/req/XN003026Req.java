package com.cdkj.core.dto.req;

/**
 * 根据type获取币种和数量
 * @author: asus 
 * @since: 2017年10月12日 上午10:05:35 
 * @history:
 */
public class XN003026Req {
    // 活动编号
    private String activityCode;

    // 类型
    private String type;

    // 所属公司
    private String companyCode;

    // 系统编号
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

}
