package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.ISYSConfigBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.dao.ISYSConfigDAO;
import com.cdkj.core.domain.SYSConfig;
import com.cdkj.core.exception.BizException;

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
    public Map<String, String> getConfigsMap(String type, String companyCode,
            String systemCode) {
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isNotBlank(systemCode)) {
            SYSConfig condition = new SYSConfig();
            condition.setType(type);
            condition.setCompanyCode(companyCode);
            condition.setSystemCode(systemCode);
            List<SYSConfig> list = sysConfigDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                for (SYSConfig sysConfig : list) {
                    map.put(sysConfig.getCkey(), sysConfig.getCvalue());
                }
            }
        }
        return map;
    }
}
