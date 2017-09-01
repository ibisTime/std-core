package com.cdkj.core.dto.req;

/**
 * 下架资讯
 * @author: xieyj 
 * @since: 2017年8月31日 下午5:42:15 
 * @history:
 */
public class XN801004Req {

    // 编号（必填）
    private String code;

    // 更新人（必填）
    private String updater;

    // 备注（选填）
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
