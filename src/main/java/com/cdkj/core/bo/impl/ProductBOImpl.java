/**
 * @Title ProductAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月16日 下午9:37:38 
 * @version V1.0   
 */
package com.cdkj.core.bo.impl;

import org.springframework.stereotype.Service;

import com.cdkj.core.bo.IProductBO;
import com.cdkj.core.dto.req.XN004000Req;
import com.cdkj.core.dto.res.XN004000Res;
import com.cdkj.core.http.BizConnecter;
import com.cdkj.core.http.JsonUtils;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月16日 下午9:37:38 
 * @history:
 */
@Service
public class ProductBOImpl implements IProductBO {

    @Override
    public XN004000Res getProduct(String code, String companyCode,
            String systemCode) {
        XN004000Req req = new XN004000Req();
        req.setCode(code);
        req.setCompanyCode(companyCode);
        req.setSystemCode(systemCode);
        return BizConnecter.getBizData("004000", JsonUtils.object2Json(req),
            XN004000Res.class);
    }
}
