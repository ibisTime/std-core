package com.cdkj.core.dto.req;

/**
 * 详情查询产品
 * @author: asus 
 * @since: 2017年10月30日 下午1:05:32 
 * @history:
 */
public class XN004000Req {
    private String code;

    private String companyCode;

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
