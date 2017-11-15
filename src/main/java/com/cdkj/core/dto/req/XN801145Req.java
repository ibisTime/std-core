package com.cdkj.core.dto.req;

/**
 * 分页查询奖池领取情况
 * @author: myb858 
 * @since: 2017年3月28日 下午5:35:39 
 * @history:
 */
public class XN801145Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -7326850181198200381L;

    // 池编号
    private String poolCode;

    // 活动编号
    private String activityCode;

    // 领取人
    private String toUser;

    // 所属公司编号
    private String companyCode;

    // 所属系统编号
    private String systemCode;

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
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

    public String getPoolCode() {
        return poolCode;
    }

    public void setPoolCode(String poolCode) {
        this.poolCode = poolCode;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

}
