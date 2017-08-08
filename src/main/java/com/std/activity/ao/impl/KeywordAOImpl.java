package com.std.activity.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.activity.ao.IKeywordAO;
import com.std.activity.bo.IKeywordBO;
import com.std.activity.bo.base.Paginable;
import com.std.activity.core.OrderNoGenerater;
import com.std.activity.core.StringValidater;
import com.std.activity.domain.Keyword;
import com.std.activity.dto.req.XN622000Req;
import com.std.activity.dto.req.XN622002Req;
import com.std.activity.enums.EPrefixCode;

@Service
public class KeywordAOImpl implements IKeywordAO {

    @Autowired
    private IKeywordBO keywordBO;

    @Override
    public String addKeyword(XN622000Req req) {
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
    public void editKeyword(XN622002Req req) {

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
    public void addKeyword(List<XN622000Req> reqList) {
        for (XN622000Req req : reqList) {
            this.addKeyword(req);
        }
    }
}
