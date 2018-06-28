package com.cdkj.core.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.core.ao.ICountryAO;
import com.cdkj.core.bo.ICountryBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.Country;

@Service
public class CountryAOImpl implements ICountryAO {

    @Autowired
    private ICountryBO countryBO;

    @Override
    public String addCountry(Country data) {
        return countryBO.saveCountry(data);
    }

    @Override
    public Paginable<Country> queryCountryPage(int start, int limit,
            Country condition) {
        return countryBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Country> queryCountryList(Country condition) {
        return countryBO.queryCountryList(condition);
    }

    @Override
    public Country getCountry(String code) {
        return countryBO.getCountry(code);
    }
}
