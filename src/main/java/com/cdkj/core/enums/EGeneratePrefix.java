package com.cdkj.core.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:19:32 
 * @history:
 */
public enum EGeneratePrefix {
    News("NS", "新闻"), Interact("IN", "交互"), Publicity("PU", "宣传类活动"), Comment(
            "PL", "评论"), Keyword("GJ", "关键字"), Activity("AC", "活动"), ActivityOrder(
            "AOD", "活动订单"), CurrencyActivity("CA", "送币类活动"), Coupon("CP", "优惠券"), Caigopool(
            "CG", "兑换池");

    public static Map<String, EGeneratePrefix> getOrderTypeMap() {
        Map<String, EGeneratePrefix> map = new HashMap<String, EGeneratePrefix>();
        for (EGeneratePrefix orderType : EGeneratePrefix.values()) {
            map.put(orderType.getCode(), orderType);
        }
        return map;
    }

    EGeneratePrefix(String code, String value) {
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
