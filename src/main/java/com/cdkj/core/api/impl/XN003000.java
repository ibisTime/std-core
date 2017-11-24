package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IInteractAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN003000Req;
import com.cdkj.core.dto.res.FlagRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 查询交互是否关注
 * @author: xieyj 
 * @since: 2017年9月4日 下午10:54:11 
 * @history:
 */
public class XN003000 extends AProcessor {
    private IInteractAO interactAO = SpringContextHolder
        .getBean(IInteractAO.class);

    private XN003000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new FlagRes(interactAO.isInteract(req.getUserId(),
            req.getInteractCategory(), req.getInteractType(),
            req.getEntityCode(), req.getCompanyCode(), req.getSystemCode()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN003000Req.class);
        StringValidater.validateBlank(req.getUserId(),
            req.getInteractCategory(), req.getInteractType(),
            req.getEntityCode(), req.getCompanyCode(), req.getSystemCode());
    }
}
