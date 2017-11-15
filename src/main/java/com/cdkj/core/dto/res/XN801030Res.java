package com.cdkj.core.dto.res;

public class XN801030Res {
    private String code;

    private String currency;

    private Long amount;

    public String getCode() {
        return code;
    }

    public XN801030Res() {
        super();
    }

    public XN801030Res(String code) {
        super();
        this.code = code;
    }

    public XN801030Res(String currency, Long amount) {
        super();
        this.currency = currency;
        this.amount = amount;
    }

    public XN801030Res(String code, String currency, Long amount) {
        super();
        this.code = code;
        this.currency = currency;
        this.amount = amount;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
