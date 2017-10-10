package com.cdkj.core.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.core.ao.ICurrencyActivityAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.DateUtil;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.CurrencyActivity;
import com.cdkj.core.dto.req.XN801052Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 列表查询送币类活动
 * @author: asus 
 * @since: 2017年10月10日 下午1:17:24 
 * @history:
 */
public class XN801052 extends AProcessor {
    private ICurrencyActivityAO currencyActivityAO = SpringContextHolder
        .getBean(ICurrencyActivityAO.class);

    private XN801052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CurrencyActivity condition = new CurrencyActivity();
        condition.setType(req.getType());
        condition.setCurrency(req.getCurrency());
        condition.setStartDatetime(DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        condition.setEndDatetime(DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        condition.setLocation(req.getLocation());
        condition.setStatus(req.getStatus());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICurrencyActivityAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        return currencyActivityAO.queryCurrencyActivityList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801052Req.class);
        StringValidater
            .validateBlank(req.getCompanyCode(), req.getSystemCode());
    }
}
