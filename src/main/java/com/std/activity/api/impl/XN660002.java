package com.std.activity.api.impl;

import com.std.activity.ao.IActivityAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN660002Req;
import com.std.activity.dto.res.BooleanRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 修改活动
 * @author: asus 
 * @since: 2017年7月17日 上午10:15:46 
 * @history:
 */
public class XN660002 extends AProcessor {
    private IActivityAO activityAO = SpringContextHolder
        .getBean(IActivityAO.class);

    private XN660002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        activityAO.modifyActivity(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660002Req.class);
        StringValidater.validateBlank(req.getCode(), req.getTitle(),
            req.getPic(), req.getAdvPic(), req.getSlogan(),
            req.getDescription(), req.getHoldPlace(), req.getContact(),
            req.getStartDatetime(), req.getEndDatetime(), req.getUpdater());
        StringValidater.validateAmount(req.getAmount());
        StringValidater.validateNumber(req.getTotalNum());

    }

}
