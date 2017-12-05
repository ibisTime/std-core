package com.cdkj.core.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.core.ao.IKeywordAO;
import com.cdkj.core.bo.IKeywordBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.domain.Keyword;
import com.cdkj.core.dto.req.XN801010CReq;
import com.cdkj.core.dto.req.XN802012Req;
import com.cdkj.core.enums.EPrefixCode;

@Service
public class KeywordAOImpl implements IKeywordAO {

    @Autowired
    private IKeywordBO keywordBO;

    @Override
    @Transactional
    public void addKeywords(List<XN801010CReq> reqList, String companyCode,
            String systemCode) {
        for (XN801010CReq req : reqList) {
            Keyword data = new Keyword();
            String code = OrderNoGenerater.generateME(EPrefixCode.KEYWORD
                .getCode());
            data.setCode(code);
            data.setWord(req.getWord());
            data.setWeight(StringValidater.toDouble(req.getWeight()));
            data.setLevel(req.getLevel());

            data.setReaction(req.getReaction());
            data.setUpdater(req.getUpdater());
            data.setUpdateDatetime(new Date());
            data.setRemark(req.getRemark());
            data.setCompanyCode(companyCode);

            data.setSystemCode(systemCode);
            keywordBO.saveKeyword(data);
        }
    }

    @Override
    public void dropKeyword(String code) {
        keywordBO.removeKeyword(code);
    }

    @Override
    public void editKeyword(XN802012Req req) {
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
}
