package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ITravelsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801050Req;
import com.cdkj.core.dto.res.PKCodeRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 发布游记
 * @author: xieyj 
 * @since: 2017年12月4日 下午8:17:43 
 * @history:
 */
public class XN801050 extends AProcessor {
    private ITravelsAO travelsAO = SpringContextHolder
        .getBean(ITravelsAO.class);

    private XN801050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(travelsAO.addTravels(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801050Req.class);
        StringValidater.validateBlank(req.getDescription(), req.getPublisher(),
            req.getCompanyCode(), req.getSystemCode());
    }

}
