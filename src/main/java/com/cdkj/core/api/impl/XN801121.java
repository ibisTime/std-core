package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICountryAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801121Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 详情查询国家
 * @author: asus 
 * @since: 2017年10月10日 下午2:34:10 
 * @history:
 */
public class XN801121 extends AProcessor {

    private ICountryAO countryAO = SpringContextHolder
        .getBean(ICountryAO.class);

    private XN801121Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return countryAO.getCountry(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801121Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
