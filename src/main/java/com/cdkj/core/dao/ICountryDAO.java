package com.cdkj.core.dao;

import com.cdkj.core.dao.base.IBaseDAO;
import com.cdkj.core.domain.Country;

public interface ICountryDAO extends IBaseDAO<Country> {
	String NAMESPACE = ICountryDAO.class.getName().concat(".");
}