package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ITravelsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801060Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 打赏游记
 */
public class XN801060 extends AProcessor {
    private ITravelsAO travelsAO = SpringContextHolder
        .getBean(ITravelsAO.class);

    private XN801060Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long quantity = StringValidater.toLong(req.getQuantity());
        travelsAO.dsTravels(req.getUserId(), req.getTravelCode(), quantity);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801060Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getTravelCode(),
            req.getQuantity());
    }
}
