package com.cdkj.core.dto.req;

/**
 * 收藏/点赞/浏览
 * @author: asus 
 * @since: 2017年9月1日 下午2:05:33 
 * @history:
 */
public class XN801030Req {

    // 类型 PRODUCT("P", "产品"), NEWS("N", "资讯"), RENT_PRODUCT("RP", "租赁产品"),
    // TRAVEL("TR", "游记");（必填）
    private String type;

    // 种类Collect("cl", "收藏"), Ds("ds", "打赏"), Dz("dz", "点赞");（必填）
    private String kind;

    // 实体编号（必填）
    private String entityCode;

    // 交互人（必填）
    private String interacter;

    // 公司编号（必填）
    private String companyCode;

    // 系统编号（必填）
    private String systemCode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    public String getInteracter() {
        return interacter;
    }

    public void setInteracter(String interacter) {
        this.interacter = interacter;
    }
}
