package com.cdkj.core.dto.req;

public class XN801050Req {
    // 标题(选填)
    private String title;

    // 描述(必填)
    private String description;

    // 图片多张(必填)
    private String pic;

    // 跑团
    private String runTeamList;

    // 发布人(必填)
    private String publisher;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
