package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICouponAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801111Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 优惠券回收
 * @author: asus 
 * @since: 2017年10月10日 下午2:34:10 
 * @history:
 */
public class XN801111 extends AProcessor {
    private ICouponAO couponAO = SpringContextHolder.getBean(ICouponAO.class);

    private XN801111Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        couponAO.recoveryCoupon(req.getCode(), req.getUpdater(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801111Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater());
    }
}
