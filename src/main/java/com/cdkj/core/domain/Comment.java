package com.cdkj.core.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.core.dao.base.ABaseDO;

/**
 * 评论
 * @author: xieyj 
 * @since: 2017年8月31日 下午8:26:03 
 * @history:
 */
public class Comment extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型
    private String type;

    // 得分
    private Integer score;

    // 评论内容
    private String content;

    // 状态
    private String status;

    // 评论人
    private String commenter;

    // 评论人名称
    private String commenterName;

    // 评论时间
    private Date commentDatetime;

    // 审核人
    private String approver;

    // 审核时间
    private Date approveDatetime;

    // 备注
    private String remark;

    // 父类编号
    private String parentCode;

    // 订单编号
    private String orderCode;

    // 针对实体编号
    private String entityCode;

    // 针对实体名称
    private String entityName;

    // 所属公司
    private String companyCode;

    // 系统编号
    private String systemCode;

    // **********db************

    // 状态List
    private List<String> statusList;

    // 商品名称
    private String productName;

    // 昵称
    private String nickname;

    // 头像
    private String photo;

    // 评论时间戳
    private Long commentDatetimeTime;

    // 审核时间戳
    private Long approveDatetimeTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public Date getCommentDatetime() {
        return commentDatetime;
    }

    public void setCommentDatetime(Date commentDatetime) {
        this.commentDatetime = commentDatetime;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Date getApproveDatetime() {
        return approveDatetime;
    }

    public void setApproveDatetime(Date approveDatetime) {
        this.approveDatetime = approveDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
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

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getCommentDatetimeTime() {
        return commentDatetimeTime;
    }

    public void setCommentDatetimeTime(Long commentDatetimeTime) {
        this.commentDatetimeTime = commentDatetimeTime;
    }

    public Long getApproveDatetimeTime() {
        return approveDatetimeTime;
    }

    public void setApproveDatetimeTime(Long approveDatetimeTime) {
        this.approveDatetimeTime = approveDatetimeTime;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
