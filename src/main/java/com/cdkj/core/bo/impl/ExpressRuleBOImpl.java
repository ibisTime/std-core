package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.IExpressRuleBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.dao.IExpressRuleDAO;
import com.cdkj.core.domain.ExpressRule;
import com.cdkj.core.exception.BizException;

@Component
public class ExpressRuleBOImpl extends PaginableBOImpl<ExpressRule> implements
        IExpressRuleBO {

    @Autowired
    private IExpressRuleDAO expressRuleDAO;

    @Override
    public int refreshPrice(Long id, Double startWeight, Long startPrice,
            Double addWeight, Long addPrice, String updater, String remark) {
        int count = 0;
        if (null != id) {
            ExpressRule data = new ExpressRule();
            data.setId(id);
            data.setStartWeight(startWeight);
            data.setStartPrice(startPrice);
            data.setAddWeight(addWeight);
            data.setAddPrice(addPrice);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            count = expressRuleDAO.updatePrice(data);
        }
        return count;
    }

    @Override
    public ExpressRule getExpressRule(Long id) {
        ExpressRule data = null;
        if (null != id) {
            ExpressRule condition = new ExpressRule();
            condition.setId(id);
            data = expressRuleDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "快递规则不存在");
            }
        }
        return data;
    }

    @Override
    public ExpressRule getPrice(String startPoint, String endPoint,
            String companyCode, String systemCode) {
        ExpressRule expressRule = null;
        ExpressRule condition = new ExpressRule();
        condition.setStartPoint(startPoint);
        condition.setEndPoint(endPoint);
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        List<ExpressRule> list = expressRuleDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            expressRule = list.get(0);
        }
        return expressRule;
    }
}
