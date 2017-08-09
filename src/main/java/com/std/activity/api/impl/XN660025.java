package com.std.activity.api.impl;

import com.std.activity.ao.IActivityOrderAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN660025Req;
import com.std.activity.dto.res.BooleanRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 审批退款
 * @author: asus 
 * @since: 2017年7月17日 下午3:25:16 
 * @history:
 */
public class XN660025 extends AProcessor {
    private IActivityOrderAO activityOrderBO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN660025Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        activityOrderBO.approveRefund(req.getOrderCode(), req.getResult(),
            req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660025Req.class);
        StringValidater.validateBlank(req.getOrderCode(), req.getResult(),
            req.getUpdater());
    }

}
