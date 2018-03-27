package com.cdkj.core.api.impl;

import com.cdkj.core.ao.INewsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801000Req;
import com.cdkj.core.dto.res.PKCodeRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 新增资讯
 * @author: xieyj 
 * @since: 2017年8月31日 下午5:06:17 
 * @history:
 */
public class XN801000 extends AProcessor {
    private INewsAO newsAO = SpringContextHolder.getBean(INewsAO.class);

    private XN801000Req req = null;

    /**
     * @see com.cdkj.ride.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(newsAO.addNews(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801000Req.class);
        StringValidater.validateBlank(req.getType(), req.getTitle(),
            req.getAdvPic(), req.getContent(), req.getUpdater(),
            req.getCompanyCode(), req.getSystemCode());
    }
}
