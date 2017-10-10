package com.cdkj.core.bo;

import java.util.List;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.Publicity;

public interface IPublicityBO extends IPaginableBO<Publicity> {

    public void savePublicity(Publicity data);

    public void removePublicity(Publicity data);

    public void refreshPublicity(Publicity data);

    public List<Publicity> queryPublicityList(Publicity condition);

    public Publicity getPublicity(String code);

    public void putOn(Publicity data, String location, String orderNo,
            String updater, String remark);

    public void putOff(Publicity data, String updater, String remark);
}
