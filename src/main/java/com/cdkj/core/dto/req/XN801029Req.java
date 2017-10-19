package com.cdkj.core.dto.req;

/**
 * 根据订单编号,详情查询评论
 * @author: asus 
 * @since: 2017年10月17日 下午8:54:27 
 * @history:
 */
public class XN801029Req {
    private String orderCode;

    // 所属公司
    private String companyCode;

    // 系统编号
    private String systemCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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
