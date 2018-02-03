package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ISYSConfigAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN660918Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 分页查询系统参数
 * @author: xieyj 
 * @since: 2016年9月17日 下午1:55:07 
 * @history:
 */
public class XN660918 extends AProcessor {
    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XN660918Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return sysConfigAO.getConfigsMap(req.getType(), req.getCompanyCode(),
            req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660918Req.class);
        StringValidater
            .validateBlank(req.getSystemCode(), req.getCompanyCode());
    }

}
