package com.cdkj.core.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.Publicity;
import com.cdkj.core.dto.req.XN801060Req;
import com.cdkj.core.dto.req.XN801062Req;
import com.cdkj.core.dto.res.XN003020Res;

@Component
public interface IPublicityAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addPublicity(XN801060Req req);

    public void dropPublicity(String code);

    public void editPublicity(XN801062Req req);

    public Paginable<Publicity> queryPublicityPage(int start, int limit,
            Publicity condition);

    public List<Publicity> queryPublicityList(Publicity condition);

    public Publicity getPublicity(String code);

    public void putOn(String code, String location, String orderNo,
            String updater, String remark);

    public void putOff(String code, String updater, String remark);

    public XN003020Res checkPublicity(String code, String companyCode,
            String systemCode);

}
