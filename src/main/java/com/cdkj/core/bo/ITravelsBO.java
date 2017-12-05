package com.cdkj.core.bo;

import java.util.List;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.Travels;
import com.cdkj.core.enums.ETravelsStatus;

public interface ITravelsBO extends IPaginableBO<Travels> {

    public void saveTravels(Travels data);

    public int removeTravels(String code);

    public int refreshTravels(Travels data);

    public int approveTravels(String code, ETravelsStatus status,
            String updater, String remark);

    public List<Travels> queryTravelsList(Travels condition);

    public Travels getTravels(String code);

}
