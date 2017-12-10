package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801020Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 评论
 * @author: xieyj 
 * @since: 2017年12月10日 下午10:12:21 
 * @history:
 */
public class XN801020 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN801020Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        commentAO.comment(req.getEntityCode(), req.getType(), req.getUserId(),
            req.getContent(), req.getParentCode(), req.getCompanyCode(),
            req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801020Req.class);
        StringValidater.validateBlank(req.getEntityCode(), req.getType(),
            req.getUserId(), req.getContent(), req.getParentCode(),
            req.getCompanyCode(), req.getSystemCode());
    }

}
