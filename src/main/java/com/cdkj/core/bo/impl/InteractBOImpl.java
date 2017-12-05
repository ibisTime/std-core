package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.IInteractBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.dao.IInteractDAO;
import com.cdkj.core.domain.Interact;
import com.cdkj.core.enums.EGeneratePrefix;
import com.cdkj.core.enums.EInteractKind;
import com.cdkj.core.enums.EInteractType;
import com.cdkj.core.exception.BizException;

@Component
public class InteractBOImpl extends PaginableBOImpl<Interact> implements
        IInteractBO {

    @Autowired
    private IInteractDAO interactDAO;

    @Override
    public void doCheckExist(String userId, String type, String entityCode) {
        Interact condition = new Interact();
        condition.setInteracter(userId);
        condition.setType(type);
        condition.setEntityCode(entityCode);
        if (getTotalCount(condition) > 0) {
            throw new BizException("xn000000", "您已"
                    + EInteractType.getMap().get(type).getValue() + ",无需再次操作");
        }
    }

    @Override
    public void saveInteract(Interact data) {
        interactDAO.insert(data);
    }

    @Override
    public void saveInteract(String userId, EInteractType type,
            EInteractKind kind, String entityCode, String companyCode,
            String systemCode) {
        if (StringUtils.isNotBlank(userId)) {
            Interact data = new Interact();
            String code = OrderNoGenerater.generateME(EGeneratePrefix.Interact
                .getCode());
            data.setCode(code);
            data.setType(type.getCode());
            data.setKind(kind.getCode());
            data.setInteracter(userId);
            data.setEntityCode(entityCode);
            data.setCompanyCode(companyCode);
            data.setSystemCode(systemCode);
            data.setInteractDatetime(new Date());
            interactDAO.insert(data);
        }
    }

    @Override
    public void saveInteract(String userId, EInteractType type,
            EInteractKind kind, String entityCode, String remark,
            String companyCode, String systemCode) {
        if (StringUtils.isNotBlank(userId)) {
            Interact data = new Interact();
            String code = OrderNoGenerater.generateME(EGeneratePrefix.Interact
                .getCode());
            data.setCode(code);
            data.setType(type.getCode());
            data.setKind(kind.getCode());
            data.setInteracter(userId);
            data.setEntityCode(entityCode);
            data.setRemark(remark);
            data.setCompanyCode(companyCode);
            data.setSystemCode(systemCode);
            data.setInteractDatetime(new Date());
            interactDAO.insert(data);
        }
    }

    @Override
    public void removeInteract(Interact interact) {
        interactDAO.delete(interact);
    }

    @Override
    public void refreshInteract(Interact data) {
        interactDAO.update(data);
    }

    @Override
    public List<Interact> queryInteractList(Interact condition) {
        return interactDAO.selectList(condition);
    }

    @Override
    public Interact getInteract(String code, String companyCode,
            String systemCode) {
        Interact data = null;
        if (StringUtils.isNotBlank(code)) {
            Interact condition = new Interact();
            condition.setCode(code);
            condition.setCompanyCode(companyCode);
            condition.setSystemCode(systemCode);
            data = interactDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }

    @Override
    public boolean isInteract(String userId, String type, String entityCode,
            String companyCode, String systemCode) {
        boolean result = false;
        Interact condition = new Interact();
        condition.setInteracter(userId);
        condition.setEntityCode(entityCode);
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        if (getTotalCount(condition) > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean isInteract(String userId, EInteractType type,
            EInteractKind kind, String entityCode, String companyCode,
            String systemCode) {
        boolean result = false;
        Interact condition = new Interact();
        condition.setInteracter(userId);
        condition.setType(type.getCode());
        condition.setKind(kind.getCode());
        condition.setEntityCode(entityCode);
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        if (getTotalCount(condition) > 0) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Interact> queryInteractList(String type, String entityCode,
            String interacter, String companyCode, String systemCode) {
        Interact condition = new Interact();
        condition.setType(type);
        condition.setEntityCode(entityCode);
        condition.setInteracter(interacter);
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        return interactDAO.selectList(condition);
    }

    @Override
    public List<Interact> queryInteractList(EInteractType type,
            EInteractKind kind, String entityCode, String companyCode,
            String systemCode) {
        Interact condition = new Interact();
        condition.setType(type.getCode());
        condition.setKind(kind.getCode());
        condition.setEntityCode(entityCode);
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        return interactDAO.selectList(condition);
    }

    @Override
    public int getTotalCountInteract(EInteractType type, EInteractKind kind,
            String entityCode, String companyCode, String systemCode) {
        Interact condition = new Interact();
        condition.setType(type.getCode());
        condition.setKind(kind.getCode());
        condition.setEntityCode(entityCode);
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        return interactDAO.selectTotalCount(condition).intValue();
    }
}
