package com.cdkj.core.dao;

import com.cdkj.core.dao.base.IBaseDAO;
import com.cdkj.core.domain.Publicity;

//dao层 
public interface IPublicityDAO extends IBaseDAO<Publicity> {
    String NAMESPACE = IPublicityDAO.class.getName().concat(".");

    int update(Publicity data);

    int putOn(Publicity data);

    int putOff(Publicity data);
}
