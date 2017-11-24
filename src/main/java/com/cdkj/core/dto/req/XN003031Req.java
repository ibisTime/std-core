package com.cdkj.core.dto.req;

/**
 * 使用优惠券
 * @author: asus 
 * @since: 2017年10月12日 下午3:56:57 
 * @history:
 */
public class XN003031Req {
    // 编号
    private String code;

    // 所属公司
    private String companyCode;

    // 系统编号
    private String systemCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
