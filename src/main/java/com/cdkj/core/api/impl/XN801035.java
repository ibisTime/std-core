package com.cdkj.core.api.impl;

import org.apache.commons.lang.StringUtils;

import com.cdkj.core.ao.IInteractAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Interact;
import com.cdkj.core.dto.req.XN801035Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 交互分页查询
 * @author: xieyj 
 * @since: 2017年12月5日 下午10:35:40 
 * @history:
 */
public class XN801035 extends AProcessor {
    private IInteractAO interactAO = SpringContextHolder
        .getBean(IInteractAO.class);

    private XN801035Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Interact condition = new Interact();
        condition.setType(req.getType());
        condition.setKind(req.getKind());
        condition.setEntityCode(req.getEntityCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IInteractAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return interactAO.queryFrontInteractPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801035Req.class);
        StringValidater.validateBlank(req.getType(), req.getKind(),
            req.getSystemCode(), req.getCompanyCode());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
