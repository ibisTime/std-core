package com.cdkj.core.api.impl;

import com.cdkj.core.ao.INewsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801004Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 下架资讯
 * @author: xieyj 
 * @since: 2017年8月31日 下午5:43:19 
 * @history:
 */
public class XN801004 extends AProcessor {
    private INewsAO newsAO = SpringContextHolder.getBean(INewsAO.class);

    private XN801004Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        newsAO.putOff(req.getCode(), req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801004Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater());
    }

}
