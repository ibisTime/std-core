package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.ICurrencyActivityBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dao.ICurrencyActivityDAO;
import com.cdkj.core.domain.CurrencyActivity;
import com.cdkj.core.enums.ECurrencyActivityStatus;
import com.cdkj.core.exception.BizException;

@Component
public class CurrencyActivityBOImpl extends PaginableBOImpl<CurrencyActivity>
        implements ICurrencyActivityBO {

    @Autowired
    private ICurrencyActivityDAO currencyActivityDAO;

    @Override
    public void saveCurrencyActivity(CurrencyActivity data) {
        currencyActivityDAO.insert(data);
    }

    @Override
    public void removeCurrencyActivity(String code) {
        if (StringUtils.isNotBlank(code)) {
            CurrencyActivity data = new CurrencyActivity();
            data.setCode(code);
            currencyActivityDAO.delete(data);
        }
    }

    @Override
    public void refreshCurrencyActivity(CurrencyActivity data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            currencyActivityDAO.update(data);
        }
    }

    @Override
    public List<CurrencyActivity> queryCurrencyActivityList(
            CurrencyActivity condition) {
        return currencyActivityDAO.selectList(condition);
    }

    @Override
    public CurrencyActivity getCurrencyActivity(String code) {
        CurrencyActivity data = null;
        if (StringUtils.isNotBlank(code)) {
            CurrencyActivity condition = new CurrencyActivity();
            condition.setCode(code);
            data = currencyActivityDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }

    @Override
    public void putOn(CurrencyActivity data, String location, String orderNo,
            String updater, String remark) {
        data.setStatus(ECurrencyActivityStatus.ONLINE.getCode());
        data.setLocation(location);
        data.setOrderNo(StringValidater.toInteger(orderNo));
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        currencyActivityDAO.putOn(data);
    }

    @Override
    public void putOff(CurrencyActivity data, String updater, String remark) {
        data.setStatus(ECurrencyActivityStatus.OFFLINE.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        currencyActivityDAO.putOff(data);
    }
}
