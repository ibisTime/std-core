package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICouponAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN003031Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

public class XN003031 extends AProcessor {
    private ICouponAO couponAO = SpringContextHolder.getBean(ICouponAO.class);

    private XN003031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        couponAO.useCoupon(req.getCode(), req.getCompanyCode(),
            req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN003031Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCompanyCode(),
            req.getSystemCode());
    }
}
