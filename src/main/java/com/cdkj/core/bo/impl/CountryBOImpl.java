package com.cdkj.core.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.ICountryBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.dao.ICountryDAO;
import com.cdkj.core.domain.Country;
import com.cdkj.core.exception.BizException;

@Component
public class CountryBOImpl extends PaginableBOImpl<Country>
        implements ICountryBO {

    @Autowired
    private ICountryDAO countryDAO;

    @Override
    public String saveCountry(Country data) {
        String code = null;
        if (data != null) {
            countryDAO.insert(data);
        }
        return code;
    }

    @Override
    public List<Country> queryCountryList(Country condition) {
        return countryDAO.selectList(condition);
    }

    @Override
    public Country getCountry(String code) {
        Country data = null;
        if (StringUtils.isNotBlank(code)) {
            Country condition = new Country();
            condition.setCode(code);
            data = countryDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "国家不存在");
            }
        }
        return data;
    }
}
