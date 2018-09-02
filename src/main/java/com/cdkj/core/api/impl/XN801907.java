package com.cdkj.core.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.core.ao.ISYSDictAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.domain.SYSDict;
import com.cdkj.core.dto.req.XN801907Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 列表查询数据字典
 * @author: xieyj 
 * @since: 2016年9月17日 下午1:50:02 
 * @history:
 */
public class XN801907 extends AProcessor {
    private ISYSDictAO sysDictAO = SpringContextHolder
        .getBean(ISYSDictAO.class);

    private XN801907Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        SYSDict condition = new SYSDict();
        condition.setType(req.getType());
        condition.setParentKey(req.getParentKey());
        condition.setDkey(req.getDkey());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISYSDictAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        return sysDictAO.querySysDictList(condition);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801907Req.class);
    }
}
