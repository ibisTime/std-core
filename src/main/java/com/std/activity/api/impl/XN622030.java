package com.std.activity.api.impl;

import com.std.activity.ao.IActivityOrderAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN622030Req;
import com.std.activity.dto.res.PKCodeRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 活动报名
 * @author: asus 
 * @since: 2017年7月17日 下午1:14:54 
 * @history:
 */
public class XN622030 extends AProcessor {
    private IActivityOrderAO activityOrderBO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN622030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(activityOrderBO.addActivityOrder(
            req.getActivityCode(),
            StringValidater.toInteger(req.getQuantity()), req.getApplyUser(),
            req.getApplyNote(), req.getMobile()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN622030Req.class);
        StringValidater.validateBlank(req.getActivityCode(),
            req.getApplyUser(), req.getMobile());
        StringValidater.validateNumber(req.getQuantity());
    }

}
