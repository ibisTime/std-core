package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801020Req;
import com.cdkj.core.dto.res.PKCodeRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 评论
 * @author: xieyj 
 * @since: 2017年9月1日 下午12:31:46 
 * @history:
 */
public class XN801020 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN801020Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(commentAO.comment(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801020Req.class);
        StringValidater.validateBlank(req.getType(), req.getContent(),
            req.getCommenter(), req.getCommenterName(), req.getParentCode(),
            req.getEntityCode(), req.getEntityName(), req.getCompanyCode(),
            req.getSystemCode());
    }
}
