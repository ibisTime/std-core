package com.cdkj.core.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.cdkj.core.ao.ITravelsAO;
import com.cdkj.core.bo.IAccountBO;
import com.cdkj.core.bo.ICommentBO;
import com.cdkj.core.bo.IInteractBO;
import com.cdkj.core.bo.ITravelsBO;
import com.cdkj.core.bo.IUserBO;
import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.common.AmountUtil;
import com.cdkj.core.core.OrderNoGenerater;
import com.cdkj.core.domain.Travels;
import com.cdkj.core.domain.User;
import com.cdkj.core.dto.req.XN801050Req;
import com.cdkj.core.dto.req.XN801052Req;
import com.cdkj.core.enums.EBizType;
import com.cdkj.core.enums.EBoolean;
import com.cdkj.core.enums.ECommentStatus;
import com.cdkj.core.enums.ECommentType;
import com.cdkj.core.enums.ECurrency;
import com.cdkj.core.enums.EGeneratePrefix;
import com.cdkj.core.enums.EInteractKind;
import com.cdkj.core.enums.EInteractType;
import com.cdkj.core.enums.ETravelsStatus;
import com.cdkj.core.exception.BizException;

@Service
public class TravelsAOImpl implements ITravelsAO {

    @Autowired
    private ITravelsBO travelsBO;

    @Autowired
    private IInteractBO interactBO;

    @Autowired
    private ICommentBO commentBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public String addTravels(XN801050Req req) {
        Travels data = new Travels();
        String code = OrderNoGenerater.generateME(EGeneratePrefix.Travels
            .getCode());
        data.setCode(code);
        data.setTitle(req.getTitle());
        data.setDescription(req.getDescription());
        data.setPic(req.getPic());
        data.setLocation(EBoolean.NO.getCode());
        data.setCollectionTimes(0);
        data.setLikeTimes(0);
        data.setDsTimes(0);
        data.setStatus(ETravelsStatus.TO_PUBLISH.getCode());
        data.setPublisher(req.getPublisher());
        data.setPublishDatetime(new Date());
        data.setCompanyCode(req.getCompanyCode());
        data.setSystemCode(req.getSystemCode());
        travelsBO.saveTravels(data);
        return code;
    }

