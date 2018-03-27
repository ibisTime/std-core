package com.cdkj.core.api.impl;

import com.cdkj.core.ao.INewsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801002Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 修改资讯
 * @author: xieyj 
 * @since: 2017年8月31日 下午7:00:37 
 * @history:
 */
public class XN801002 extends AProcessor {
    private INewsAO newsAO = SpringContextHolder.getBean(INewsAO.class);

    private XN801002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        newsAO.editNews(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801002Req.class);
        StringValidater.validateBlank(req.getCode(), req.getTitle(),
            req.getAdvPic(), req.getContent(), req.getUpdater());
    }

}
