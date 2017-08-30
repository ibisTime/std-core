package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IActivityOrderAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN622020Req;
import com.cdkj.core.dto.res.PKCodeRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 活动报名
 * @author: asus 
 * @since: 2017年7月17日 下午1:14:54 
 * @history:
 */
public class XN660020 extends AProcessor {
    private IActivityOrderAO activityOrderBO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN622020Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(activityOrderBO.addActivityOrder(
            req.getActivityCode(),
            StringValidater.toInteger(req.getQuantity()), req.getApplyUser(),
            req.getApplyNote(), req.getMobile()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN622020Req.class);
        StringValidater.validateBlank(req.getActivityCode(),
            req.getApplyUser(), req.getMobile());
        StringValidater.validateNumber(req.getQuantity());
    }

}
