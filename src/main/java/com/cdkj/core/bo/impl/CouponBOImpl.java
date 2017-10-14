package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.ICouponBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.dao.ICouponDAO;
import com.cdkj.core.domain.Coupon;
import com.cdkj.core.enums.ECouponStatus;
import com.cdkj.core.enums.EGeneratePrefix;
import com.cdkj.core.exception.BizException;

@Component
public class CouponBOImpl extends PaginableBOImpl<Coupon> implements ICouponBO {

    @Autowired
    private ICouponDAO couponDAO;

    @Override
    public String saveCoupon(Coupon data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generateME(EGeneratePrefix.Coupon.getCode());
            data.setCode(code);
            couponDAO.insert(data);
        }
        return code;
    }

    @Override
    public void refreshCoupon(Coupon data, String updater, String remark) {
        data.setStatus(ECouponStatus.Recovery.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        couponDAO.update(data);
    }

    @Override
    public List<Coupon> queryCouponList(Coupon condition) {
        return couponDAO.selectList(condition);
    }

    @Override
    public Coupon getCoupon(String code) {
        Coupon data = null;
        if (StringUtils.isNotBlank(code)) {
            Coupon condition = new Coupon();
            condition.setCode(code);
            data = couponDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }

    @Override
    public Coupon getCoupon(String code, String companyCode, String systemCode) {
        Coupon data = null;
        if (StringUtils.isNotBlank(code)) {
            Coupon condition = new Coupon();
            condition.setCode(code);
            condition.setCompanyCode(companyCode);
            condition.setSystemCode(systemCode);
            data = couponDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }

    @Override
    public void useCoupon(Coupon coupon) {
        coupon.setStatus(ECouponStatus.Used.getCode());
        couponDAO.useCoupon(coupon);
    }
}
