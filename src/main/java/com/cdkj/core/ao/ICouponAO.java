package com.cdkj.core.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.Coupon;
import com.cdkj.core.dto.req.XN801110Req;
import com.cdkj.core.dto.res.XN003030Res;

@Component
public interface ICouponAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCoupon(XN801110Req req);

    public void recoveryCoupon(String code, String updater, String remark);

    public Paginable<Coupon> queryCouponPage(int start, int limit,
            Coupon condition);

    public List<Coupon> queryCouponList(Coupon condition);

    public Coupon getCoupon(String code);

    public Paginable<Coupon> queryMyCouponPage(int start, int limit,
            Coupon condition);

    public XN003030Res checkCoupon(String code, String companyCode,
            String systemCode);

    public void useCoupon(String code, String companyCode, String systemCode);

    // 过期
    public void overDue();
}
