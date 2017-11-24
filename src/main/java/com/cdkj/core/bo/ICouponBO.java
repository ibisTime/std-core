package com.cdkj.core.bo;

import java.util.List;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.Coupon;

public interface ICouponBO extends IPaginableBO<Coupon> {

    public String saveCoupon(Coupon data);

    public void refreshCoupon(Coupon data, String updater, String remark);

    public List<Coupon> queryCouponList(Coupon condition);

    public Coupon getCoupon(String code);

    public Coupon getCoupon(String code, String companyCode, String systemCode);

    public void useCoupon(Coupon coupon);

    public void overDue(Coupon coupon);

}
