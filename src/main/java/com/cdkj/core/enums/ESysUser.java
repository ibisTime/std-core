package com.cdkj.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum ESysUser {
    SYS_USER_ZWZJ("SYS_USER_ZWZJ", "自玩自健系统账号"), SYS_USER_CAIGO(
            "SYS_USER_CAIGO", "菜狗系统账号");

    public static Map<String, ESysUser> getResultMap() {
        Map<String, ESysUser> map = new HashMap<String, ESysUser>();
        for (ESysUser sysUser : ESysUser.values()) {
            map.put(sysUser.getCode(), sysUser);
        }
        return map;
    }

    ESysUser(String code, String value) {
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
