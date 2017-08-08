package com.std.activity.api.impl;

import com.std.activity.ao.IActivityAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN622021Req;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 活动详情查询
 * @author: asus 
 * @since: 2017年7月17日 上午11:14:57 
 * @history:
 */
public class XN622021 extends AProcessor {
    private IActivityAO activityAO = SpringContextHolder
        .getBean(IActivityAO.class);

    private XN622021Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return activityAO.getActivity(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN622021Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
