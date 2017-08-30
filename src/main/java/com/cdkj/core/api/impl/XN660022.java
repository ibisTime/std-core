package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IActivityOrderAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN660022Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 用户取消订单
 * @author: asus 
 * @since: 2017年7月17日 下午2:38:22 
 * @history:
 */
public class XN660022 extends AProcessor {
    private IActivityOrderAO activityOrderBO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN660022Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        activityOrderBO.userCancel(req.getOrderCode(), req.getApplyUser());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660022Req.class);
        StringValidater.validateBlank(req.getOrderCode(), req.getApplyUser());
    }

}
