package com.cdkj.core.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.core.ao.ICurrencyActivityAO;
import com.cdkj.core.bo.IAccountBO;
import com.cdkj.core.bo.ICaigopoolBO;
import com.cdkj.core.bo.ICurrencyActivityBO;
import com.cdkj.core.bo.IInteractBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.common.DateUtil;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Caigopool;
import com.cdkj.core.domain.CurrencyActivity;
import com.cdkj.core.dto.req.XN801040Req;
import com.cdkj.core.dto.req.XN801042Req;
import com.cdkj.core.dto.res.XN003025Res;
import com.cdkj.core.dto.res.XN003026Res;
import com.cdkj.core.enums.ECurrency;
import com.cdkj.core.enums.ECurrencyActivityStatus;
import com.cdkj.core.enums.EGeneratePrefix;
import com.cdkj.core.enums.EInteractCategory;
import com.cdkj.core.enums.EInteractType;
import com.cdkj.core.enums.ESystemCode;
import com.cdkj.core.exception.BizException;

@Service
public class CurrencyActivityAOImpl implements ICurrencyActivityAO {
    protected static final Logger logger = LoggerFactory
        .getLogger(CurrencyActivityAOImpl.class);

    @Autowired
    private ICurrencyActivityBO currencyActivityBO;

    @Autowired
    private ICaigopoolBO caigopoolBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IInteractBO interactBO;

