package com.cdkj.core.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.core.ao.IInteractAO;
import com.cdkj.core.bo.IAccountBO;
import com.cdkj.core.bo.ICaigopoolBO;
import com.cdkj.core.bo.ICaigopoolBackBO;
import com.cdkj.core.bo.ICurrencyActivityBO;
import com.cdkj.core.bo.IInteractBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.common.DateUtil;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.domain.Caigopool;
import com.cdkj.core.domain.CurrencyActivity;
import com.cdkj.core.domain.Interact;
import com.cdkj.core.dto.req.XN801030Req;
import com.cdkj.core.dto.req.XN801031Req;
import com.cdkj.core.dto.res.XN801030Res;
import com.cdkj.core.enums.EBizType;
import com.cdkj.core.enums.ECurrency;
import com.cdkj.core.enums.ECurrencyActivityStatus;
import com.cdkj.core.enums.EGeneratePrefix;
import com.cdkj.core.enums.EInteractCategory;
import com.cdkj.core.enums.EInteractType;
import com.cdkj.core.enums.ESysUser;
import com.cdkj.core.enums.ESystemCode;
import com.cdkj.core.exception.BizException;

@Service
public class InteractAOImpl implements IInteractAO {

    @Autowired
    private IInteractBO interactBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private ICaigopoolBO caigopoolBO;

    @Autowired
    private ICaigopoolBackBO caigopoolBackBO;

    @Autowired
    private ICurrencyActivityBO currencyActivityBO;

    @Override
    public XN801030Res addInteract(XN801030Req req) {
        EInteractCategory.getMap().containsKey(req.getCategory());
        EInteractType.getMap().containsKey(req.getType());
        String code = null;
        XN801030Res res = null;
        if (EInteractType.COLLECT.getCode().equals(req.getType())
                || EInteractType.LIKE.getCode().equals(req.getType())) {
            interactBO.doCheckExist(req.getInteracter(), req.getCategory(),
                req.getType(), req.getEntityCode());
        } else if (EInteractType.SHARE.getCode().equals(req.getType())) {// 分享
            Long number = interactBO.totalInteract(req.getCategory(),
                req.getType(), req.getEntityCode(), req.getInteracter(), null,
                null, null, req.getCompanyCode(), req.getSystemCode());
            if (number > 0) {
                return res;
            }
            if (ESystemCode.SYS_USER_CAIGO.getCode()
                .equals(req.getSystemCode())
                    && req.getEntityCode().startsWith(
                        EGeneratePrefix.CurrencyActivity.getCode())) {
                res = checkCurrencyActivity(req);
            }
        } else {
            Long number = interactBO.totalInteract(req.getCategory(),
                req.getType(), req.getEntityCode(), req.getInteracter(), null,
                DateUtil.getTodayStart(), DateUtil.getTodayEnd(),
                req.getCompanyCode(), req.getSystemCode());
            if (number > 0) {
                return res;
            }
        }
        Interact data = new Interact();
        code = OrderNoGenerater.generate(EGeneratePrefix.Interact.getCode());
        data.setCode(code);
        data.setCategory(req.getCategory());
        data.setType(req.getType());
        data.setEntityCode(req.getEntityCode());
        data.setInteracter(req.getInteracter());
        data.setInteractDatetime(new Date());
        data.setRefereer(req.getRefereer());
        data.setCompanyCode(req.getCompanyCode());
        data.setSystemCode(req.getSystemCode());
        interactBO.saveInteract(data);
        res.setCode(code);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }

