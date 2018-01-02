package com.cdkj.core.enums;

public enum ETravelsStatus {
    TO_PUBLISH("0", "新增游记"), PUBLISH_YES("1", "审核通过"), PUBLISH_NO("2", "审核不通过");

    ETravelsStatus(String code, String value) {
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
