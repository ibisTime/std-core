package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IPublicityAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801062Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 修改宣传类活动
 * @author: asus 
 * @since: 2017年10月10日 下午1:17:24 
 * @history:
 */
public class XN801062 extends AProcessor {
    private IPublicityAO publicityAO = SpringContextHolder
        .getBean(IPublicityAO.class);

    private XN801062Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        publicityAO.editPublicity(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801062Req.class);
        StringValidater.validateBlank(req.getCode(), req.getType(),
            req.getAdvPic(), req.getDescription(), req.getStartDatetime(),
            req.getEndDatetime(), req.getUpdater());
    }

}
