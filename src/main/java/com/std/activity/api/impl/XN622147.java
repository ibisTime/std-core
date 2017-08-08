package com.std.activity.api.impl;

import com.std.activity.ao.ICommentAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.dto.req.XN622147Req;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 详情查询评论
 * @author: asus 
 * @since: 2017年7月19日 下午3:48:36 
 * @history:
 */
public class XN622147 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN622147Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return commentAO.avgCommentScore(req.getCoachCode(),
            req.getProductCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN622147Req.class);
    }

}
