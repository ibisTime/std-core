package com.cdkj.core.bo;

import java.util.List;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.Interact;

public interface IInteractBO extends IPaginableBO<Interact> {

    public void doCheckExist(String userId, String type, String entityCode);

    public void saveInteract(Interact data);

    public void removeInteract(Interact interact);

    public void refreshInteract(Interact data);

    public List<Interact> queryInteractList(Interact condition);

    public Interact getInteract(String code, String companyCode,
            String systemCode);

    public boolean isInteract(String userId, String type, String entityCode,
            String companyCode, String systemCode);

    public List<Interact> queryInteractList(String type, String entityCode,
            String interacter, String companyCode, String systemCode);
}
