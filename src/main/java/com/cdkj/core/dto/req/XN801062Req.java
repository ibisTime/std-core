package com.cdkj.core.dto.req;

/**
 * 修改宣传类活动
 * @author: asus 
 * @since: 2017年10月10日 下午3:01:08 
 * @history:
 */
public class XN801062Req {
    // 编号（必填）
    private String code;

    // 类型（必填）
    private String type;

    // 广告图
    private String advPic;

    // 图文描述（必填）
    private String description;

    // 开始时间（必填）
    private String startDatetime;

    // 结束时间（必填）
    private String endDatetime;

    //
    private String value1;

    //
    private String value2;

    //
    private String value3;

    // 更新人（必填）
    private String updater;

    // 备注（选填）
    private String remark;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

}
