package com.cdkj.core.api.impl;

import com.cdkj.core.ao.INewsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801001Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 删除资讯
 * @author: xieyj 
 * @since: 2017年8月31日 下午5:19:22 
 * @history:
 */
public class XN801001 extends AProcessor {
    private INewsAO newsAO = SpringContextHolder.getBean(INewsAO.class);

    private XN801001Req req = null;

    /**
     * @see com.cdkj.core.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        newsAO.dropNews(req.getCode());
        return new BooleanRes(true);
    }

    /**
     * @see com.cdkj.core.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801001Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
