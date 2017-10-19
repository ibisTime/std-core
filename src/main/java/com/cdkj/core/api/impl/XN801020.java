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
 * @author: asus 
 * @since: 2017年7月19日 下午3:19:45 
 * @history:
 */
public class XN801020 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN801020Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(commentAO.comment(req.getType(),
            req.getOrderCode(), req.getEntityCode(), req.getEntityName(),
            req.getParentCode(), req.getContent(), req.getCommenter(),
            req.getCommenterName(), req.getCompanyCode(), req.getSystemCode()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801020Req.class);
        StringValidater.validateBlank(req.getCommenter(), req.getCompanyCode(),
            req.getSystemCode());
    }

}
