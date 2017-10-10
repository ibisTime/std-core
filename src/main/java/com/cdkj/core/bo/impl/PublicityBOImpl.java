package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.IPublicityBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dao.IPublicityDAO;
import com.cdkj.core.domain.Publicity;
import com.cdkj.core.enums.ECurrencyActivityStatus;
import com.cdkj.core.exception.BizException;

@Component
public class PublicityBOImpl extends PaginableBOImpl<Publicity> implements
        IPublicityBO {

    @Autowired
    private IPublicityDAO publicityDAO;

    @Override
    public void savePublicity(Publicity data) {
        publicityDAO.insert(data);
    }

    @Override
    public void removePublicity(Publicity data) {
        publicityDAO.delete(data);
    }

    @Override
    public void refreshPublicity(Publicity data) {
        publicityDAO.update(data);
    }

    @Override
    public List<Publicity> queryPublicityList(Publicity condition) {
        return publicityDAO.selectList(condition);
    }

    @Override
    public Publicity getPublicity(String code) {
        Publicity data = null;
        if (StringUtils.isNotBlank(code)) {
            Publicity condition = new Publicity();
            condition.setCode(code);
            data = publicityDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }

    @Override
    public void putOn(Publicity data, String location, String orderNo,
            String updater, String remark) {
        data.setStatus(ECurrencyActivityStatus.ONLINE.getCode());
        data.setLocation(location);
        data.setOrderNo(StringValidater.toInteger(orderNo));
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        publicityDAO.putOn(data);
    }

    @Override
    public void putOff(Publicity data, String updater, String remark) {
        data.setStatus(ECurrencyActivityStatus.OFFLINE.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        publicityDAO.putOff(data);
    }
}
