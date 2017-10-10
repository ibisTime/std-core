package com.cdkj.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.core.dao.ICouponDAO;
import com.cdkj.core.dao.base.support.AMybatisTemplate;
import com.cdkj.core.domain.Coupon;

@Repository("couponDAOImpl")
public class CouponDAOImpl extends AMybatisTemplate implements ICouponDAO {

    @Override
    public int insert(Coupon data) {
        return super.insert(NAMESPACE.concat("insert_coupon"), data);
    }

    @Override
    public int delete(Coupon data) {
        return super.delete(NAMESPACE.concat("delete_coupon"), data);
    }

    @Override
    public Coupon select(Coupon condition) {
        return super.select(NAMESPACE.concat("select_coupon"), condition,
            Coupon.class);
    }

    @Override
    public Long selectTotalCount(Coupon condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_coupon_count"),
            condition);
    }

    @Override
    public List<Coupon> selectList(Coupon condition) {
        return super.selectList(NAMESPACE.concat("select_coupon"), condition,
            Coupon.class);
    }

    @Override
    public List<Coupon> selectList(Coupon condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_coupon"), start,
            count, condition, Coupon.class);
    }

    @Override
    public int update(Coupon data) {
        return super.update(NAMESPACE.concat("update_coupon"), data);
    }

}
