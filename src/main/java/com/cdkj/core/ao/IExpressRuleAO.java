package com.cdkj.core.ao;

import java.util.List;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.ExpressRule;

public interface IExpressRuleAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public void modifyPrices(List<String> idList, Double startWeight,
            Long startPrice, Double addWeight, Long addPrice, String updater,
            String remark);

    public Paginable<ExpressRule> queryExpressRulePage(int start, int limit,
            ExpressRule condition);

    public ExpressRule getExpressRule(Long id);

    public long getPrice(String startPoint, String endPoint, Double weight,
            String companyCode, String systemCode);
}
