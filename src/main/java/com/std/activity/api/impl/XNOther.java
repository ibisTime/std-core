package com.std.activity.api.impl;

import com.std.activity.api.AProcessor;
import com.std.activity.exception.BizException;
import com.std.activity.exception.ParaException;

public class XNOther extends AProcessor {

    @Override
    public Object doBusiness() throws BizException {
        throw new BizException("702xxx", "无效API功能号");
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        throw new ParaException("702xxx", "无效API功能号");

    }

}
