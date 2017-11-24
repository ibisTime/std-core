package com.cdkj.core.dto.req;

/**
 * 上架宣传类活动
 * @author: asus 
 * @since: 2017年10月10日 下午2:23:42 
 * @history:
 */
public class XN801063Req {
    // 编号（必填）
    private String code;

    // UI位置（必填）
    private String location;

    // 顺序（必填）
    private String orderNo;

    // 更新人（必填）
    private String updater;

    // 备注（选填）
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

}
