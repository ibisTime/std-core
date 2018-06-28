package com.cdkj.core.bo;

import java.util.List;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.Country;

public interface ICountryBO extends IPaginableBO<Country> {

    public String saveCountry(Country data);

    public List<Country> queryCountryList(Country condition);

    public Country getCountry(String code);

}
