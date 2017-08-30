package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IActivityAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN660001Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

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
