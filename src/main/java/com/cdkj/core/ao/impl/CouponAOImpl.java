package com.cdkj.core.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.core.ao.ICouponAO;
import com.cdkj.core.bo.ICouponBO;
import com.cdkj.core.bo.IUserBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.common.DateUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Coupon;
import com.cdkj.core.domain.User;
import com.cdkj.core.dto.req.XN801110Req;
import com.cdkj.core.dto.res.XN003030Res;
import com.cdkj.core.enums.EBoolean;
import com.cdkj.core.enums.ECouponStatus;
import com.cdkj.core.exception.BizException;

@Service
public class CouponAOImpl implements ICouponAO {

    @Autowired
    private ICouponBO couponBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public String addCoupon(XN801110Req req) {
        Date startDatetime = DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.DATA_TIME_PATTERN_1);
        Date endDatetime = DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.DATA_TIME_PATTERN_1);
        if (endDatetime.before(startDatetime)) {
            throw new BizException("xn0000", "有效期截止时间不能早于开始时间");
        }
        userBO.getRemoteUser(req.getToUser());
        Coupon data = new Coupon();
        data.setToUser(req.getToUser());
        data.setParValue(StringValidater.toLong(req.getParValue()));
        data.setStartDatetime(startDatetime);
        data.setEndDatetime(endDatetime);
        data.setUseRange(EBoolean.YES.getCode());
        data.setStatus(ECouponStatus.Unused.getCode());
        data.setReleaser(req.getReleaser());
        data.setReleaseDatetime(new Date());
        data.setRemark(req.getRemark());
        data.setCompanyCode(req.getCompanyCode());
        data.setSystemCode(req.getSystemCode());
        return couponBO.saveCoupon(data);
    }

    @Override
    public void recoveryCoupon(String code, String updater, String remark) {
        Coupon coupon = couponBO.getCoupon(code);
        if (!ECouponStatus.Unused.getCode().equals(coupon.getStatus())) {
            throw new BizException("xn0000", "该优惠券不能被回收");
        }
        couponBO.refreshCoupon(coupon, updater, remark);
    }

    @Override
    public Paginable<Coupon> queryCouponPage(int start, int limit,
            Coupon condition) {
        Paginable<Coupon> page = couponBO.getPaginable(start, limit, condition);
        List<Coupon> couponList = page.getList();
        for (Coupon coupon : couponList) {
            User user = userBO.getRemoteUser(coupon.getToUser());
            coupon.setUser(user);
        }
        return page;
    }

    @Override
    public List<Coupon> queryCouponList(Coupon condition) {
        return couponBO.queryCouponList(condition);
    }

    @Override
    public Coupon getCoupon(String code) {
        Coupon coupon = couponBO.getCoupon(code);
        User user = userBO.getRemoteUser(coupon.getToUser());
        coupon.setUser(user);
        return coupon;
    }

    @Override
    public Paginable<Coupon> queryMyCouponPage(int start, int limit,
            Coupon condition) {
        return couponBO.getPaginable(start, limit, condition);
    }

    @Override
    public XN003030Res checkCoupon(String code, String companyCode,
            String systemCode) {
        Coupon coupon = couponBO.getCoupon(code, companyCode, systemCode);
        if (!ECouponStatus.Unused.getCode().equals(coupon.getStatus())) {
            throw new BizException("xn0000", "该优惠券不能使用");
        }
        Date startDatetime = coupon.getStartDatetime();
        Date endDatetime = coupon.getEndDatetime();
        if (startDatetime.after(new Date())) {
            throw new BizException("xn0000", "优惠券还不能使用");
        }
        if (endDatetime.before(new Date())) {
            throw new BizException("xn0000", "优惠券已过有效期,不能使用");
        }
        XN003030Res res = new XN003030Res();
        res.setParValue(coupon.getParValue());
        return res;
    }

    @Override
    public void useCoupon(String code, String companyCode, String systemCode) {
        Coupon coupon = couponBO.getCoupon(code);
        if (!ECouponStatus.Unused.getCode().equals(coupon.getStatus())) {
            throw new BizException("xn0000", "该优惠券不能使用");
        }
        couponBO.useCoupon(coupon);
    }

    @Override
    public void overDue() {
        Coupon condition = new Coupon();
        condition.setStatus(ECouponStatus.Unused.getCode());
        condition.setEndDatetime(new Date());
        List<Coupon> couponList = couponBO.queryCouponList(condition);
        for (Coupon coupon : couponList) {
            couponBO.overDue(coupon);
        }
    }
}
