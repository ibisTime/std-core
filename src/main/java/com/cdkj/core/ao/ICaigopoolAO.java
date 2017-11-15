package com.cdkj.core.ao;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.Caigopool;
import com.cdkj.core.dto.req.XN801130Req;

public interface ICaigopoolAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCaigoPool(XN801130Req req);

    public void addAmount(String code, Long czAmount, Long amount,
            String addUser, String remark);

    public Paginable<Caigopool> queryCaigopoolPage(int start, int limit,
            Caigopool condition);

    public Caigopool getCaigopool(String code);

}
