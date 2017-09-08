package com.cdkj.core.api.impl;

import org.apache.commons.lang.StringUtils;

import com.cdkj.core.ao.IInteractAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Interact;
import com.cdkj.core.dto.req.XN003001Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 分页查询收藏记录
 * @author: xieyj 
 * @since: 2017年9月5日 下午5:18:43 
 * @history:
 */
public class XN003001 extends AProcessor {
    private IInteractAO interactAO = SpringContextHolder
        .getBean(IInteractAO.class);

    private XN003001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Interact condition = new Interact();
        condition.setType(req.getType());
        condition.setEntityCode(req.getEntityCode());
        condition.setInteracter(req.getInteracter());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IInteractAO.DEFAULT_ORDER_COLUMN;
        }
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return interactAO.queryInteractPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN003001Req.class);
        StringValidater
            .validateBlank(req.getSystemCode(), req.getCompanyCode());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}
