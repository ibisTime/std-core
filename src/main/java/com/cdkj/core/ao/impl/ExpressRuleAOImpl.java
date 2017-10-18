package com.cdkj.core.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.core.ao.IExpressRuleAO;
import com.cdkj.core.bo.IExpressRuleBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.ExpressRule;

@Service
public class ExpressRuleAOImpl implements IExpressRuleAO {

    @Autowired
    private IExpressRuleBO expressRuleBO;

    @Override
    @Transactional
    public void modifyPrices(List<String> idList, Double startWeight,
            Long startPrice, Double addWeight, Long addPrice, String updater,
            String remark) {
        for (String ids : idList) {
            Long id = Long.valueOf(ids);
            expressRuleBO.refreshPrice(id, startWeight, startPrice, addWeight,
                addPrice, updater, remark);
        }
    }

    @Override
    public Paginable<ExpressRule> queryExpressRulePage(int start, int limit,
            ExpressRule condition) {
        return expressRuleBO.getPaginable(start, limit, condition);
    }

    @Override
    public ExpressRule getExpressRule(Long id) {
        return expressRuleBO.getExpressRule(id);
    }

    @Override
    public long getPrice(String startPoint, String endPoint, Double weight,
            String companyCode, String systemCode) {
        long price = 0;
        ExpressRule expressRule = expressRuleBO.getPrice(startPoint, endPoint,
            companyCode, systemCode);
        if (expressRule != null) {
            if (weight <= expressRule.getStartWeight()) {
                price = expressRule.getStartPrice();
            } else {
                price = expressRule.getStartPrice();
                weight = weight - expressRule.getStartWeight();// 减去首重
                int size = 0;
                Double addWeight = expressRule.getAddWeight();// 计算增重
                while (weight > 0 && addWeight.doubleValue() > 0) {
                    size++;
                    weight = weight - addWeight;
                }
                long addPrice = expressRule.getAddPrice();
                price = price + size * addPrice;
            }
        }
        return price;
    }
}
