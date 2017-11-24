package com.cdkj.core.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.dto.req.XN801025Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 分页查询评论
 * @author: asus 
 * @since: 2017年7月19日 下午3:38:09 
 * @history:
 */
public class XN801025 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN801025Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Comment condition = new Comment();
        condition.setType(req.getType());
        condition.setContent(req.getContent());
        condition.setStatus(req.getStatus());
        condition.setContent(req.getContent());
        condition.setCommenter(req.getCommenter());

        condition.setCommenterName(req.getCommenterName());
        condition.setApprover(req.getApprover());
        condition.setParentCode(req.getParentCode());
        condition.setOrderCode(req.getOrderCode());
        condition.setEntityCode(req.getEntityCode());

        condition.setEntityName(req.getEntityName());
        condition.setStatusList(req.getStatusList());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        String orderColumn = req.getOrderColumn();

        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICommentAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return commentAO.queryOssCommentPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801025Req.class);
        StringValidater
            .validateBlank(req.getCompanyCode(), req.getSystemCode());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}
