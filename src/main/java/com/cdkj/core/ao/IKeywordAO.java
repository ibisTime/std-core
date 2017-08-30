package com.cdkj.core.ao;

import java.util.List;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.Keyword;
import com.cdkj.core.dto.req.XN660040Req;
import com.cdkj.core.dto.req.XN660042Req;

public interface IKeywordAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addKeyword(XN660040Req req);

    public void dropKeyword(String code);

    public void editKeyword(XN660042Req req);

    public Paginable<Keyword> queryKeywordPage(int start, int limit,
            Keyword condition);

    public Keyword getKeyword(String code);

    public void addKeyword(List<XN660040Req> reqList);

}
