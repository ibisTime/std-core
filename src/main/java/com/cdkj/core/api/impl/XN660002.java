package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IActivityAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN660002Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

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
