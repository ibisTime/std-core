package com.cdkj.core.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动状态
 * @author: shan 
 * @since: 2016年12月8日 下午10:01:27 
 * @history:
 */
public enum ECurrencyActivityStatus {
    DRAFT("0", "活动草稿"), ONLINE("1", "上架活动"), OFFLINE("2", "下架活动");

    public static Map<String, ECurrencyActivityStatus> getDictTypeMap() {
        Map<String, ECurrencyActivityStatus> map = new HashMap<String, ECurrencyActivityStatus>();
        for (ECurrencyActivityStatus activityStatus : ECurrencyActivityStatus
            .values()) {
            map.put(activityStatus.getCode(), activityStatus);
        }
        return map;
    }

    ECurrencyActivityStatus(String code, String value) {
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
