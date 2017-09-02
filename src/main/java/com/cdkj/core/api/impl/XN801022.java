package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801022Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 删除评论
 * @author: asus 
 * @since: 2017年7月19日 下午3:08:53 
 * @history:
 */
public class XN801022 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN801022Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        commentAO.dropComment(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801022Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
