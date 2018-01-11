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
public enum EInteractKind {
    Collect("cl", "收藏"), Ds("ds", "打赏"), Dz("dz", "点赞");

    public static Map<String, EInteractKind> getMap() {
        Map<String, EInteractKind> map = new HashMap<String, EInteractKind>();
        for (EInteractKind direction : EInteractKind.values()) {
            map.put(direction.getCode(), direction);
        }
        return map;
    }

    EInteractKind(String code, String value) {
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
