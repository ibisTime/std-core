package com.cdkj.core.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.core.ao.IPublicityAO;
import com.cdkj.core.bo.IPublicityBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.common.DateUtil;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Publicity;
import com.cdkj.core.dto.req.XN801060Req;
import com.cdkj.core.dto.req.XN801062Req;
import com.cdkj.core.dto.res.XN003020Res;
import com.cdkj.core.enums.ECurrencyActivityStatus;
import com.cdkj.core.enums.EGeneratePrefix;
import com.cdkj.core.exception.BizException;

@Service
public class PublicityAOImpl implements IPublicityAO {

    @Autowired
    private IPublicityBO publicityBO;

    @Override
    public String addPublicity(XN801060Req req) {
        Date startDatetime = DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.DATA_TIME_PATTERN_1);
        Date endDatetime = DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.DATA_TIME_PATTERN_1);
        if (endDatetime.before(startDatetime)) {
            throw new BizException("xn0000", "结束时间不能早于开始时间");
        }
        Publicity data = new Publicity();
        String code = OrderNoGenerater.generateME(EGeneratePrefix.Publicity
            .getCode());
        data.setCode(code);
        data.setType(req.getType());
        data.setAdvPic(req.getAdvPic());
        data.setDescription(req.getDescription());
        data.setStartDatetime(startDatetime);
        data.setEndDatetime(endDatetime);
        data.setValue1(StringValidater.toDouble(req.getValue1()));
        data.setValue2(StringValidater.toDouble(req.getValue2()));
        data.setValue3(StringValidater.toDouble(req.getValue3()));
        data.setStatus(ECurrencyActivityStatus.DRAFT.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        data.setCompanyCode(req.getCompanyCode());
        data.setSystemCode(req.getSystemCode());
        publicityBO.savePublicity(data);
        return code;
    }

    @Override
    public void editPublicity(XN801062Req req) {
        Date startDatetime = DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.DATA_TIME_PATTERN_1);
        Date endDatetime = DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.DATA_TIME_PATTERN_1);
        if (endDatetime.before(startDatetime)) {
            throw new BizException("xn0000", "结束时间不能早于开始时间");
        }
        Publicity data = publicityBO.getPublicity(req.getCode());
        if (ECurrencyActivityStatus.ONLINE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "活动已上架,不可修改");
        }
        data.setType(req.getType());
        data.setAdvPic(req.getAdvPic());
        data.setDescription(req.getDescription());
        data.setStartDatetime(startDatetime);
        data.setEndDatetime(endDatetime);
        data.setValue1(StringValidater.toDouble(req.getValue1()));
        data.setValue2(StringValidater.toDouble(req.getValue2()));
        data.setValue3(StringValidater.toDouble(req.getValue3()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        publicityBO.refreshPublicity(data);
    }

    @Override
    public void dropPublicity(String code) {
        Publicity data = publicityBO.getPublicity(code);
        if (ECurrencyActivityStatus.ONLINE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "活动已上架,不可删除");
        }
        publicityBO.removePublicity(data);
    }

    @Override
    public Paginable<Publicity> queryPublicityPage(int start, int limit,
            Publicity condition) {
        return publicityBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Publicity> queryPublicityList(Publicity condition) {
        return publicityBO.queryPublicityList(condition);
    }

    @Override
    public Publicity getPublicity(String code) {
        return publicityBO.getPublicity(code);
    }

    @Override
    public void putOn(String code, String location, String orderNo,
            String updater, String remark) {
        Publicity data = publicityBO.getPublicity(code);
        if (ECurrencyActivityStatus.ONLINE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "活动已上架,不能重复上架");
        }
        publicityBO.putOn(data, location, orderNo, updater, remark);
    }

    @Override
    public void putOff(String code, String updater, String remark) {
        Publicity data = publicityBO.getPublicity(code);
        if (!ECurrencyActivityStatus.ONLINE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "活动未上架,不能下架");
        }
        publicityBO.putOff(data, updater, remark);
    }

    @Override
    public XN003020Res checkPublicity(String code, String companyCode,
            String systemCode) {
        Publicity data = publicityBO
            .getPublicity(code, companyCode, systemCode);
        if (!ECurrencyActivityStatus.ONLINE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "活动未上架,不能参与");
        }
        Date startDatetime = data.getStartDatetime();
        Date endDatetime = data.getEndDatetime();
        if (startDatetime.after(new Date())) {
            throw new BizException("xn0000", "活动还未开始,不能报名");
        }
        if (endDatetime.before(new Date())) {
            throw new BizException("xn0000", "活动已结束,不能继续报名");
        }
        XN003020Res res = new XN003020Res();
        res.setType(data.getType());
        res.setDiscount(data.getValue1());
        return res;
    }
}
