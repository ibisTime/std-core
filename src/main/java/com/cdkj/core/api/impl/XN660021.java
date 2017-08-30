package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IActivityOrderAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN660021Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 支付活动订单
 * @author: asus 
 * @since: 2017年7月17日 下午1:54:04 
 * @history:
 */
public class XN660021 extends AProcessor {
    private IActivityOrderAO activityOrderBO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN660021Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return activityOrderBO.orderPay(req.getOrderCode(), req.getPayType());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660021Req.class);
        StringValidater.validateBlank(req.getOrderCode(), req.getPayType());
    }

}
