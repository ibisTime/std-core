package com.cdkj.core.bo;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.Caigopool;
import com.cdkj.core.domain.CaigopoolBack;

public interface ICaigopoolBackBO extends IPaginableBO<CaigopoolBack> {

    public Long saveCaigopoolBack(Caigopool pool, String userId,
            String currency, Long amount, String remark);

    public CaigopoolBack getCaigopoolBack(Long id);

}
