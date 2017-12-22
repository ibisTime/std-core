package com.cdkj.core.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.core.bo.IAccountBO;
import com.cdkj.core.bo.ICommentBO;
import com.cdkj.core.bo.IKeywordBO;
import com.cdkj.core.bo.ISYSConfigBO;
import com.cdkj.core.bo.IUserBO;
import com.cdkj.core.bo.base.PaginableBOImpl;
import com.cdkj.core.common.AmountUtil;
import com.cdkj.core.common.DateUtil;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.dao.ICommentDAO;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.domain.User;
import com.cdkj.core.enums.EBizType;
import com.cdkj.core.enums.ECommentStatus;
import com.cdkj.core.enums.ECommentType;
import com.cdkj.core.enums.ECurrency;
import com.cdkj.core.enums.EPrefixCode;
import com.cdkj.core.enums.EReaction;
import com.cdkj.core.enums.EUserKind;
import com.cdkj.core.exception.BizException;

@Component
public class CommentBOImpl extends PaginableBOImpl<Comment> implements
        ICommentBO {

    @Autowired
    private ICommentDAO commentDAO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IKeywordBO keywordBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Override
    public void saveComment(Comment data) {
        commentDAO.insert(data);
    }

    @Override
    public void saveComment(String userId, ECommentType type, String content,
            String parentCommentCode, String entityCode, String companyCode,
            String systemCode) {
        User user = userBO.getRemoteUser(userId);
        // 判断是否含有关键字
        EReaction result = keywordBO.checkContent(content);
        String code = OrderNoGenerater
            .generateME(EPrefixCode.COMMENT.getCode());
        // 活动回帖：用户在审核通过的活动中回帖，每次回帖可获得20积分。每日前五次可获得奖励
        addJfUser(user, type, code, companyCode, systemCode);
        Comment data = new Comment();
        data.setCode(code);
        data.setType(type.getCode());
        data.setContent(content);

        String status = ECommentStatus.PUBLISHED.getCode();
        if (EReaction.REFUSE.getCode().equals(result.getCode())) {
            status = ECommentStatus.FILTERED.getCode();
            code = code + "||" + parentCommentCode + "||" + "||filter";
        }
        data.setStatus(status);

        data.setCommenter(user.getUserId());
        String commenterName = user.getMobile();
        if (StringUtils.isBlank(commenterName)) {
            commenterName = user.getNickname();
        }
        data.setCommenterName(commenterName);
        data.setCommentDatetime(new Date());
        data.setParentCode(parentCommentCode);
        data.setEntityCode(entityCode);

        data.setCompanyCode(companyCode);
        data.setSystemCode(systemCode);
        commentDAO.insert(data);
    }

    private void addJfUser(User user, ECommentType type, String commentCode,
            String companyCode, String systemCode) {
        if (!EUserKind.OUT_LEADER.getCode().equals(user.getKind())) {
            return;
        }
        Comment condition = new Comment();
        condition.setCommentDatetimeStart(DateUtil.getTodayStart());
        condition.setCommentDatetimeEnd(DateUtil.getTodayEnd());
        condition.setCommenter(user.getUserId());
        Long count = commentDAO.selectTotalCount(condition);
        if (count < 5) {
            EBizType bizType = EBizType.HD_FK;
            String cvalue = sysConfigBO.getConfigValueRemote("ACT_HT_JF",
                companyCode, systemCode);
            Long jfAmount = AmountUtil.mul(1000L, Double.valueOf(cvalue));
            accountBO.doTransferAmountRemote("SYS_USER_HW", user.getUserId(),
                ECurrency.JF, jfAmount, bizType, bizType.getValue(),
                bizType.getValue(), commentCode);
        }
    }

    @Override
    public void removeComment(Comment data) {
        if (null != data) {
            commentDAO.delete(data);
        }
    }

    @Override
    public void approveComment(Comment data, String status, String approver,
            String remark) {
        data.setStatus(status);
        data.setApprover(approver);
        data.setApproveDatetime(new Date());
        data.setRemark(remark);
        commentDAO.approveComment(data);
    }

    @Override
    public List<Comment> queryCommentList(Comment condition) {
        return commentDAO.selectList(condition);
    }

    @Override
    public List<Comment> queryCommentList(String entityCode,
            ECommentStatus status, String companyCode, String systemCode) {
        Comment condition = new Comment();
        condition.setEntityCode(entityCode);
        condition.setStatus(ECommentStatus.PUBLISHALL.getCode());
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        return commentDAO.selectList(condition);
    }

    @Override
    public int getTotalCountComment(String entityCode, ECommentStatus status,
            String companyCode, String systemCode) {
        Comment condition = new Comment();
        condition.setEntityCode(entityCode);
        condition.setStatus(ECommentStatus.PUBLISHALL.getCode());
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        return commentDAO.selectTotalCount(condition).intValue();
    }

    @Override
    public Comment getComment(String code) {
        Comment data = null;
        if (StringUtils.isNotBlank(code)) {
            Comment condition = new Comment();
            condition.setCode(code);
            data = commentDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "评论不存在");
            }
        }
        return data;
    }

    private Comment getChildComment(String code) {
        Comment data = null;
        if (StringUtils.isNotBlank(code)) {
            Comment condition = new Comment();
            condition.setParentCode(code);
            List<Comment> list = commentDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                data = list.get(0);
            }
        }
        return data;
    }

    @Override
    public Long queryTotalScore(Comment condition) {
        return commentDAO.selectTotalScore(condition);
    }

    @Override
    public Comment getRichComment(Comment comment) {
        User commentUser = userBO.getRemoteUser(comment.getCommenter());
        comment.setCommenterName(commentUser.getMobile());
        comment.setNickname(commentUser.getNickname());
        comment.setPhoto(commentUser.getPhoto());
        if (!comment.getParentCode().equals(comment.getEntityCode())) {
            Comment parentComment = getComment(comment.getParentCode());
            User parentUser = userBO
                .getRemoteUser(parentComment.getCommenter());
            parentComment.setCommenterName(parentUser.getMobile());
            parentComment.setNickname(parentUser.getNickname());
            parentComment.setPhoto(parentUser.getPhoto());
            comment.setParentComment(parentComment);
        }
        return comment;
    }

    @Override
    public Comment getNextComment(Comment comment) {
        User commentUser = userBO.getRemoteUser(comment.getCommenter());
        comment.setCommenterName(commentUser.getMobile());
        comment.setNickname(commentUser.getNickname());
        comment.setPhoto(commentUser.getPhoto());
        Comment childComment = getChildComment(comment.getCode());
        if (null != childComment) {
            User parentUser = userBO.getRemoteUser(childComment.getCommenter());
            childComment.setCommenterName(parentUser.getMobile());
            childComment.setNickname(parentUser.getNickname());
            childComment.setPhoto(parentUser.getPhoto());
            comment.setChildComment(childComment);
        }
        return comment;
    }
}
