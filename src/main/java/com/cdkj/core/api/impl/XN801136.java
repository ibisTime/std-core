package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICaigopoolAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801136Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 详情查询奖池
 * @author: chenshan 
 * @since: 2017年11月9日 下午5:26:55 
 * @history:
 */
public class XN801136 extends AProcessor {
    private ICaigopoolAO caigopoolAO = SpringContextHolder
        .getBean(ICaigopoolAO.class);

    private XN801136Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return caigopoolAO.getCaigopool(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801136Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
