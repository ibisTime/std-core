package com.cdkj.core.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.cdkj.core.ao.IKeywordAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801010CReq;
import com.cdkj.core.dto.req.XN801010Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 批量新增关键字
 * @author: xieyj 
 * @since: 2017年8月31日 下午8:49:03 
 * @history:
 */
public class XN801010 extends AProcessor {
    private IKeywordAO keywordAO = SpringContextHolder
        .getBean(IKeywordAO.class);

    private XN801010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        keywordAO.addKeywords(req.getKeywordList(), req.getCompanyCode(),
            req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801010Req.class);
        StringValidater
            .validateBlank(req.getCompanyCode(), req.getSystemCode());
        if (CollectionUtils.isEmpty(req.getKeywordList())) {
            throw new BizException("xn0000", "关键字列表不能为空");
        } else {
            for (XN801010CReq cReq : req.getKeywordList()) {
                StringValidater.validateBlank(cReq.getWord(), cReq.getLevel(),
                    cReq.getWeight(), cReq.getReaction(), cReq.getUpdater());
            }
        }
    }
}
