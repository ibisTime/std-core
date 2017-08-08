package com.std.activity.api.impl;

import com.std.activity.ao.IActivityOrderAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN622031Req;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 支付活动订单
 * @author: asus 
 * @since: 2017年7月17日 下午1:54:04 
 * @history:
 */
public class XN622031 extends AProcessor {
    private IActivityOrderAO activityOrderBO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN622031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return activityOrderBO.orderPay(req.getOrderCode(), req.getPayType());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN622031Req.class);
        StringValidater.validateBlank(req.getOrderCode(), req.getPayType());
    }

}
