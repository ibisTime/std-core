package com.cdkj.core.domain;

import com.cdkj.core.dao.base.ABaseDO;

/**
* 国家
* @author: haiqingzheng
* @since: 2018年06月29日 00:10:14
* @history:
*/
public class Country extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 国家编号
    private String code;

    // 国际代码
    private String interCode;

    // 国际名称
    private String interName;

    // 中文名称
    private String chineseName;

    // 本国语言名称
    private String localName;

    // 国际简码
    private String interSimpleCode;

    // 所属洲际
    private String continent;

    // 国旗图片
    private String pic;

    // 展示顺序
    private Integer orderNo;

    // 状态
    private String status;

    // 国际代码查询条件
    private String interCodeForQuery;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInterCodeForQuery() {
        return interCodeForQuery;
    }

    public void setInterCodeForQuery(String interCodeForQuery) {
        this.interCodeForQuery = interCodeForQuery;
    }

}
