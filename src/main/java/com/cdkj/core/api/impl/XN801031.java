package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IInteractAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801031Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 
 * @author: asus 
 * @since: 2017年9月1日 下午9:46:44 
 * @history:
 */
public class XN801031 extends AProcessor {
    private IInteractAO interactAO = SpringContextHolder
        .getBean(IInteractAO.class);

    private XN801031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        interactAO.dropInteract(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801031Req.class);
        StringValidater.validateBlank(req.getType(), req.getEntityCode(),
            req.getInteracter(), req.getCompanyCode(), req.getSystemCode());
    }

}
