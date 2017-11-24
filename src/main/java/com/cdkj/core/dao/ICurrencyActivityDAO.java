package com.cdkj.core.dao;

import com.cdkj.core.dao.base.IBaseDAO;
import com.cdkj.core.domain.CurrencyActivity;

//dao层 
public interface ICurrencyActivityDAO extends IBaseDAO<CurrencyActivity> {
    String NAMESPACE = ICurrencyActivityDAO.class.getName().concat(".");

    int update(CurrencyActivity data);

    int putOn(CurrencyActivity data);

    int putOff(CurrencyActivity data);
}
