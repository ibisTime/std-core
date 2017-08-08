package com.std.activity.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.std.activity.ao.ICommentAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.core.StringValidater;
import com.std.activity.dto.req.XN622140Req;
import com.std.activity.dto.res.PKCodeRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 评论
 * @author: asus 
 * @since: 2017年7月19日 上午11:40:38 
 * @history:
 */
public class XN622140 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN622140Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(commentAO.comment(req.getContent(),
            req.getItemScoreList(), req.getCommer(), req.getOrderCode()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN622140Req.class);
        StringValidater.validateBlank(req.getOrderCode(), req.getContent(),
            req.getCommer());
        if (CollectionUtils.isEmpty(req.getItemScoreList())) {
            throw new BizException("xn0000", "您还没有评分");
        }
    }
}
