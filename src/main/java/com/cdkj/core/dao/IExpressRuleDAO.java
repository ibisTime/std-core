package com.cdkj.core.dao;

import com.cdkj.core.dao.base.IBaseDAO;
import com.cdkj.core.domain.ExpressRule;

public interface IExpressRuleDAO extends IBaseDAO<ExpressRule> {
    String NAMESPACE = IExpressRuleDAO.class.getName().concat(".");

    int updatePrice(ExpressRule data);

}
