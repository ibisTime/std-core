package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IExpressRuleAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801926Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 快递规则详情
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN801926 extends AProcessor {

    private IExpressRuleAO expressRuleAO = SpringContextHolder
        .getBean(IExpressRuleAO.class);

    private XN801926Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Long id = StringValidater.toLong(req.getId());
        return expressRuleAO.getExpressRule(id);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801926Req.class);
        StringValidater.validateBlank(req.getId());
    }
}
