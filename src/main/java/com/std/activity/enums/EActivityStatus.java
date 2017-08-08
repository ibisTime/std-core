package com.std.activity.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动状态
 * @author: shan 
 * @since: 2016年12月8日 下午10:01:27 
 * @history:
 */
public enum EActivityStatus {
    DRAFT("0", "活动草稿"), ONLINE("1", "上架活动"), STOP("2", "截止"), OFFLINE("3",
            "下架活动"), BEGIN("4", "活动开始"), END("5", "活动结束");

    public static Map<String, EActivityStatus> getDictTypeMap() {
        Map<String, EActivityStatus> map = new HashMap<String, EActivityStatus>();
        for (EActivityStatus activityStatus : EActivityStatus.values()) {
            map.put(activityStatus.getCode(), activityStatus);
        }
        return map;
    }

    EActivityStatus(String code, String value) {
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
