package com.cdkj.core.ao;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.CaigopoolBack;

public interface ICaigopoolBackAO {
    static final String DEFAULT_ORDER_COLUMN = "id";

    public Paginable<CaigopoolBack> queryCaigopoolBackPage(int start,
            int limit, CaigopoolBack condition);

    public CaigopoolBack getCaigopoolBack(Long id);

}
