package com.std.activity.api.impl;

import com.std.activity.ao.IKeywordAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN660040Req;
import com.std.activity.dto.res.PKCodeRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 新增关键词
 * @author: asus 
 * @since: 2017年7月12日 下午2:40:44 
 * @history:
 */
public class XN660040 extends AProcessor {

    private IKeywordAO keywordAO = SpringContextHolder
        .getBean(IKeywordAO.class);

    private XN660040Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(keywordAO.addKeyword(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660040Req.class);
        StringValidater.validateBlank(req.getWord(), req.getLevel(),
            req.getWeight(), req.getReaction(), req.getUpdater());
    }
}
