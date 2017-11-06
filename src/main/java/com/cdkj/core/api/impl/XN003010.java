package com.cdkj.core.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.cdkj.core.ao.ICommentAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN003010CReq;
import com.cdkj.core.dto.req.XN003010Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 评论
 * @author: xieyj 
 * @since: 2017年9月1日 下午12:31:46 
 * @history:
 */
public class XN003010 extends AProcessor {
    private ICommentAO commentAO = SpringContextHolder
        .getBean(ICommentAO.class);

    private XN003010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return commentAO.comment(req);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN003010Req.class);
        StringValidater.validateBlank(req.getType(), req.getOrderCode(),
            req.getCommenter(), req.getCommenterName(), req.getCompanyCode(),
            req.getSystemCode());
        if (CollectionUtils.isEmpty(req.getCommentList())) {
            throw new BizException("xn000000", "评论列表不能为空");
        } else {
            for (XN003010CReq req : req.getCommentList()) {
                StringValidater.validateNumber(req.getScore());
                StringValidater.validateBlank(req.getParentCode());
            }
        }
    }
}
