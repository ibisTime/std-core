package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN003040Req;
import com.cdkj.core.dto.res.XN003040Res;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 统计某件商品的评论数量
 * @author: asus 
 * @since: 2017年7月19日 下午3:48:36 
 * @history:
 */
public class XN003040 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN003040Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long totalComment = commentAO.totalComment(req.getEntityCode(),
            req.getCompanyCode(), req.getSystemCode());
        XN003040Res res = new XN003040Res();
        res.setTotalComment(totalComment);
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN003040Req.class);
        StringValidater.validateBlank(req.getEntityCode(),
            req.getCompanyCode(), req.getSystemCode());
    }

}
