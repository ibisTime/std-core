package com.cdkj.core.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.core.ao.ICaigopoolBackAO;
import com.cdkj.core.bo.ICaigopoolBackBO;
import com.cdkj.core.bo.IUserBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.CaigopoolBack;
import com.cdkj.core.domain.User;

@Service
public class CaigopoolBackAOImpl implements ICaigopoolBackAO {
    @Autowired
    private ICaigopoolBackBO caigopoolBackBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public Paginable<CaigopoolBack> queryCaigopoolBackPage(int start,
            int limit, CaigopoolBack condition) {
        Paginable<CaigopoolBack> page = caigopoolBackBO.getPaginable(start,
            limit, condition);
        List<CaigopoolBack> caigopoolBackList = page.getList();
        for (CaigopoolBack caigopoolBack : caigopoolBackList) {
            User user = userBO.getRemoteUser(caigopoolBack.getToUser());
            caigopoolBack.setLoginName(user.getLoginName());
        }
        return page;
    }

    @Override
    public CaigopoolBack getCaigopoolBack(Long id) {
        CaigopoolBack caigopoolBack = caigopoolBackBO.getCaigopoolBack(id);
        User user = userBO.getRemoteUser(caigopoolBack.getToUser());
        caigopoolBack.setLoginName(user.getLoginName());
        return caigopoolBack;
    }

}
