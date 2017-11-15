package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICurrencyActivityAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801042Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 修改送币类活动
 * @author: asus 
 * @since: 2017年10月10日 下午1:17:24 
 * @history:
 */
public class XN801042 extends AProcessor {
    private ICurrencyActivityAO currencyActivityAO = SpringContextHolder
        .getBean(ICurrencyActivityAO.class);

    private XN801042Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        currencyActivityAO.editCurrencyActivity(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801042Req.class);
        StringValidater.validateBlank(req.getCode(), req.getType(),
            req.getTitle(), req.getAdvPic(), req.getSlogn(),
            req.getDescription(), req.getStartDatetime(), req.getEndDatetime(),
            req.getCurrency(), req.getUpdater());
        StringValidater.validateNumber(req.getNumber());
    }

}
