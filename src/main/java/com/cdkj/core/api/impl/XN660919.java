package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ISYSConfigAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN660919Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 
 * @author: haiqingzheng 
 * @since: 2018年7月11日 下午8:08:01 
 * @history:
 */
public class XN660919 extends AProcessor {
    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XN660919Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return sysConfigAO.queryConfigsList(req.getType(), req.getCompanyCode(),
            req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660919Req.class);
        StringValidater.validateBlank(req.getSystemCode(),
            req.getCompanyCode());
    }

}
