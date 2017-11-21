package com.cdkj.core.bo;

import java.util.List;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.CurrencyActivity;

public interface ICurrencyActivityBO extends IPaginableBO<CurrencyActivity> {

    public void saveCurrencyActivity(CurrencyActivity data);

    public void removeCurrencyActivity(String code);

    public void refreshCurrencyActivity(CurrencyActivity data);

    public List<CurrencyActivity> queryCurrencyActivityList(
            CurrencyActivity condition);

    public CurrencyActivity getCurrencyActivity(String code);

    public void putOn(CurrencyActivity data, String location, String orderNo,
            String readTimes, String updater, String remark);

    public void putOff(CurrencyActivity data, String updater, String remark);

    public CurrencyActivity getCurrencyActivity(String code,
            String companyCode, String systemCode);

    public Long getTotalCount(String type);

    public CurrencyActivity getCurrencyActivityByType(String code, String type,
            String companyCode, String systemCode);
}
