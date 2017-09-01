package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IInteractAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801036Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 我的收藏详情查
 * @author: asus 
 * @since: 2017年9月1日 下午2:06:17 
 * @history:
 */
public class XN801036 extends AProcessor {
    private IInteractAO interactAO = SpringContextHolder
        .getBean(IInteractAO.class);

    private XN801036Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return interactAO.getInteract(req.getCode(), req.getCompanyCode(),
            req.getSystemCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801036Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCompanyCode(),
            req.getSystemCode());
    }

}
