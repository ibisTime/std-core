package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IKeywordAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN802012Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 修改关键词
 * @author: asus 
 * @since: 2017年7月12日 下午2:41:54 
 * @history:
 */
public class XN801012 extends AProcessor {

    private IKeywordAO keywordAO = SpringContextHolder
        .getBean(IKeywordAO.class);

    private XN802012Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        keywordAO.editKeyword(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802012Req.class);
        StringValidater.validateBlank(req.getCode(), req.getWord(),
            req.getLevel(), req.getWeight(), req.getReaction(),
            req.getUpdater());
    }
}
