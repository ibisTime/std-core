package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICurrencyActivityAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801040Req;
import com.cdkj.core.dto.res.PKCodeRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 新增送币类活动
 * @author: asus 
 * @since: 2017年10月10日 下午1:17:24 
 * @history:
 */
public class XN801040 extends AProcessor {
    private ICurrencyActivityAO currencyActivityAO = SpringContextHolder
        .getBean(ICurrencyActivityAO.class);

    private XN801040Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(currencyActivityAO.addCurrencyActivity(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801040Req.class);
        StringValidater.validateBlank(req.getType(), req.getDescription(),
            req.getStartDatetime(), req.getEndDatetime(), req.getCurrency(),
            req.getUpdater(), req.getCompanyCode(), req.getSystemCode());
        StringValidater.validateNumber(req.getNumber());
    }

}
