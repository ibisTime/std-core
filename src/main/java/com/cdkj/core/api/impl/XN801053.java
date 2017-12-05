package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ITravelsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801053Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 审核游记
 * @author: asus 
 * @since: 2017年2月11日 下午9:40:13 
 * @history:
 */
public class XN801053 extends AProcessor {
    private ITravelsAO travelsAO = SpringContextHolder
        .getBean(ITravelsAO.class);

    private XN801053Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        travelsAO.approveTravels(req.getCode(), req.getApprovelResult(),
            req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801053Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater(),
            req.getApprovelResult());
    }
}
