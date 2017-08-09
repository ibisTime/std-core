package com.std.activity.api.impl;

import com.std.activity.ao.IActivityOrderAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN660031Req;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 详情查询订单
 * @author: asus 
 * @since: 2017年7月17日 下午4:04:28 
 * @history:
 */
public class XN660031 extends AProcessor {
    private IActivityOrderAO activityOrderBO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN660031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return activityOrderBO.getActivityOrder(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660031Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
