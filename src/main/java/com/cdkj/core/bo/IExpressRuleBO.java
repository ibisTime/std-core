package com.cdkj.core.bo;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.ExpressRule;

public interface IExpressRuleBO extends IPaginableBO<ExpressRule> {

    public int refreshPrice(Long id, Double startWeight, Long startPrice,
            Double addWeight, Long addPrice, String updater, String remark);

    public ExpressRule getExpressRule(Long id);

    public ExpressRule getPrice(String startPoint, String endPoint,
            String companyCode, String systemCode);
}
