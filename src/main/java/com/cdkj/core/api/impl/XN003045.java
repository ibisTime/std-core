package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IInteractAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN003045Req;
import com.cdkj.core.dto.res.XN003045Res;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 统计某件事情在某种情况下的数量
 * @author: asus 
 * @since: 2017年9月1日 下午2:06:17 
 * @history:
 */
public class XN003045 extends AProcessor {
    private IInteractAO interactAO = SpringContextHolder
        .getBean(IInteractAO.class);

    private XN003045Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long totalInteract = interactAO.totalInteract(req.getCategory(),
            req.getType(), req.getEntityCode(), req.getCompanyCode(),
            req.getSystemCode());
        XN003045Res res = new XN003045Res();
        res.setTotalInteract(totalInteract);
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN003045Req.class);
        StringValidater.validateBlank(req.getCategory(), req.getType(),
            req.getEntityCode(), req.getCompanyCode(), req.getSystemCode());
    }

}
