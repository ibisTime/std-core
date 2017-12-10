package com.cdkj.core.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: xieyj 
 * @since: 2015-3-7 上午8:41:50 
 * @history:
 */
public enum ECommentType {
    PRODUCT("P", "产品"), RENT_PRODUCT("PR", "租赁产品"), TRAVEL("TR", "游记"), ACT_ANSWER(
            "AN", "活动问题");

    public static Map<String, ECommentType> getResultMap() {
        Map<String, ECommentType> map = new HashMap<String, ECommentType>();
        for (ECommentType type : ECommentType.values()) {
            map.put(type.getCode(), type);
        }
        return map;
    }

    ECommentType(String code, String value) {
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
