package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IExpressRuleAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN003020Req;
import com.cdkj.core.dto.res.XN003020Res;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 查询快递费
 * @author: xieyj 
 * @since: 2017年7月18日 下午2:16:53 
 * @history:
 */
public class XN003020 extends AProcessor {

    private IExpressRuleAO expressRuleAO = SpringContextHolder
        .getBean(IExpressRuleAO.class);

    private XN003020Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Double weight = StringValidater.toDouble(req.getWeight());
        return new XN003020Res(expressRuleAO.getPrice(req.getStartPoint(),
            req.getEndPoint(), weight, req.getCompanyCode(),
            req.getSystemCode()));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN003020Req.class);
        StringValidater.validateBlank(req.getStartPoint(), req.getEndPoint(),
            req.getWeight(), req.getCompanyCode(), req.getSystemCode());
    }
}
