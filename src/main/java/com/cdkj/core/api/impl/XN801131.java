package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICaigopoolAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801131Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 入金
 * @author: myb858 
 * @since: 2017年3月28日 下午5:35:39 
 * @history:
 */
public class XN801131 extends AProcessor {
    private ICaigopoolAO caigopoolAO = SpringContextHolder
        .getBean(ICaigopoolAO.class);

    private XN801131Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        caigopoolAO.addAmount(req.getCode(),
            StringValidater.toLong(req.getCzAmount()),
            StringValidater.toLong(req.getAmount()), req.getAddUser(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801131Req.class);
        StringValidater.validateBlank(req.getCode(), req.getAddUser());
        StringValidater.validateAmount(req.getAmount(), req.getCzAmount());
    }

}
