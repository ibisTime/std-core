package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICouponAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN003030Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 检验优惠券是否过期
 * @author: asus 
 * @since: 2017年10月12日 上午10:13:44 
 * @history:
 */
public class XN003030 extends AProcessor {
    private ICouponAO couponAO = SpringContextHolder.getBean(ICouponAO.class);

    private XN003030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return couponAO.checkCoupon(req.getCode(), req.getCompanyCode(),
            req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN003030Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCompanyCode(),
            req.getSystemCode());
    }

}
