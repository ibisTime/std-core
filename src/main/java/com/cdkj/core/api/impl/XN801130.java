package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICaigopoolAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801130Req;
import com.cdkj.core.dto.res.PKCodeRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 新增池
 * @author: chenshan 
 * @since: 2017年11月9日 上午9:34:52 
 * @history:
 */
public class XN801130 extends AProcessor {
    private ICaigopoolAO caigopoolAO = SpringContextHolder
        .getBean(ICaigopoolAO.class);

    private XN801130Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(caigopoolAO.addCaigoPool(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801130Req.class);
        StringValidater.validateBlank(req.getActivityCode(), req.getAddUser(),
            req.getCompanyCode(), req.getSystemCode());
        StringValidater.validateAmount(req.getAmount());
    }

}
