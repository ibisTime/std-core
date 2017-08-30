package com.cdkj.core.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.core.ao.IKeywordAO;
import com.cdkj.core.bo.IKeywordBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Keyword;
import com.cdkj.core.dto.req.XN660040Req;
import com.cdkj.core.dto.req.XN660042Req;
import com.cdkj.core.enums.EPrefixCode;

@Service
public class KeywordAOImpl implements IKeywordAO {

    @Autowired
    private IKeywordBO keywordBO;

    @Override
    public String addKeyword(XN660040Req req) {
        Keyword data = new Keyword();
        String code = OrderNoGenerater.generate(EPrefixCode.KEYWORD.getCode());
        data.setCode(code);
        data.setWord(req.getWord());
        data.setWeight(StringValidater.toDouble(req.getWeight()));
        data.setLevel(req.getLevel());
        data.setReaction(req.getReaction());

        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        keywordBO.saveKeyword(data);
        return code;
    }

    @Override
    public void dropKeyword(String code) {
        keywordBO.removeKeyword(code);
    }

    @Override
    public void editKeyword(XN660042Req req) {

        Keyword result = new Keyword();
        result.setCode(req.getCode());
        result.setWord(req.getWord());
        result.setWeight(StringValidater.toDouble(req.getWeight()));
        result.setLevel(req.getLevel());
        result.setReaction(req.getReaction());

        result.setUpdater(req.getUpdater());
        result.setUpdateDatetime(new Date());
        result.setRemark(req.getRemark());
        keywordBO.refreshKeyword(result);
    }

    @Override
    public Paginable<Keyword> queryKeywordPage(int start, int limit,
            Keyword condition) {
        return keywordBO.getPaginable(start, limit, condition);
    }

    @Override
    public Keyword getKeyword(String code) {
        return keywordBO.getKeyword(code);
    }

    @Override
    public void addKeyword(List<XN660040Req> reqList) {
        for (XN660040Req req : reqList) {
            this.addKeyword(req);
        }
    }
}
