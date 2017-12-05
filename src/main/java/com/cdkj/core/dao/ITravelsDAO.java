package com.cdkj.core.dao;

import com.cdkj.core.dao.base.IBaseDAO;
import com.cdkj.core.domain.Travels;

public interface ITravelsDAO extends IBaseDAO<Travels> {
    String NAMESPACE = ITravelsDAO.class.getName().concat(".");

    public int updateTravels(Travels data);

    public int updateLocation(Travels data);

    public int updateStatus(Travels data);

}
