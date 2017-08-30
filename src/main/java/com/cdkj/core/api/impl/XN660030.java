package com.cdkj.core.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.core.ao.IActivityOrderAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.DateUtil;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.ActivityOrder;
import com.cdkj.core.dto.req.XN660030Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 分页查询订单
 * @author: asus 
 * @since: 2017年7月17日 下午3:37:09 
 * @history:
 */
public class XN660030 extends AProcessor {
    private IActivityOrderAO activityOrderBO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN660030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ActivityOrder condition = new ActivityOrder();
        condition.setApplyUser(req.getApplyUser());
        condition.setMobile(req.getMobile());
        condition.setActivityCode(req.getActivityCode());
        condition.setStatusList(req.getStatusList());
        condition.setActivityTitle(req.getActivityTitle());
        condition.setCreateBeginDatetime(DateUtil.strToDate(
            req.getApplyBeginDatetime(), DateUtil.DATA_TIME_PATTERN_1));
        condition.setCreateEndDatetime(DateUtil.strToDate(
            req.getApplyEndDatetime(), DateUtil.DATA_TIME_PATTERN_1));
        condition.setStatus(req.getStatus());
        condition.setUpdater(req.getUpdater());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IActivityOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return activityOrderBO.queryActivityOrderPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660030Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
