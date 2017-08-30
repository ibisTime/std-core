package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IActivityOrderAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN660025Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

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
