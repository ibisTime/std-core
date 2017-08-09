package com.std.activity.api.impl;

import com.std.activity.ao.IKeywordAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN660046Req;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 详情查询关键字
 * @author: asus 
 * @since: 2017年7月12日 下午2:43:47 
 * @history:
 */
public class XN660046 extends AProcessor {

    private IKeywordAO keywordAO = SpringContextHolder
        .getBean(IKeywordAO.class);

    private XN660046Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return keywordAO.getKeyword(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660046Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
