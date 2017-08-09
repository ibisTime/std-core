package com.std.activity.api.impl;

import com.std.activity.ao.IActivityOrderAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN660024Req;
import com.std.activity.dto.res.BooleanRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 用户申请退款
 * @author: asus 
 * @since: 2017年7月17日 下午3:07:44 
 * @history:
 */
public class XN660024 extends AProcessor {
    private IActivityOrderAO activityOrderBO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN660024Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        activityOrderBO.applyRefund(req.getOrderCode(), req.getApplyUser(),
            req.getApplyNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660024Req.class);
        StringValidater.validateBlank(req.getOrderCode(), req.getApplyUser());
    }

}
