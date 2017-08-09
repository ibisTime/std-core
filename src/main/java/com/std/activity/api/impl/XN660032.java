package com.std.activity.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.activity.ao.IActivityOrderAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.domain.ActivityOrder;
import com.std.activity.dto.req.XN660032Req;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 分页查询我的活动订单
 * @author: asus 
 * @since: 2017年7月17日 下午3:37:09 
 * @history:
 */
public class XN660032 extends AProcessor {
    private IActivityOrderAO activityOrderBO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN660032Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ActivityOrder condition = new ActivityOrder();
        condition.setApplyUser(req.getApplyUser());
        condition.setStatus(req.getStatus());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IActivityOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return activityOrderBO.queryActivityOrderPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660032Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
