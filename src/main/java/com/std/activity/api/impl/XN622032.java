package com.std.activity.api.impl;

import com.std.activity.ao.IActivityOrderAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN622032Req;
import com.std.activity.dto.res.BooleanRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 用户取消订单
 * @author: asus 
 * @since: 2017年7月17日 下午2:38:22 
 * @history:
 */
public class XN622032 extends AProcessor {
    private IActivityOrderAO activityOrderBO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN622032Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        activityOrderBO.userCancel(req.getOrderCode(), req.getApplyUser());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN622032Req.class);
        StringValidater.validateBlank(req.getOrderCode(), req.getApplyUser());
    }

}
