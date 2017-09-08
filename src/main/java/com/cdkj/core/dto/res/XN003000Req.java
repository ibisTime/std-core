package com.cdkj.core.dto.res;

/**
 * 查询交互是否关注
 * @author: xieyj 
 * @since: 2017年9月4日 下午10:55:03 
 * @history:
 */
public class XN003000Req {

    // 用户编号
    private String userId;

    // 对象编号
    private String entityCode;

    // 交互类型
    private String interactType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getInteractType() {
        return interactType;
    }

    public void setInteractType(String interactType) {
        this.interactType = interactType;
    }
}
