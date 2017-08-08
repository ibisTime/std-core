package com.std.activity.api.impl;

import com.std.activity.ao.IActivityOrderAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN622017Req;
import com.std.activity.dto.res.BooleanRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 结束活动
 * @author: asus 
 * @since: 2017年7月17日 上午10:47:18 
 * @history:
 */
public class XN622017 extends AProcessor {
    private IActivityOrderAO activityOrderAO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN622017Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        activityOrderAO.endActivity(req.getCode(), req.getUpdater(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN622017Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater());
    }
}