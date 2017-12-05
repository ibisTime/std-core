/**
 * @Title OrderNoGenerater.java 
 * @Package com.ibis.account.core 
 * @Description 
 * @author miyb  
 * @date 2015-5-5 下午1:13:04 
 * @version V1.0   
 */
package com.cdkj.core.core;

import java.util.Random;

import com.cdkj.core.common.DateUtil;

/** 
 * @author: miyb 
 * @since: 2015-5-5 下午1:13:04 
 * @history:
 */
public class OrderNoGenerater {

    public static String generateME(String prefix) {
        int random = Math.abs(new Random().nextInt()) % 10000;
        String today = DateUtil.getToday(DateUtil.DATA_TIME_PATTERN_4);
        return prefix + today + String.valueOf(random);
    }
}
