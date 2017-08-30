package com.cdkj.core.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.IAccountBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.common.PropertiesUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Account;
import com.cdkj.core.dto.req.XN001303Req;
import com.cdkj.core.dto.req.XN002050Req;
import com.cdkj.core.dto.req.XN002100Req;
import com.cdkj.core.dto.req.XN002501Req;
import com.cdkj.core.dto.res.XN001303Res;
import com.cdkj.core.dto.res.XN002050Res;
import com.cdkj.core.dto.res.XN002501Res;
import com.cdkj.core.enums.EBizType;
import com.cdkj.core.enums.EChannelType;
import com.cdkj.core.enums.ECurrency;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.http.BizConnecter;
import com.cdkj.core.http.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author: xieyj 
 * @since: 2016年12月23日 下午5:24:53 
 * @history:
 */
@Component
public class AccountBOImpl extends PaginableBOImpl<Account> implements
        IAccountBO {
    @Override
    public void doTransferAmountRemote(String fromUserId, String toUserId,
            ECurrency currency, Long amount, EBizType bizType,
            String fromBizNote, String toBizNote, String refNo) {
        if (amount != null && amount != 0) {
            XN002100Req req = new XN002100Req();
            req.setFromUserId(fromUserId);
            req.setToUserId(toUserId);
            req.setFromCurrency(currency.getCode());
            req.setToCurrency(currency.getCode());
            req.setTransAmount(String.valueOf(amount));
            req.setBizType(bizType.getCode());
            req.setFromBizNote(fromBizNote);
            req.setToBizNote(toBizNote);
            req.setRefNo(refNo);
            BizConnecter.getBizData("002100", JsonUtils.object2Json(req),
                Object.class);
        }
    }

    @Override
    public Long getAccountByUserId(String userId, EChannelType type) {
        Long amount = 0L;
        XN001303Req req = new XN001303Req();
        req.setUserId(userId);
        req.setCurrency(type.getCode());
        String jsonStr = BizConnecter.getBizData("002050",
            JsonUtils.object2Json(req));
        Gson gson = new Gson();
        List<XN001303Res> list = gson.fromJson(jsonStr,
            new TypeToken<List<XN001303Res>>() {
            }.getType());
        if (CollectionUtils.isEmpty(list)) {
            throw new BizException("xn000000", "账户不存在");
        }
        XN001303Res res = list.get(0);
        amount = StringValidater.toLong(res.getAddAmount());
        return amount;
    }

    @Override
    public XN002501Res doWeiXinH5PayRemote(String fromUserId,
            String fromOpenId, String toUserId, String payGroup, String refNo,
            EBizType bizType, String bizNote, Long amount) {
        // 获取微信H5支付信息
        XN002501Req req = new XN002501Req();
        req.setApplyUser(fromUserId);
        req.setOpenId(fromOpenId);
        req.setToUser(toUserId);
        req.setPayGroup(payGroup);
        req.setRefNo(refNo);
        req.setBizType(bizType.getCode());
        req.setBizNote(bizNote);
        req.setAmount(String.valueOf(amount));
        req.setBackUrl(PropertiesUtil.Config.PAY_BACK_URL);
        System.out.println(fromUserId + "" + fromOpenId + "" + toUserId + ""
                + amount + "" + bizType + "" + bizNote + "" + payGroup);
        XN002501Res res = BizConnecter.getBizData("002501",
            JsonUtil.Object2Json(req), XN002501Res.class);
        return res;
    }

    @Override
    public Account getRemoteAccount(String userId, ECurrency currency) {
        XN002050Req req = new XN002050Req();
        req.setUserId(userId);
        req.setCurrency(currency.getCode());
        String jsonStr = BizConnecter.getBizData("002050",
            JsonUtils.object2Json(req));
        Gson gson = new Gson();
        List<XN002050Res> list = gson.fromJson(jsonStr,
            new TypeToken<List<XN002050Res>>() {
            }.getType());
        if (CollectionUtils.isEmpty(list)) {
            throw new BizException("xn000000", "用户[" + userId + "]账户不存在");
        }
        XN002050Res res = list.get(0);
        Account account = new Account();
        account.setAccountNumber(res.getAccountNumber());
        account.setUserId(res.getUserId());
        account.setRealName(res.getRealName());
        account.setType(res.getType());
        account.setStatus(res.getStatus());

        account.setCurrency(res.getCurrency());
        account.setAmount(res.getAmount());
        account.setFrozenAmount(res.getFrozenAmount());
        account.setCreateDatetime(res.getCreateDatetime());
        account.setLastOrder(res.getLastOrder());

        account.setSystemCode(res.getSystemCode());
        return account;
    }
}
