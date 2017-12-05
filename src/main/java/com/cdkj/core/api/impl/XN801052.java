package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ITravelsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801052Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 修改游记
 * @author: xieyj 
 * @since: 2017年12月4日 下午8:31:33 
 * @history:
 */
public class XN801052 extends AProcessor {
    private ITravelsAO travelsAO = SpringContextHolder
        .getBean(ITravelsAO.class);

    private XN801052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        travelsAO.editTravels(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801052Req.class);
        StringValidater.validateBlank(req.getCode(), req.getDescription(),
            req.getPublisher());
    }
}
