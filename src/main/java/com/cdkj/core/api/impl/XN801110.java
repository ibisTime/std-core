package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICouponAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801110Req;
import com.cdkj.core.dto.res.PKCodeRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 优惠券发放
 * @author: asus 
 * @since: 2017年10月10日 下午2:34:10 
 * @history:
 */
public class XN801110 extends AProcessor {
    private ICouponAO couponAO = SpringContextHolder.getBean(ICouponAO.class);

    private XN801110Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(couponAO.addCoupon(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801110Req.class);
        StringValidater.validateBlank(req.getToUser(), req.getStartDatetime(),
            req.getEndDatetime(), req.getReleaser(), req.getCompanyCode(),
            req.getSystemCode());
        StringValidater.validateNumber(req.getParValue());
    }

}
