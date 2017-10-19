package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801029Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

public class XN801029 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN801029Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return commentAO.getCommentByOrderCode(req.getOrderCode(),
            req.getCompanyCode(), req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801029Req.class);
        StringValidater.validateBlank(req.getOrderCode(), req.getCompanyCode(),
            req.getSystemCode());
    }

}
