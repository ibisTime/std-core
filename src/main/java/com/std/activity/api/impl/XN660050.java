package com.std.activity.api.impl;

import com.std.activity.ao.ICommentAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN660050Req;
import com.std.activity.dto.res.PKCodeRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 评论
 * @author: asus 
 * @since: 2017年7月19日 上午11:40:38 
 * @history:
 */
public class XN660050 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN660050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(commentAO.comment(req.getContent(),
            req.getCommer(), req.getOrderCode()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660050Req.class);
        StringValidater.validateBlank(req.getOrderCode(), req.getContent(),
            req.getCommer());
    }
}
