package com.cdkj.core.api.impl;

import com.cdkj.core.ao.ITravelsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.DateUtil;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Travels;
import com.cdkj.core.dto.req.XN801055Req;
import com.cdkj.core.enums.ETravelsStatus;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 分页查询游记
 * @author: asus 
 * @since: 2017年2月11日 下午10:21:11 
 * @history:
 */
public class XN801055 extends AProcessor {
    private ITravelsAO travelsAO = SpringContextHolder
        .getBean(ITravelsAO.class);

    private XN801055Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Travels condition = new Travels();
        condition.setDescription(req.getDescription());
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
        return travelsAO.queryTravelsPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801055Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
        StringValidater
            .validateBlank(req.getCompanyCode(), req.getSystemCode());
    }

}
