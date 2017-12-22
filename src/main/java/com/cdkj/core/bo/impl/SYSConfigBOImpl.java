package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.ISYSConfigBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.dao.ISYSConfigDAO;
import com.cdkj.core.domain.SYSConfig;
import com.cdkj.core.dto.req.XN008001Req;
import com.cdkj.core.dto.res.XN008001Res;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.http.BizConnecter;
import com.cdkj.core.http.JsonUtils;

/**
 * @author: xieyj 
 * @since: 2017年4月23日 下午6:19:30 
 * @history:
 */
@Component
public class SYSConfigBOImpl extends PaginableBOImpl<SYSConfig> implements
        ISYSConfigBO {
    @Autowired
    private ISYSConfigDAO sysConfigDAO;

    @Override
    public int refreshSYSConfig(SYSConfig data) {
        int count = 0;
        if (data != null) {
            data.setUpdateDatetime(new Date());
            count = sysConfigDAO.updateValue(data);
        }
        return count;
    }

    @Override
    public SYSConfig getConfig(Long id) {
        SYSConfig sysConfig = null;
        if (id != null) {
            SYSConfig condition = new SYSConfig();
            condition.setId(id);
            sysConfig = sysConfigDAO.select(condition);
        }
        return sysConfig;
    }

    /** 
     * @see com.xnjr.base.bo.ISYSConfigBO#getConfigValue(java.lang.String)
     */
    @Override
    public SYSConfig getConfigValue(String ckey, String companyCode,
            String systemCode) {
        SYSConfig result = null;
        if (ckey != null) {
            SYSConfig condition = new SYSConfig();
            condition.setCkey(ckey);
            condition.setCompanyCode(companyCode);
            condition.setSystemCode(systemCode);
            result = sysConfigDAO.select(condition);
            if (null == result) {
                throw new BizException("xn000000", "id记录不存在");
            }
        }
        return result;
    }

    @Override
    public String getConfigValueRemote(String ckey, String companyCode,
            String systemCode) {
        String cvalue = null;
        if (StringUtils.isNotBlank(ckey)) {
            XN008001Req req = new XN008001Req();
            req.setKey(ckey);
            req.setCompanyCode(companyCode);
            req.setSystemCode(systemCode);
            XN008001Res res = BizConnecter.getBizData("008001",
                JsonUtils.object2Json(req), XN008001Res.class);
            if (res == null) {
                throw new BizException("XN000000", "系统参数不存在");
            }
            cvalue = res.getCvalue();
        }
        return cvalue;
    }

    @Override
    public List<SYSConfig> querySYSConfigList(String type) {
        SYSConfig condition = new SYSConfig();
        condition.setType(type);
        return sysConfigDAO.selectList(condition);
    }
}
