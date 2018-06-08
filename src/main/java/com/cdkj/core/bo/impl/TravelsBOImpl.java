package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.ITravelsBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.common.DateUtil;
import com.cdkj.core.dao.ITravelsDAO;
import com.cdkj.core.domain.Travels;
import com.cdkj.core.enums.ETravelsStatus;
import com.cdkj.core.exception.BizException;

@Component
public class TravelsBOImpl extends PaginableBOImpl<Travels> implements
        ITravelsBO {

    @Autowired
    private ITravelsDAO travelsDAO;

    @Override
    public void saveTravels(Travels data) {
        if (data != null) {
            travelsDAO.insert(data);
        }
    }

    @Override
    public int removeTravels(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Travels data = new Travels();
            data.setCode(code);
            count = travelsDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshTravels(Travels data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = travelsDAO.updateTravels(data);
        }
        return count;
    }

    @Override
    public int approveTravels(String code, ETravelsStatus status,
            String updater, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Travels data = new Travels();
            data.setCode(code);
            data.setStatus(status.getCode());
            data.setUpdateDatetime(new Date());
            data.setUpdater(updater);
            data.setRemark(remark);
            count = travelsDAO.updateStatus(data);
        }
        return count;
    }

    @Override
    public List<Travels> queryTravelsList(Travels condition) {
        return travelsDAO.selectList(condition);
    }

    @Override
    public Travels getTravels(String code) {
        Travels data = null;
        if (StringUtils.isNotBlank(code)) {
            Travels condition = new Travels();
            condition.setCode(code);
            data = travelsDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "游记不存在");
            }
        }
        return data;
    }

    @Override
    public int getTotalCount(String publisher) {
        Travels condition = new Travels();
        condition.setPublisher(publisher);
        condition.setPublishDatetimeStart(DateUtil.getTodayStart());
        condition.setPublishDatetimeEnd(DateUtil.getTodayEnd());
        int count = travelsDAO.selectTotalCount(condition).intValue();
        System.out.println(count);
        return count;
    }

}
