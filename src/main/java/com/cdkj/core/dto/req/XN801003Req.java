package com.cdkj.core.dto.req;

/**
 * 上架资讯
 * @author: xieyj 
 * @since: 2017年8月31日 下午5:38:05 
 * @history:
 */
public class XN801003Req {
    // 编号(必填)
    private String code;

    // 位置(必填)
    private String location;

    // 序号(必填)
    private String orderNo;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
}
