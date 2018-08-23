package com.cdkj.core.dto.req;

/**
 * 分页查询游记
 * @author: asus 
 * @since: 2017年2月11日 下午10:21:11 
 * @history:
 */
public class XN801055Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 文字描述(选填)
    private String description;

    // 跑团(选填)
    private String runTeamList;

    // 状态(选填)
    private String status;

    // 公司编号(必填)
    private String companyCode;

    // 系统编号(必填)
    private String systemCode;

    public String getRunTeamList() {
        return runTeamList;
    }

    public void setRunTeamList(String runTeamList) {
        this.runTeamList = runTeamList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
