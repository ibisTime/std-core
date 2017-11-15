package com.cdkj.core.bo;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.Caigopool;

public interface ICaigopoolBO extends IPaginableBO<Caigopool> {

    public Caigopool getCaigopool();

    public void saveCaipool(Caigopool data);

    public Caigopool getCaigopool(String code);

    public Caigopool getCaigopoolByActivityCode(String activityCode);

    public int addAmount(Caigopool pool, Long czAmount, Long amount,
            String addUser, String remark);

    public int outAmount(Caigopool pool, Long usedAmount);

    public Long queryCaigopoolByActivityCode(String activityCode);

    public void removeCaigopool(Caigopool caigopool);
}
