package com.std.activity.api.impl;

import com.std.activity.ao.IActivityAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN660001Req;
import com.std.activity.dto.res.BooleanRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 删除活动
 * @author: asus 
 * @since: 2017年7月17日 上午9:59:20 
 * @history:
 */
public class XN660001 extends AProcessor {
    private IActivityAO activityAO = SpringContextHolder
        .getBean(IActivityAO.class);

    private XN660001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        activityAO.dropActivity(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660001Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
