package com.cdkj.core.ao;

import java.util.List;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.Country;

public interface ICountryAO {
    static final String DEFAULT_ORDER_COLUMN = "inter_name";

    public String addCountry(Country data);

    public Paginable<Country> queryCountryPage(int start, int limit,
            Country condition);

    public List<Country> queryCountryList(Country condition);

    public Country getCountry(String code);

}
