package com.cdkj.core.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.core.ao.ICouponAO;
import com.cdkj.core.ao.IPublicityAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.DateUtil;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Coupon;
import com.cdkj.core.dto.req.XN801115Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 分页查询优惠券
 * @author: asus 
 * @since: 2017年10月10日 下午2:34:10 
 * @history:
 */
public class XN801115 extends AProcessor {
    private ICouponAO couponAO = SpringContextHolder.getBean(ICouponAO.class);

    private XN801115Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Coupon condition = new Coupon();
        condition.setToUser(req.getToUser());
        condition.setStatus(req.getStatus());
        condition.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        condition.setEndDatetime(DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IPublicityAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return couponAO.queryCouponPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801115Req.class);
        StringValidater
            .validateBlank(req.getCompanyCode(), req.getSystemCode());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
