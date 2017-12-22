package com.cdkj.core.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.dto.req.XN801029Req;
import com.cdkj.core.enums.ECommentStatus;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 分页查询一级评论(活动)
 * @author: xieyj 
 * @since: 2017年12月18日 下午5:50:05 
 * @history:
 */
public class XN801029 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN801029Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Comment condition = new Comment();
        condition.setEntityCode(req.getEntityCode());
        condition.setParentCode(req.getParentCode());
        condition.setStatus(ECommentStatus.PUBLISHALL.getCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        String orderColumn = req.getOrderColumn();

        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICommentAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return commentAO.queryFrontOneCommentPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801029Req.class);
        StringValidater.validateBlank(req.getEntityCode(), req.getParentCode(),
            req.getCompanyCode(), req.getSystemCode());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
