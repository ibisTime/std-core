package com.cdkj.core.dto.req;

/**
 * 审核游记
 * @author: asus 
 * @since: 2017年2月11日 下午9:38:02 
 * @history:
 */
public class XN801053Req {
    private String code;

    private String approvelResult;

    private String updater;

    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApprovelResult() {
        return approvelResult;
    }

    public void setApprovelResult(String approvelResult) {
        this.approvelResult = approvelResult;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
