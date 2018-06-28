package com.cdkj.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.core.dao.ICountryDAO;
import com.cdkj.core.dao.base.support.AMybatisTemplate;
import com.cdkj.core.domain.Country;



@Repository("countryDAOImpl")
public class CountryDAOImpl extends AMybatisTemplate implements ICountryDAO {


	@Override
	public int insert(Country data) {
		return super.insert(NAMESPACE.concat("insert_country"), data);
	}


	@Override
	public int delete(Country data) {
		return super.delete(NAMESPACE.concat("delete_country"), data);
	}


	@Override
	public Country select(Country condition) {
		return super.select(NAMESPACE.concat("select_country"), condition,Country.class);
	}


	@Override
	public Long selectTotalCount(Country condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_country_count"),condition);
	}


	@Override
	public List<Country> selectList(Country condition) {
		return super.selectList(NAMESPACE.concat("select_country"), condition,Country.class);
	}


	@Override
	public List<Country> selectList(Country condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_country"), start, count,condition, Country.class);
	}


}