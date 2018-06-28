package com.cdkj.core.bo;

import java.util.List;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.Interact;
import com.cdkj.core.enums.EInteractKind;
import com.cdkj.core.enums.EInteractType;

public interface IInteractBO extends IPaginableBO<Interact> {

    public void saveInteract(Interact data);

    public void saveInteract(String userId, EInteractType type,
            EInteractKind kind, String entityCode, String companyCode,
            String systemCode);

    public void saveInteractDs(String userId, String toUser, Long quantity,
            EInteractType type, EInteractKind kind, String entityCode,
            String remark, String companyCode, String systemCode);

    public void removeInteract(Interact interact);

    public void removeInteractByEntityCode(String entityCode);

    public void refreshInteract(Interact data);

    public List<Interact> queryInteractList(Interact condition);

    public Interact getInteract(String code, String companyCode,
            String systemCode);

    public boolean isInteract(String userId, String type, String entityCode,
            String companyCode, String systemCode);

    public boolean isInteract(String userId, EInteractType type,
            EInteractKind kind, String entityCode, String companyCode,
            String systemCode);

    public Interact getInteract(String userId, EInteractType type,
            EInteractKind kind, String entityCode, String companyCode,
            String systemCode);

    public List<Interact> queryInteractList(String kind, String type,
            String entityCode, String interacter, String companyCode,
            String systemCode);

    public List<Interact> queryInteractList(EInteractType type,
            EInteractKind kind, String entityCode, String companyCode,
            String systemCode);

    public int getTotalCountInteract(EInteractType type, EInteractKind kind,
            String entityCode, String companyCode, String systemCode);

    public long getTotalAmountToday(EInteractType type, EInteractKind kind,
            String interacter, String toUser);
}
