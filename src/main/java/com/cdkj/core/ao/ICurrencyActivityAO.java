package com.cdkj.core.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.CurrencyActivity;
import com.cdkj.core.dto.req.XN801040Req;
import com.cdkj.core.dto.req.XN801042Req;
import com.cdkj.core.dto.res.XN003025Res;
import com.cdkj.core.dto.res.XN003026Res;

@Component
public interface ICurrencyActivityAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCurrencyActivity(XN801040Req req);

    public void dropCurrencyActivity(String code);

    public void editCurrencyActivity(XN801042Req req);

    public Paginable<CurrencyActivity> queryCurrencyActivityPage(int start,
            int limit, CurrencyActivity condition);

    public List<CurrencyActivity> queryCurrencyActivityList(
            CurrencyActivity condition);

    public CurrencyActivity getCurrencyActivity(String code);

    public void putOn(String code, String location, String orderNo,
            String updater, String remark);

    public void putOff(String code, String updater, String remark);

    public XN003025Res checkCurrencyActivity(String code, String companyCode,
            String systemCode);

    public XN003026Res getCurrencyActivity(String code, String type,
            String companyCode, String systemCode);

    public void changeCurrencyActivityStatus();
}
