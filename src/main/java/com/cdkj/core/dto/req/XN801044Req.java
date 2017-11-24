package com.cdkj.core.dto.req;

/**
 * 下架送币类活动
 * @author: asus 
 * @since: 2017年10月10日 下午2:24:18 
 * @history:
 */
public class XN801044Req {
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
