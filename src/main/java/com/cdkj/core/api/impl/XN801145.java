package com.cdkj.core.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.core.ao.ICaigopoolBackAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.CaigopoolBack;
import com.cdkj.core.dto.req.XN801145Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 分页查询奖池领取情况
 * @author: myb858 
 * @since: 2017年3月28日 下午5:35:39 
 * @history:
 */
public class XN801145 extends AProcessor {
    private ICaigopoolBackAO caigopoolBackAO = SpringContextHolder
        .getBean(ICaigopoolBackAO.class);

    private XN801145Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CaigopoolBack condition = new CaigopoolBack();
        condition.setPoolCode(req.getPoolCode());
        condition.setActivityCode(req.getActivityCode());
        condition.setToUser(req.getToUser());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICaigopoolBackAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return caigopoolBackAO.queryCaigopoolBackPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801145Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
        StringValidater
            .validateBlank(req.getCompanyCode(), req.getSystemCode());
    }

}
