package com.cdkj.core.dto.req;

import java.util.Date;

/**
 * 修改资讯
 * @author: xieyj 
 * @since: 2017年8月31日 下午5:47:53 
 * @history:
 */
public class XN801002Req {

    // 编号（必填）
    private String code;

    // 标题（必填）
    private String title;

    // 关键字（选填）
    private String keywords;

    // 内容（必填）
    private String content;

    // 广告图片（选填）
    private String advPic;

    // 图片（选填）
    private String pic;

    // 更新人（必填）
    private String updater;

    // 更新人（必填）
    private Date updateDatetime;

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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}
