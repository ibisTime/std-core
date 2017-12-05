package com.cdkj.core.dto.req;

public class XN801060Req {
    // 用户编号(必填)
    private String userId;

    // 游记编号(必填)
    private String travelCode;

    // 数量(必填)
    private String quantity;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTravelCode() {
        return travelCode;
    }

    public void setTravelCode(String travelCode) {
        this.travelCode = travelCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
