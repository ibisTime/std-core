package com.cdkj.core.api.impl;

import org.apache.commons.lang.StringUtils;

import com.cdkj.core.ao.INewsAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.News;
import com.cdkj.core.dto.req.XN801005Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 分页查询资讯
 * @author: xieyj 
 * @since: 2017年8月31日 下午5:49:40 
 * @history:
 */
public class XN801005 extends AProcessor {
    private INewsAO newsAO = SpringContextHolder.getBean(INewsAO.class);

    private XN801005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        News condition = new News();
        condition.setType(req.getType());
        condition.setTitle(req.getTitle());
        condition.setKeywords(req.getKeywords());
        condition.setStatus(req.getStatus());
        condition.setLocation(req.getLocation());
        condition.setUpdater(req.getUpdater());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = INewsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return newsAO.queryNewsPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801005Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit(),
            req.getCompanyCode(), req.getSystemCode());
    }
}
