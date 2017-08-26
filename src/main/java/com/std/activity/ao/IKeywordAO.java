package com.std.activity.ao;

import java.util.List;

import com.std.activity.bo.base.Paginable;
import com.std.activity.domain.Keyword;
import com.std.activity.dto.req.XN660040Req;
import com.std.activity.dto.req.XN660042Req;

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
