package com.cdkj.core.dao;

import com.cdkj.core.dao.base.IBaseDAO;
import com.cdkj.core.domain.Caigopool;

//dao层 
public interface ICaigopoolDAO extends IBaseDAO<Caigopool> {
    String NAMESPACE = ICaigopoolDAO.class.getName().concat(".");

    int addAmount(Caigopool pool);

    int outAmount(Caigopool pool);

}
