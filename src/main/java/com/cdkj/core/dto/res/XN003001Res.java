package com.cdkj.core.dto.res;

public class XN003001Res {

    // 编号
    private String code;

    // 类型(1 点赞 2 收藏 3 浏览)
    private String type;

    // 实体编号
    private String entityCode;

    // 交互人
    private String interacter;

    // 交互时间
    private String interactDatetime;

    // 公司编号
    private String companyCode;

    // 系统编号
    private String systemCode;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setInteracter(String interacter) {
        this.interacter = interacter;
    }

    public String getInteracter() {
        return interacter;
    }

    public void setInteractDatetime(String interactDatetime) {
        this.interactDatetime = interactDatetime;
    }

    public String getInteractDatetime() {
        return interactDatetime;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemCode() {
        return systemCode;
    }
}
