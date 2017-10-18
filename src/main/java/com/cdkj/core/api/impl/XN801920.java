package com.cdkj.core.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.cdkj.core.ao.IExpressRuleAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN801920Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 批量修改邮费
 * @author: xieyj 
 * @since: 2017年7月18日 下午2:08:51 
 * @history:
 */
public class XN801920 extends AProcessor {

    private IExpressRuleAO expressRuleAO = SpringContextHolder
        .getBean(IExpressRuleAO.class);

    private XN801920Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Double startWeight = StringValidater.toDouble(req.getStartWeight());
        Long startPrice = StringValidater.toLong(req.getStartPrice());
        Double addWeight = StringValidater.toDouble(req.getAddWeight());
        Long addPrice = StringValidater.toLong(req.getAddPrice());
        expressRuleAO.modifyPrices(req.getIdList(), startWeight, startPrice,
            addWeight, addPrice, req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801920Req.class);
        if (CollectionUtils.isEmpty(req.getIdList())) {
            throw new ParaException("xn0000", "邮费列表不能为空");
        }
        StringValidater.validateBlank(req.getUpdater(), req.getStartWeight(),
            req.getStartPrice(), req.getAddWeight(), req.getAddPrice());
    }
}
