package com.cdkj.core.dto.req;

/**
 * 修改游记
 * @author: asus 
 * @since: 2017年2月11日 下午8:55:54 
 * @history:
 */
public class XN801052Req {
    // 编号(必填)
    private String code;

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

    public String getRunTeamList() {
        return runTeamList;
    }

    public void setRunTeamList(String runTeamList) {
        this.runTeamList = runTeamList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
