package com.cdkj.core.ao;

import java.util.List;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.Travels;
import com.cdkj.core.dto.req.XN801050Req;
import com.cdkj.core.dto.req.XN801052Req;

public interface ITravelsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 新增游记
    public String addTravels(XN801050Req req);

    // 删除游记
    public void dropTravels(String code);

    // 修改游记
    public void editTravels(XN801052Req req);

    // 审批游记
    public void approveTravels(String code, String approveResult,
            String updater, String remark);

    // 打赏
    public void dsTravels(String userId, String travelCode, Long quantity);

    // 点赞
    public void likeTravels(String userId, String travelCode);

    // 评论
    public void commentTravels(String travelCode, String userId,
            String content, String parentCode);

    public Paginable<Travels> queryTravelsPage(int start, int limit,
            Travels condition);

    public Paginable<Travels> queryFrontTravelsPage(int start, int limit,
            Travels condition);

    public Paginable<Travels> queryMyTravelsPage(int start, int limit,
            String userId);

    public List<Travels> queryTravelsList(Travels condition);

    public Travels getTravels(String code, String userId);
}
