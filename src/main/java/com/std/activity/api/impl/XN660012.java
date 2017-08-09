package com.std.activity.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.activity.ao.IActivityAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.DateUtil;
import com.std.activity.common.JsonUtil;
import com.std.activity.domain.Activity;
import com.std.activity.dto.req.XN660012Req;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 查询活动
 * @author: asus 
 * @since: 2017年7月17日 上午11:02:59 
 * @history:
 */
public class XN660012 extends AProcessor {
    private IActivityAO activityAO = SpringContextHolder
        .getBean(IActivityAO.class);

    private XN660012Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Activity condition = new Activity();
        condition.setLocation(req.getLocation());
        condition.setHoldPlace(req.getHoldPlace());
        condition.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.DATA_TIME_PATTERN_2));
        condition.setEndDatetime(DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.DATA_TIME_PATTERN_2));
        condition.setStatus(req.getStatus());
        condition.setUpdater(req.getUpdater());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IActivityAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        return activityAO.queryActivityList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660012Req.class);
    }

}