    @Override
    public String addCurrencyActivity(XN801040Req req) {
        boolean flag = ECurrency.getResultMap().containsKey(req.getCurrency());
        if (!flag) {
            throw new BizException("xn0000", "没有该币种");
        }
        Date startDatetime = DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.DATA_TIME_PATTERN_1);
        Date endDatetime = DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.DATA_TIME_PATTERN_1);
        if (endDatetime.before(startDatetime)) {
            throw new BizException("xn0000", "结束时间不能早于开始时间");
        }
        CurrencyActivity data = new CurrencyActivity();
        String code = OrderNoGenerater
            .generateME(EGeneratePrefix.CurrencyActivity.getCode());
        data.setCode(code);
        data.setType(req.getType());
        data.setTitle(req.getTitle());
        data.setAdvPic(req.getAdvPic());
        data.setSlogn(req.getSlogn());
        data.setDescription(req.getDescription());
        data.setStartDatetime(startDatetime);
        data.setEndDatetime(endDatetime);
        data.setCurrency(req.getCurrency());
        data.setNumber(StringValidater.toLong(req.getNumber()));
        data.setIndirectNumber(StringValidater.toLong(req.getIndirectNumber()));
        data.setStatus(ECurrencyActivityStatus.DRAFT.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        data.setCompanyCode(req.getCompanyCode());
        data.setSystemCode(req.getSystemCode());
        currencyActivityBO.saveCurrencyActivity(data);
        return code;
    }

    @Override
    public void editCurrencyActivity(XN801042Req req) {
        boolean flag = ECurrency.getResultMap().containsKey(req.getCurrency());
        if (!flag) {
            throw new BizException("xn0000", "没有该币种");
        }
        Date startDatetime = DateUtil.strToDate(req.getStartDatetime(),
            DateUtil.DATA_TIME_PATTERN_1);
        Date endDatetime = DateUtil.strToDate(req.getEndDatetime(),
            DateUtil.DATA_TIME_PATTERN_1);
        if (endDatetime.before(startDatetime)) {
            throw new BizException("xn0000", "结束时间不能早于开始时间");
        }
        CurrencyActivity data = currencyActivityBO.getCurrencyActivity(req
            .getCode());
        if (data.getStatus().equals(ECurrencyActivityStatus.ONLINE.getCode())) {
            throw new BizException("xn0000", "活动上线中,不能修改");
        }
        data.setType(req.getType());
        data.setTitle(req.getTitle());
        data.setAdvPic(req.getAdvPic());
        data.setSlogn(req.getSlogn());
        data.setDescription(req.getDescription());
        data.setStartDatetime(startDatetime);
        data.setEndDatetime(endDatetime);
        data.setCurrency(req.getCurrency());
        data.setNumber(StringValidater.toLong(req.getNumber()));
        data.setIndirectNumber(StringValidater.toLong(req.getIndirectNumber()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        currencyActivityBO.refreshCurrencyActivity(data);
    }

    @Override
    public void dropCurrencyActivity(String code) {
        CurrencyActivity data = currencyActivityBO.getCurrencyActivity(code);
        if (data.getStatus().equals(ECurrencyActivityStatus.ONLINE.getCode())) {
            throw new BizException("xn0000", "活动上线中,不能删除");
        }
        Caigopool caigopool = caigopoolBO.getCaigopoolByActivityCode(code);
        if (null != caigopool) {
            caigopoolBO.removeCaigopool(caigopool);
        }
        currencyActivityBO.removeCurrencyActivity(code);

    }

    @Override
    public Paginable<CurrencyActivity> queryCurrencyActivityPage(int start,
            int limit, CurrencyActivity condition) {
        Paginable<CurrencyActivity> page = currencyActivityBO.getPaginable(
            start, limit, condition);
        List<CurrencyActivity> currencyActivityList = page.getList();
        if (CollectionUtils.isNotEmpty(currencyActivityList)) {
            for (CurrencyActivity currencyActivity : currencyActivityList) {
                Long count = interactBO.totalInteract(
                    EInteractCategory.ACTIVITY.getCode(),
                    EInteractType.SHARE.getCode(), currencyActivity.getCode(),
                    null, null, null, null, currencyActivity.getCompanyCode(),
                    currencyActivity.getSystemCode());
                currencyActivity.setCount(count);
            }
        }
        return page;
    }

    @Override
    public List<CurrencyActivity> queryCurrencyActivityList(
            CurrencyActivity condition) {
        return currencyActivityBO.queryCurrencyActivityList(condition);
    }

    @Override
    public CurrencyActivity getCurrencyActivity(String code) {
        CurrencyActivity currencyActivity = currencyActivityBO
            .getCurrencyActivity(code);
        if (null != currencyActivity) {
            Long count = interactBO.totalInteract(
                EInteractCategory.ACTIVITY.getCode(),
                EInteractType.SHARE.getCode(), currencyActivity.getCode(),
                null, null, null, null, currencyActivity.getCompanyCode(),
                currencyActivity.getSystemCode());
            currencyActivity.setCount(count);
        }
        return currencyActivity;
    }

    @Override
    public void putOn(String code, String location, String orderNo,
            String updater, String remark) {
        CurrencyActivity data = currencyActivityBO.getCurrencyActivity(code);
        if (data.getStatus().equals(ECurrencyActivityStatus.ONLINE.getCode())) {
            throw new BizException("xn0000", "活动已上线,不能重复上架");
        }
        if (ESystemCode.SYS_USER_CAIGO.getCode().equals(data.getSystemCode())) {
            Caigopool caigopool = caigopoolBO.getCaigopoolByActivityCode(code);
            if (caigopool == null) {
                throw new BizException("xn0000", "活动还没有设立奖池，不能上架");
            }
        } else {
            Long num = currencyActivityBO.getTotalCount(data.getType());
            if (num >= 1) {
                throw new BizException("xn0000", "同种类型的活动一次只能上架一个");
            }
        }
        currencyActivityBO.putOn(data, location, orderNo, updater, remark);
    }

    @Override
    public void putOff(String code, String updater, String remark) {
        CurrencyActivity data = currencyActivityBO.getCurrencyActivity(code);
        if (!data.getStatus().equals(ECurrencyActivityStatus.ONLINE.getCode())) {
            throw new BizException("xn0000", "活动未上线,不能下架");
        }
        currencyActivityBO.putOff(data, updater, remark);
    }

    @Override
    public XN003025Res checkCurrencyActivity(String code, String companyCode,
            String systemCode) {
        CurrencyActivity data = currencyActivityBO.getCurrencyActivity(code,
            companyCode, systemCode);
        if (!data.getStatus().equals(ECurrencyActivityStatus.ONLINE.getCode())) {
            throw new BizException("xn0000", "活动未上线,不能参与");
        }
        Date startDatetime = data.getStartDatetime();
        Date endDatetime = data.getEndDatetime();
        if (startDatetime.after(new Date())) {
            throw new BizException("xn0000", "活动还未开始,不能参与");
        }
        if (endDatetime.before(new Date())) {
            throw new BizException("xn0000", "活动已结束,不能继续参与");
        }
        XN003025Res res = new XN003025Res();
        res.setType(data.getType());
        res.setCurrency(data.getCurrency());
        res.setNumber(data.getNumber());
        return res;
    }

    @Override
    public XN003026Res getCurrencyActivity(String code, String type,
            String companyCode, String systemCode) {
        XN003026Res res = new XN003026Res();
        CurrencyActivity data = currencyActivityBO.getCurrencyActivityByType(
            code, type, companyCode, systemCode);
        if (data != null) {
            res.setCurrency(data.getCurrency());
            res.setNumber(data.getNumber());
        }
        return res;
    }

    @Override
    public void changeCurrencyActivityStatus() {
        logger.info("-------活动开始状态扫描--------");
        CurrencyActivity condition = new CurrencyActivity();
        condition.setEndDatetime(new Date());
        condition.setStatus(ECurrencyActivityStatus.ONLINE.getCode());
        List<CurrencyActivity> currencyActivityList = currencyActivityBO
            .queryCurrencyActivityList(condition);
        for (CurrencyActivity currencyActivity : currencyActivityList) {
            currencyActivityBO.putOff(currencyActivity, "系统下架", "系统下架");
        }
        logger.info("-------活动结束状态扫描--------");
    }
}
