package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801021Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 
 * @author: asus 
 * @since: 2017年7月19日 下午3:19:45 
 * @history:
 */
public class XN801021 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN801021Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        commentAO.approveComment(req.getCode(), req.getResult(),
            req.getApprover(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801021Req.class);
        StringValidater.validateBlank(req.getCode(), req.getResult(),
            req.getApprover());
    }

}
