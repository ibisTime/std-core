package com.cdkj.core.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.core.ao.IInteractAO;
import com.cdkj.core.bo.IInteractBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.domain.Interact;
import com.cdkj.core.dto.req.XN801030Req;
import com.cdkj.core.dto.req.XN801031Req;
import com.cdkj.core.enums.EGeneratePrefix;
import com.cdkj.core.enums.EInteractType;
import com.cdkj.core.exception.BizException;

//801030-801039
@Service
public class InteractAOImpl implements IInteractAO {

    @Autowired
    private IInteractBO interactBO;

    @Override
    public String addInteract(XN801030Req req) {
        EInteractType.getDirectionMap().containsKey(req.getType());
        Interact data = new Interact();
        String code = OrderNoGenerater.generate(EGeneratePrefix.Interact
            .getCode());
        data.setCode(code);
        data.setType(req.getType());
        data.setEntityCode(req.getEntityCode());
        data.setInteracter(req.getInteracter());
        data.setInteractDatetime(new Date());
        data.setCompanyCode(req.getCompanyCode());
        data.setSystemCode(req.getSystemCode());
        interactBO.saveInteract(data);
        return code;
    }

    @Override
    public void editInteract(Interact data) {
        if (!interactBO.isInteractExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        interactBO.refreshInteract(data);
    }

    @Override
    public void dropInteract(XN801031Req req) {
        EInteractType.getDirectionMap().containsKey(req.getType());
        Interact condition = new Interact();
        condition.setType(req.getType());
        condition.setEntityCode(req.getEntityCode());
        condition.setInteracter(req.getInteracter());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());
        List<Interact> interactList = interactBO.queryInteractList(condition);
        if (CollectionUtils.isNotEmpty(interactList)) {
            for (Interact interact : interactList) {
                interactBO.removeInteract(interact);
            }
        }
    }

    @Override
    public Paginable<Interact> queryInteractPage(int start, int limit,
            Interact condition) {
        return interactBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Interact> queryInteractList(Interact condition) {
        return interactBO.queryInteractList(condition);
    }

    @Override
    public Interact getInteract(String code, String companyCode,
            String systemCode) {
        return interactBO.getInteract(code, companyCode, systemCode);
    }
}
