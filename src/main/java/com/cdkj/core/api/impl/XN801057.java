package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ITravelsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.DateUtil;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Travels;
import com.cdkj.core.dto.req.XN801057Req;
import com.cdkj.core.enums.ETravelsStatus;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 前端分页查询已审核通过的游记
 * @author: xieyj 
 * @since: 2017年12月4日 下午8:49:31 
 * @history:
 */
public class XN801057 extends AProcessor {
    private ITravelsAO travelsAO = SpringContextHolder
        .getBean(ITravelsAO.class);

    private XN801057Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Travels condition = new Travels();
        condition.setUserId(req.getUserId());
        condition.setRunTeamList(req.getRunTeamList());
        condition.setStatus(ETravelsStatus.TO_PUBLISH.getCode());
        condition.setPublishDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        condition.setPublishDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        condition.setOrder("publish_datetime", "desc");
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return travelsAO.queryFrontTravelsPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801057Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
        StringValidater
            .validateBlank(req.getCompanyCode(), req.getSystemCode());
    }

}
