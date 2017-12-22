package com.cdkj.core.enums;

public enum EUserKind {
    Customer("C", "C端用户"), Merchant("B", "B端用户"), Plat("P", "平台用户"),

    // 正汇,来来旺旺,户外电商
    Partner("PA", "合伙人"), OUT_LEADER("OL", "活动领队");

    EUserKind(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
