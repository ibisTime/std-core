package com.std.activity.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.std.activity.ao.IKeywordAO;
import com.std.activity.api.AProcessor;
import com.std.activity.common.JsonUtil;
import com.std.activity.dto.req.XN622003Req;
import com.std.activity.dto.res.BooleanRes;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;
import com.std.activity.spring.SpringContextHolder;

/**
 * 导入
 * @author: asus 
 * @since: 2017年7月19日 下午4:11:57 
 * @history:
 */
public class XN622003 extends AProcessor {
    private IKeywordAO keywordAO = SpringContextHolder
        .getBean(IKeywordAO.class);

    private XN622003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        keywordAO.addKeyword(req.getReqList());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN622003Req.class);
        if (CollectionUtils.isEmpty(req.getReqList())) {
            throw new BizException("xn0000", "内容不能为空");
        }
    }

}
