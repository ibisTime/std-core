package com.std.activity.api.impl;

import com.std.activity.ao.ICommentAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN660051Req;
import com.std.activity.dto.res.BooleanRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 删除评论
 * @author: asus 
 * @since: 2017年7月19日 下午3:08:53 
 * @history:
 */
public class XN660051 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN660051Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        commentAO.dropComment(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660051Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
