package com.cdkj.core.dto.req;

/**
 * 我的收藏详情查
 * @author: asus 
 * @since: 2017年9月1日 下午2:06:17 
 * @history:
 */
public class XN801036Req {
    // 编号（必填）
    private String code;

    // 公司编号（选填）
    private String companyCode;

    // 系统编号（必填）
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