    @Override
    public void dropTravels(String code) {
        Travels data = travelsBO.getTravels(code);
        if (!ETravelsStatus.TO_PUBLISH.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "当前游记不是待发布状态,不能操作");
        }
        travelsBO.removeTravels(code);
    }

    @Override
    public void editTravels(XN801052Req req) {
        Travels data = travelsBO.getTravels(req.getCode());
        if (!ETravelsStatus.TO_PUBLISH.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "当前游记不是待发布状态,不能操作");
        }
        data.setCode(req.getCode());
        data.setTitle(req.getTitle());
        data.setDescription(req.getDescription());
        data.setPic(req.getPic());
        data.setPublisher(req.getPublisher());
        data.setPublishDatetime(new Date());
        travelsBO.refreshTravels(data);
    }

    @Override
    public void approveTravels(String code, String approveResult,
            String updater, String remark) {
        Travels data = travelsBO.getTravels(code);
        if (!ETravelsStatus.TO_PUBLISH.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "当前游记不是待发布状态,不能审核");
        }
        ETravelsStatus status = ETravelsStatus.PUBLISH_NO;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            status = ETravelsStatus.PUBLISH_YES;
        }
        travelsBO.approveTravels(code, status, updater, remark);
    }

    @Override
    public Paginable<Travels> queryTravelsPage(int start, int limit,
            Travels condition) {
        Paginable<Travels> page = travelsBO.getPaginable(start, limit,
            condition);
        if (!CollectionUtils.isEmpty(page.getList())) {
            List<Travels> list = page.getList();
            for (Travels data : list) {
                getTravelsDetail(data);
            }
        }
        return page;
    }

    @Override
    public Paginable<Travels> queryFrontTravelsPage(int start, int limit,
            Travels condition) {
        Paginable<Travels> page = travelsBO.getPaginable(start, limit,
            condition);
        if (!CollectionUtils.isEmpty(page.getList())) {
            List<Travels> list = page.getList();
            for (Travels data : list) {
                getTravelsDetail(data);
                data.setIsLike(EBoolean.NO.getCode());
                if (StringUtils.isNotBlank(condition.getUserId())) {
                    boolean likeResult = interactBO.isInteract(
                        condition.getUserId(), EInteractType.TRAVEL,
                        EInteractKind.Dz, data.getCode(),
                        data.getCompanyCode(), data.getSystemCode());
                    if (likeResult) {
                        data.setIsLike(EBoolean.YES.getCode());
                    }
                }
            }
        }
        return page;
    }

    public Paginable<Travels> queryMyTravelsPage(int start, int limit,
            String userId) {
        Travels condition = new Travels();
        condition.setPublisher(userId);
        Paginable<Travels> page = travelsBO.getPaginable(start, limit,
            condition);
        if (!CollectionUtils.isEmpty(page.getList())) {
            List<Travels> list = page.getList();
            for (Travels data : list) {
                getTravelsDetail(data);
                data.setIsLike(EBoolean.NO.getCode());
                if (StringUtils.isNotBlank(condition.getUserId())) {
                    boolean likeResult = interactBO.isInteract(
                        condition.getUserId(), EInteractType.TRAVEL,
                        EInteractKind.Dz, data.getCode(),
                        data.getCompanyCode(), data.getSystemCode());
                    if (likeResult) {
                        data.setIsLike(EBoolean.YES.getCode());
                    }
                }
            }
        }
        return page;
    }

    @Override
    public List<Travels> queryTravelsList(Travels condition) {
        return travelsBO.queryTravelsList(condition);
    }

    private void getTravelsDetail(Travels data) {
        // 发布人
        User publishUser = userBO.getRemoteUser(data.getPublisher());
        data.setPublishUser(publishUser);
        // 获取点赞数，点赞人列表
        int dzCount = interactBO.getTotalCountInteract(EInteractType.TRAVEL,
            EInteractKind.Dz, data.getCode(), data.getCompanyCode(),
            data.getSystemCode());
        data.setLikeTimes(dzCount);
        // 获取打赏数
        int dsCount = interactBO.getTotalCountInteract(EInteractType.TRAVEL,
            EInteractKind.Ds, data.getCode(), data.getCompanyCode(),
            data.getSystemCode());
        data.setDsTimes(dsCount);
        // 获取评论
        int commentCount = commentBO.getTotalCountComment(data.getCode(),
            ECommentStatus.PUBLISHALL, data.getCompanyCode(),
            data.getSystemCode());
        data.setCommentTimes(commentCount);

        // data.setLikeInteractList(likeInteractList);
        // if (!CollectionUtils.isEmpty(likeInteractList)) {
        // for (Interact interact : likeInteractList) {
        // User interactUser = userBO.getRemoteUser(interact
        // .getInteracter());
        // interact.setInteracterName(interactUser.getMobile());
        // interact.setNickname(interactUser.getNickname());
        // interact.setPhoto(interactUser.getPhoto());
        // }
        // }
        // data.setDsInteractList(dsInteractList);
        // if (!CollectionUtils.isEmpty(dsInteractList)) {
        // for (Interact interact : dsInteractList) {
        // User interactUser = userBO.getRemoteUser(interact
        // .getInteracter());
        // interact.setInteracterName(interactUser.getMobile());
        // interact.setNickname(interactUser.getNickname());
        // interact.setPhoto(interactUser.getPhoto());
        // }
        // }
        // if (!CollectionUtils.isEmpty(commentList)) {
        // for (Comment comment : commentList) {
        // commentBO.getRichComment(comment);
        // }
        // }
        // // 排序
        // commentBO.orderCommentList(commentList);
        // data.setCommentList(commentList);
    }

    @Override
    public Travels getTravels(String code, String userId) {
        Travels data = travelsBO.getTravels(code);
        getTravelsDetail(data);
        if (StringUtils.isNotBlank(userId)) {
            boolean likeResult = interactBO.isInteract(userId,
                EInteractType.TRAVEL, EInteractKind.Dz, data.getCode(),
                data.getCompanyCode(), data.getSystemCode());
            if (likeResult) {
                data.setIsLike(EBoolean.YES.getCode());
            }
        }
        return data;
    }

    @Override
    @Transactional
    public void dsTravels(String userId, String travelCode, Long quantity) {
        Travels data = travelsBO.getTravels(travelCode);
        String remark = "赏金" + String.valueOf(AmountUtil.div(quantity, 1000L));
        interactBO.saveInteract(userId, EInteractType.TRAVEL, EInteractKind.Ds,
            travelCode, remark, data.getCompanyCode(), data.getSystemCode());
        accountBO.doTransferAmountRemote(userId, data.getPublisher(),
            ECurrency.JF, quantity, EBizType.TRAVELS_DS,
            EBizType.TRAVELS_DS.getValue(), EBizType.TRAVELS_DS.getValue(),
            travelCode);
    }

    @Override
    public void likeTravels(String userId, String travelCode) {
        Travels data = travelsBO.getTravels(travelCode);
        boolean result = interactBO.isInteract(userId, EInteractType.TRAVEL,
            EInteractKind.Dz, travelCode, data.getCompanyCode(),
            data.getSystemCode());
        if (result) {
            throw new BizException("xn0000", "您已点过赞，不用重复点赞");
        }
        interactBO.saveInteract(userId, EInteractType.TRAVEL, EInteractKind.Dz,
            travelCode, data.getCompanyCode(), data.getSystemCode());
    }

    @Override
    public void commentTravels(String travelCode, String userId,
            String content, String parentCode) {
        Travels data = travelsBO.getTravels(travelCode);
        commentBO.saveComment(userId, ECommentType.TRAVEL, content, parentCode,
            travelCode, data.getCompanyCode(), data.getSystemCode());
    }
}
