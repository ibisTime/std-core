package com.cdkj.core.dto.res;

/**
 * 获取送币活动赠送币种与数量
 * @author: asus 
 * @since: 2017年10月13日 下午4:34:51 
 * @history:
 */
public class XN003026Res {
    // 赠送币种
    private String currency;

    // 赠送数量
    private Long number;

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
