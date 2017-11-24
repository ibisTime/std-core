package com.cdkj.core.dto.res;

/**
 * 检验充值送活动是否过期
 * @author: asus 
 * @since: 2017年10月12日 上午10:31:46 
 * @history:
 */
public class XN003025Res {
    private String type;

    private String currency;

    private Long number;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

}
