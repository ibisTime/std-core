package com.cdkj.core.proxy;

import org.apache.log4j.Logger;

import com.cdkj.core.api.IProcessor;
import com.cdkj.core.common.JsonUtil;
import com.cdkj.core.common.ReflectUtil;
import com.cdkj.core.enums.EErrorCode;
import com.cdkj.core.exception.BizException;
import com.cdkj.core.exception.ParaException;
import com.cdkj.core.http.BizConnecter;

public class DispatcherImpl implements IDispatcher {

    static Logger logger = Logger.getLogger(DispatcherImpl.class);

    @Override
    public String doDispatcher(String transcode, String inputParams) {
        String result = null;
        ReturnMessage rm = new ReturnMessage();
        try {
            // 加载配置文件,proxy实例化
            String classname = "com.cdkj.core.api.impl.XNOther";
            // ConfigDescribe configDescribe = ConfigLoader.loadConfig();
            // if (StringUtils.isNotBlank(transcode) && configDescribe != null)
            // {
            // List<String> codeList = configDescribe.getCodeList();
            // if (codeList.contains(transcode)) {
            // classname = "com.std.forum.api.impl.XN" + transcode;
            // }
            // }
            classname = "com.cdkj.core.api.impl.XN" + transcode;
            IProcessor processor = (IProcessor) ReflectUtil
                .getInstance(classname);
            // 接口调用
            Object data = processor.doProcessor(inputParams);
            rm.setErrorCode(EErrorCode.SUCCESS.getCode());
            rm.setErrorInfo(EErrorCode.SUCCESS.getValue());
            if (data == null) {
                rm.setData("");
            } else {
                rm.setData(data);
            }
        } catch (Exception e) {
            if (e instanceof BizException) {
                rm.setErrorCode(EErrorCode.BIZ_ERR.getCode());
                rm.setErrorInfo(((BizException) e).getErrorMessage());
                rm.setData("");
                logger.error("\nURL:" + BizConnecter.getPostUrl(transcode)
                        + "\ncode:" + transcode + "  parameters:" + inputParams
                        + "\ntype:" + EErrorCode.BIZ_ERR.getValue()
                        + "   info:" + ((BizException) e).getErrorMessage());
            } else if (e instanceof ParaException) {
                rm.setErrorCode(EErrorCode.PARA_ERR.getCode());
                rm.setErrorInfo(((ParaException) e).getErrorMessage());
                rm.setData("");
                logger.error("\nURL:" + BizConnecter.getPostUrl(transcode)
                        + "\ncode:" + transcode + "  parameters:" + inputParams
                        + "\ntype:" + EErrorCode.PARA_ERR.getValue()
                        + "   info:" + ((ParaException) e).getErrorMessage());
            } else if (e instanceof NullPointerException) {
                rm.setErrorCode(EErrorCode.OTHER_ERR.getCode());
                rm.setErrorInfo("NPE");
                // rm.setErrorInfo("系统错误，请联系管理员");
                rm.setData("");
                logger.error("\nURL:" + BizConnecter.getPostUrl(transcode)
                        + "\ncode:" + transcode + "  parameters:" + inputParams
                        + "\ntype:" + EErrorCode.OTHER_ERR.getValue()
                        + "   info:NPE" + "  系统错误,请联系管理员");
            } else {
                rm.setErrorCode(EErrorCode.OTHER_ERR.getCode());
                rm.setErrorInfo(e.getMessage());
                // rm.setErrorInfo("系统错误，请联系管理员");
                rm.setData("");
                logger.error("\nURL:" + BizConnecter.getPostUrl(transcode)
                        + "\ncode:" + transcode + "  parameters:" + inputParams
                        + "\ntype:" + EErrorCode.OTHER_ERR.getValue()
                        + "   info:" + e.getMessage() + "  系统错误,请联系管理员");

            }
        } finally {
            result = JsonUtil.Object2Json(rm);
        }
        return result;
    }
}
