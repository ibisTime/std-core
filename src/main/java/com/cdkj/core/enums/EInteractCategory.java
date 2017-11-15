/**
 * @Title EDirection.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午3:37:06 
 * @version V1.0   
 */
package com.cdkj.core.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午3:37:06 
 * @history:
 */
public enum EInteractCategory {
    PRODUCT("P", "产品"), NEWS("N", "资讯"), RENT_PRODUCT("RP", "租赁产品"), ACTIVITY(
            "A", "活动");
    public static Map<String, EInteractCategory> getMap() {
        Map<String, EInteractCategory> map = new HashMap<String, EInteractCategory>();
        for (EInteractCategory direction : EInteractCategory.values()) {
            map.put(direction.getCode(), direction);
        }
        return map;
    }

    EInteractCategory(String code, String value) {
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
