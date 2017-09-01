package com.cdkj.core.api.impl;

import com.cdkj.core.ao.INewsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801006Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 查询资讯详情
 * @author: xieyj 
 * @since: 2017年8月31日 下午5:51:40 
 * @history:
 */
public class XN801006 extends AProcessor {
    private INewsAO newsAO = SpringContextHolder.getBean(INewsAO.class);

    private XN801006Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return newsAO.getNews(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801006Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
