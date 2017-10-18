package com.cdkj.core.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.core.ao.IExpressRuleAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.ExpressRule;
import com.cdkj.core.dto.req.XN801925Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 快递规则分页查询
 * @author: xieyj 
 * @since: 2017年7月18日 下午2:11:07 
 * @history:
 */
public class XN801925 extends AProcessor {

    private IExpressRuleAO expressRuleAO = SpringContextHolder
        .getBean(IExpressRuleAO.class);

    private XN801925Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        ExpressRule condition = new ExpressRule();
        condition.setStartPoint(req.getStartPoint());
        condition.setEndPoint(req.getEndPoint());
        condition.setUpdater(req.getUpdater());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IExpressRuleAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return expressRuleAO.queryExpressRulePage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801925Req.class);
        StringValidater
            .validateBlank(req.getCompanyCode(), req.getSystemCode());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
