package com.cdkj.core.bo.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.ICaigopoolBackBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.dao.ICaigopoolBackDAO;
import com.cdkj.core.domain.Caigopool;
import com.cdkj.core.domain.CaigopoolBack;
import com.cdkj.core.exception.BizException;

@Component
public class CaigopoolBackBOImpl extends PaginableBOImpl<CaigopoolBack>
        implements ICaigopoolBackBO {
    @Autowired
    private ICaigopoolBackDAO caigopoolBackDAO;

    @Override
    public Long saveCaigopoolBack(Caigopool pool, String userId,
            String currency, Long amount, String remark) {
        CaigopoolBack data = new CaigopoolBack();
        data.setPoolCode(pool.getCode());
        data.setActivityCode(pool.getActivityCode());
        data.setToUser(userId);
        data.setToAmount(amount);
        data.setToCurrency(currency);
        data.setCreateDatetime(new Date());
        data.setRemainAmount(pool.getAmount() - pool.getUsedAmount() - amount);
        data.setRemark(remark);
        data.setCompanyCode(pool.getCompanyCode());
        data.setSystemCode(pool.getSystemCode());
        caigopoolBackDAO.insert(data);
        return data.getId();
    }

    @Override
    public CaigopoolBack getCaigopoolBack(Long id) {
        CaigopoolBack data = null;
        if (id != null) {
            CaigopoolBack condition = new CaigopoolBack();
            condition.setId(id);
            data = caigopoolBackDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }

}
