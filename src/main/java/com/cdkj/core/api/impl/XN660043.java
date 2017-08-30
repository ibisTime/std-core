package com.cdkj.core.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.cdkj.core.ao.IKeywordAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.dto.req.XN660043Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 导入
 * @author: asus 
 * @since: 2017年7月19日 下午4:11:57 
 * @history:
 */
public class XN660043 extends AProcessor {
    private IKeywordAO keywordAO = SpringContextHolder
        .getBean(IKeywordAO.class);

    private XN660043Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        keywordAO.addKeyword(req.getReqList());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660043Req.class);
        if (CollectionUtils.isEmpty(req.getReqList())) {
            throw new BizException("xn0000", "内容不能为空");
        }
    }

}
