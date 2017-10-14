package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICurrencyActivityAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN003026Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 根据类型获取币种和数量
 * @author: asus 
 * @since: 2017年10月13日 下午5:11:47 
 * @history:
 */
public class XN003026 extends AProcessor {
    private ICurrencyActivityAO currencyActivityAO = SpringContextHolder
        .getBean(ICurrencyActivityAO.class);

    private XN003026Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return currencyActivityAO.getCurrencyActivity(req.getType(),
            req.getCompanyCode(), req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN003026Req.class);
        StringValidater.validateBlank(req.getType(), req.getCompanyCode(),
            req.getSystemCode());
    }

}
