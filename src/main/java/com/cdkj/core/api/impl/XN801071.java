package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IPublicityAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801071Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 详情查询宣传类活动
 * @author: asus 
 * @since: 2017年10月10日 下午1:17:24 
 * @history:
 */
public class XN801071 extends AProcessor {
    private IPublicityAO publicityAO = SpringContextHolder
        .getBean(IPublicityAO.class);

    private XN801071Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return publicityAO.getPublicity(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801071Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
