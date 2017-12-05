package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ITravelsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801062Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 评论游记
 * @author: xieyj 
 * @since: 2017年12月5日 上午11:36:19 
 * @history:
 */
public class XN801062 extends AProcessor {
    private ITravelsAO travelsAO = SpringContextHolder
        .getBean(ITravelsAO.class);

    private XN801062Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        travelsAO.commentTravels(req.getTravelCode(), req.getUserId(),
            req.getContent(), req.getParentCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801062Req.class);
        StringValidater.validateBlank(req.getTravelCode(), req.getUserId(),
            req.getContent(), req.getParentCode());
    }
}
