package com.cdkj.core.ao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.core.ao.ICaigopoolAO;
import com.cdkj.core.bo.IAccountBO;
import com.cdkj.core.bo.ICaigopoolBO;
import com.cdkj.core.bo.ICurrencyActivityBO;
import com.cdkj.core.bo.ISYSConfigBO;
import com.cdkj.core.bo.IUserBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Caigopool;
import com.cdkj.core.dto.req.XN801130Req;
import com.cdkj.core.enums.EBizType;
import com.cdkj.core.enums.ECurrency;
import com.cdkj.core.enums.EGeneratePrefix;
import com.cdkj.core.enums.ESysUser;
import com.cdkj.core.exception.BizException;

@Service
public class CaigopoolAOImpl implements ICaigopoolAO {

    @Autowired
    private ICaigopoolBO caigopoolBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Autowired
    private ICurrencyActivityBO currencyActivityBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public Paginable<Caigopool> queryCaigopoolPage(int start, int limit,
            Caigopool condition) {
        return caigopoolBO.getPaginable(start, limit, condition);
    }

    @Override
    public Caigopool getCaigopool(String code) {
        return caigopoolBO.getCaigopool(code);
    }

    @Override
    public void addAmount(String code, Long czAmount, Long amount,
            String addUser, String remark) {
        Caigopool pool = caigopoolBO.getCaigopool(code);
        caigopoolBO.addAmount(pool, czAmount, amount, addUser, remark);
        accountBO.doTransferAmountRemote(ESysUser.SYS_USER_CAIGO.getCode(),
            ECurrency.CNY.getCode(), czAmount, EBizType.HUODONG,
            EBizType.HUODONG.getValue());
    }

    @Override
    public String addCaigoPool(XN801130Req req) {
        Long number = caigopoolBO.queryCaigopoolByActivityCode(req
            .getActivityCode());
        if (number > 0) {
            throw new BizException("xn0000", "该活动已有奖池");
        }
        Caigopool data = new Caigopool();
        String code = OrderNoGenerater.generate(EGeneratePrefix.Caigopool
            .getCode());
        data.setCode(code);
        data.setActivityCode(req.getActivityCode());
        data.setCzAmount(StringValidater.toLong(req.getCzAmount()));
        data.setAmount(StringValidater.toLong(req.getAmount()));
        data.setUsedAmount(0L);
        data.setAddUser(req.getAddUser());
        data.setAddDatetime(new Date());
        data.setRemark(req.getRemark());
        data.setCompanyCode(req.getCompanyCode());
        data.setSystemCode(req.getSystemCode());
        caigopoolBO.saveCaipool(data);
        accountBO.doTransferAmountRemote(ESysUser.SYS_USER_CAIGO.getCode(),
            ECurrency.CNY.getCode(), StringValidater.toLong(req.getCzAmount()),
            EBizType.HUODONG, EBizType.HUODONG.getValue());
        return code;
    }
}
