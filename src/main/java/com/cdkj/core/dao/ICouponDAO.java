package com.cdkj.core.dao;

import com.cdkj.core.dao.base.IBaseDAO;
import com.cdkj.core.domain.Coupon;

//dao层 
public interface ICouponDAO extends IBaseDAO<Coupon> {
    String NAMESPACE = ICouponDAO.class.getName().concat(".");

    int update(Coupon data);
}
