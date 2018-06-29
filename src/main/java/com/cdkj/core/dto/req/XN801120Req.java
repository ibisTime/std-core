package com.cdkj.core.dto.req;

/**
 * 分页查询国家
 * @author: asus 
 * @since: 2017年10月10日 下午2:51:30 
 * @history:
 */
public class XN801120Req extends APageReq {

    private static final long serialVersionUID = -7398195522667173616L;

    // 国际代码
    private String interCode;

    // 国际名称
    private String interName;

    // 中文名称
    private String chineseName;

    // 国际简码
    private String interSimpleCode;

    // 所属洲际
    private String continent;

    // 状态
    private String status;

    public String getInterCode() {
        return interCode;
    }

    public void setInterCode(String interCode) {
        this.interCode = interCode;
    }

    public String getInterName() {
        return interName;
    }

    public void setInterName(String interName) {
        this.interName = interName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getInterSimpleCode() {
        return interSimpleCode;
    }

    public void setInterSimpleCode(String interSimpleCode) {
        this.interSimpleCode = interSimpleCode;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
