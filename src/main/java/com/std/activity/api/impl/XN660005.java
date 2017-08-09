package com.std.activity.api.impl;

import com.std.activity.ao.IActivityAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN660005Req;
import com.std.activity.dto.res.BooleanRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 截止活动
 * @author: asus 
 * @since: 2017年7月17日 上午10:47:18 
 * @history:
 */
public class XN660005 extends AProcessor {
    private IActivityAO activityAO = SpringContextHolder
        .getBean(IActivityAO.class);

    private XN660005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        activityAO.stopActivity(req.getCode(), req.getUpdater(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660005Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater());
    }
}
