package com.cdkj.core.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.dto.req.XN660060Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 分页查询评论
 * @author: asus 
 * @since: 2017年7月19日 下午3:38:09 
 * @history:
 */
public class XN660060 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN660060Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Comment condition = new Comment();
        condition.setEntityCode(req.getProductCode());
        condition.setStatus(req.getStatus());
        condition.setContent(req.getContent());
        condition.setStatusList(req.getStatusList());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICommentAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return commentAO.queryCommentPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660060Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}