    private XN801030Res checkCurrencyActivity(XN801030Req req) {
        Long amount = 0L;
        CurrencyActivity currencyActivity = currencyActivityBO
            .getCurrencyActivity(req.getEntityCode());
        if (currencyActivity.getStartDatetime().after(new Date())) {
            throw new BizException("xn0000", "活动未开始");
        }
        if (!ECurrencyActivityStatus.ONLINE.getCode().equals(
            currencyActivity.getStatus())
                || currencyActivity.getEndDatetime().before(new Date())) {
            throw new BizException("xn0000", "活动已经失效");
        }

        Caigopool caigopool = caigopoolBO.getCaigopoolByActivityCode(req
            .getEntityCode());
        if (caigopool == null) {
            throw new BizException("xn0000", "没有该活动的奖池");
        }
        if (caigopool.getAmount() == caigopool.getUsedAmount()) {// 如果钱不够，直接返回
            currencyActivityBO.putOff(currencyActivity, "奖池不足，系统下架",
                "奖池不足，系统下架");
            return new XN801030Res();
        }
        if (caigopool.getAmount() - caigopool.getUsedAmount() < currencyActivity
            .getNumber()) {// 如果不够直接推荐，就不加钱返回
            currencyActivityBO.putOff(currencyActivity, "奖池不足，系统下架",
                "奖池不足，系统下架");
            return new XN801030Res();
        }
        // 如果够直接推荐就加钱--本地系统记录
        caigopoolBackBO.saveCaigopoolBack(caigopool, req.getInteracter(),
            currencyActivity.getCurrency(), currencyActivity.getNumber(),
            EBizType.YJFX.getValue());
        accountBO.doTransferAmountRemote(ESysUser.SYS_USER_CAIGO.getCode(),
            req.getInteracter(),
            ECurrency.getResultMap().get(currencyActivity.getCurrency()),
            currencyActivity.getNumber(), EBizType.YJFX,
            EBizType.YJFX.getValue(), EBizType.YJFX.getValue(),
            req.getEntityCode());
        caigopoolBO.outAmount(caigopool, currencyActivity.getNumber());
        amount = currencyActivity.getNumber();

        if (StringUtils.isNotBlank(req.getRefereer())) {
            Caigopool pool = caigopoolBO.getCaigopoolByActivityCode(req
                .getEntityCode());
            if (pool.getAmount() - pool.getUsedAmount() < currencyActivity
                .getIndirectNumber()) {// 如果不够间接推荐，就不加钱返回
                currencyActivityBO.putOff(currencyActivity, "奖池不足，系统下架",
                    "奖池不足，系统下架");
                return new XN801030Res(currencyActivity.getCurrency(), amount);
            }
            Long number = interactBO.totalInteract(req.getCategory(),
                req.getType(), req.getEntityCode(), req.getInteracter(),
                req.getRefereer(), null, null, req.getCompanyCode(),
                req.getSystemCode());
            if (number > 0) {
                return new XN801030Res(currencyActivity.getCurrency(), amount);
            }
            // 如果够间接推荐就加钱--本地系统记录
            caigopoolBackBO.saveCaigopoolBack(pool, req.getRefereer(),
                currencyActivity.getCurrency(),
                currencyActivity.getIndirectNumber(), EBizType.JJFX.getValue());
            accountBO.doTransferAmountRemote(ESysUser.SYS_USER_CAIGO.getCode(),
                req.getRefereer(),
                ECurrency.getResultMap().get(currencyActivity.getCurrency()),
                currencyActivity.getIndirectNumber(), EBizType.JJFX,
                EBizType.JJFX.getValue(), EBizType.JJFX.getValue(),
                req.getEntityCode());
            caigopoolBO.outAmount(pool, currencyActivity.getIndirectNumber());
        }
        return new XN801030Res(currencyActivity.getCurrency(), amount);
    }

    @Override
    public void dropInteract(XN801031Req req) {
        EInteractCategory.getMap().containsKey(req.getCategory());
        EInteractType.getMap().containsKey(req.getType());
        if (req.getType().equals(EInteractType.SCAN.getCode())) {
            throw new BizException("xn0000", "浏览类型不能取消");
        }
        List<Interact> interactList = interactBO.queryInteractList(
            req.getCategory(), req.getType(), req.getEntityCode(),
            req.getInteracter(), req.getCompanyCode(), req.getSystemCode());
        if (CollectionUtils.isNotEmpty(interactList)) {
            for (Interact interact : interactList) {
                interactBO.removeInteract(interact);
            }
        } else {
            throw new BizException("xn0000", "您未成功"
                    + EInteractType.getMap().get(req.getType()).getValue()
                    + "过,不能取消");
        }
    }

    @Override
    public Paginable<Interact> queryInteractPage(int start, int limit,
            Interact condition) {
        Paginable<Interact> page = interactBO.getPaginable(start, limit,
            condition);
        List<Interact> list = page.getList();
        for (Interact interact : list) {
            interact.setInteractDatetimeTimes(interact.getInteractDatetime()
                .getTime());
            interact.setInteractDatetime(null);
        }
        return page;
    }

    @Override
    public List<Interact> queryInteractList(Interact condition) {
        return interactBO.queryInteractList(condition);
    }

    @Override
    public Interact getInteract(String code, String companyCode,
            String systemCode) {
        return interactBO.getInteract(code, companyCode, systemCode);
    }

    @Override
    public boolean isInteract(String userId, String category, String type,
            String entityCode, String companyCode, String systemCode) {
        return interactBO.isInteract(userId, category, type, entityCode,
            companyCode, systemCode);
    }

    @Override
    public Long totalInteract(String category, String type, String entityCode,
            String companyCode, String systemCode) {
        return interactBO.totalInteract(category, type, entityCode, null, null,
            null, null, companyCode, systemCode);
    }
}
