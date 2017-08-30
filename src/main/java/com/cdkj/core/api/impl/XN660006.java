package com.cdkj.core.api.impl;

import com.cdkj.core.ao.IActivityOrderAO;
import com.cdkj.core.api.AProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.core.StringValidater;
import com.cdkj.core.dto.req.XN660006Req;
import com.cdkj.core.dto.res.BooleanRes;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.spring.SpringContextHolder;

/**
 * 开始活动
 * @author: asus 
 * @since: 2017年7月17日 上午10:47:18 
 * @history:
 */
public class XN660006 extends AProcessor {
    private IActivityOrderAO activityOrderAO = SpringContextHolder
        .getBean(IActivityOrderAO.class);

    private XN660006Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        activityOrderAO.beginActivity(req.getCode(), req.getUpdater(),
            req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN660006Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater());
    }
}
