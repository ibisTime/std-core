package com.cdkj.core.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 优惠券状态
 * @author: shan 
 * @since: 2016年12月8日 下午10:01:27 
 * @history:
 */
public enum ECouponStatus {
    Unused("0", "未使用"), Used("1", "已使用"), Recovery("2", "已回收"), Past_due("3",
            "已过期");

    public static Map<String, ECouponStatus> getDictTypeMap() {
        Map<String, ECouponStatus> map = new HashMap<String, ECouponStatus>();
        for (ECouponStatus activityStatus : ECouponStatus.values()) {
            map.put(activityStatus.getCode(), activityStatus);
        }
        return map;
    }

    ECouponStatus(String code, String value) {
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
