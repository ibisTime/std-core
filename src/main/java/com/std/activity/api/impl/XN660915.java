package com.std.activity.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.activity.ao.ISYSConfigAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.domain.SYSConfig;
import com.std.activity.dto.req.XN660915Req;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 分页查询系统参数
 * @author: xieyj 
 * @since: 2016年9月17日 下午1:55:07 
 * @history:
 */
public class XN660915 extends AProcessor {
    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XN660915Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSConfig condition = new SYSConfig();
        condition.setType(req.getType());
        condition.setCkeyForQuery(req.getCkey());
        condition.setSystemCode(req.getSystemCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISYSConfigAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return sysConfigAO.querySYSConfigPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660915Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
        StringValidater.validateBlank(req.getSystemCode());
    }

}
