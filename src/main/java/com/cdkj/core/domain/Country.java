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

    // 展示顺序
    private Integer orderNo;

    // 状态
    private String status;

    // 国际代码查询条件
    private String interCodeForQuery;

    public void setInterCode(String interCode) {
        this.interCode = interCode;
    }

    public String getInterCode() {
        return interCode;
    }

    public void setInterName(String interName) {
        this.interName = interName;
    }

    public String getInterName() {
        return interName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setInterSimpleCode(String interSimpleCode) {
        this.interSimpleCode = interSimpleCode;
    }

    public String getInterSimpleCode() {
        return interSimpleCode;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinent() {
        return continent;
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
