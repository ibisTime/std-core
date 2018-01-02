package com.cdkj.core.dao;

import com.cdkj.core.dao.base.IBaseDAO;
import com.cdkj.core.domain.Interact;

//dao层 
public interface IInteractDAO extends IBaseDAO<Interact> {
    String NAMESPACE = IInteractDAO.class.getName().concat(".");

    int update(Interact data);

    int deleteByEntityCode(Interact data);
}
