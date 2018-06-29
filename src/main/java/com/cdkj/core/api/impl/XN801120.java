package com.cdkj.core.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.core.ao.ICountryAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.domain.Country;
import com.cdkj.core.dto.req.XN801120Req;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 列表查询国家
 * @author: asus 
 * @since: 2017年10月10日 下午2:34:10 
 * @history:
 */
public class XN801120 extends AProcessor {

    private ICountryAO countryAO = SpringContextHolder
        .getBean(ICountryAO.class);

    private XN801120Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        Country condition = new Country();
        condition.setInterCodeForQuery(req.getInterCode());
        condition.setInterName(req.getInterName());
        condition.setInterSimpleCode(req.getInterSimpleCode());
        condition.setContinent(req.getContinent());
        condition.setStatus(req.getStatus());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICountryAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, true);

        return countryAO.queryCountryList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN801120Req.class);
    }
}
