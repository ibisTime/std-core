package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IActivityOrderAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN660024Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

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
