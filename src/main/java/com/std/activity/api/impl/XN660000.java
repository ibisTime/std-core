package com.std.activity.api.impl;

import com.std.activity.ao.IActivityAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN660000Req;
import com.std.activity.dto.res.PKCodeRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 新增活动
 * @author: asus 
 * @since: 2017年7月17日 上午9:38:43 
 * @history:
 */
public class XN660000 extends AProcessor {
    private IActivityAO activityAO = SpringContextHolder
        .getBean(IActivityAO.class);

    private XN660000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(activityAO.addNewActivity(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660000Req.class);
        StringValidater.validateBlank(req.getTitle(), req.getPic(),
            req.getAdvPic(), req.getSlogan(), req.getDescription(),
            req.getHoldPlace(), req.getContact(), req.getStartDatetime(),
            req.getEndDatetime(), req.getUpdater());
        StringValidater.validateAmount(req.getAmount());
        StringValidater.validateNumber(req.getTotalNum());
    }
}
