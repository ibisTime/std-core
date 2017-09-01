package com.cdkj.core.ao;

import java.util.List;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.Keyword;
import com.cdkj.core.dto.req.XN802012Req;
import com.cdkj.core.dto.req.XN801010CReq;

public interface IKeywordAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void addKeywords(List<XN801010CReq> reqList, String companyCode,
            String systemCode);

    public void dropKeyword(String code);

    public void editKeyword(XN802012Req req);

    public Paginable<Keyword> queryKeywordPage(int start, int limit,
            Keyword condition);

    public Keyword getKeyword(String code);

}
