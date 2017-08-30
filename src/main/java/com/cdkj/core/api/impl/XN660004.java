package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IActivityAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN660004Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 下架活动
 * @author: asus 
 * @since: 2017年7月17日 上午10:42:23 
 * @history:
 */
public class XN660004 extends AProcessor {
    private IActivityAO activityAO = SpringContextHolder
        .getBean(IActivityAO.class);

    private XN660004Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        activityAO.downActivity(req.getCode(), req.getUpdater(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660004Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater());
    }

}
