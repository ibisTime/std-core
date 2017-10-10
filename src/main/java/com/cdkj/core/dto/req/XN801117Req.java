package com.cdkj.core.dto.req;

/**
 * 分页查询优惠券
 * @author: asus 
 * @since: 2017年10月10日 下午2:51:30 
 * @history:
 */
public class XN801117Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -280248669997668366L;

    // 发个谁（选填）
    private String toUser;

    // 状态（选填）
    private String status;

    // 有效期始（选填）
    private String startDatetime;

    // 有效期止（选填）
    private String endDatetime;

    // 所属公司（必填）
    private String companyCode;

    // 系统编号（必填）
    private String systemCode;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

}
