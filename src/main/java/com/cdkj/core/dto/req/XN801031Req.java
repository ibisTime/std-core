package com.cdkj.core.dto.req;

/**
 * 取消收藏/点赞/浏览
 * @author: asus 
 * @since: 2017年9月1日 下午2:04:59 
 * @history:
 */
public class XN801031Req {
    // 实体类型（必填）
    private String category;

    // 类型(1 点赞 2 收藏 3 浏览)（必填）
    private String type;

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

    public String getInteracter() {
        return interacter;
    }

    public void setInteracter(String interacter) {
        this.interacter = interacter;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
