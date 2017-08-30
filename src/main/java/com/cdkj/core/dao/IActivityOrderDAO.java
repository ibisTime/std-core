package com.cdkj.core.dao;

import com.cdkj.core.dao.base.IBaseDAO;
import com.cdkj.core.domain.ActivityOrder;

/**
 * 
 * @author: shan 
 * @since: 2016年12月9日 下午9:40:38 
 * @history:
 */
public interface IActivityOrderDAO extends IBaseDAO<ActivityOrder> {
    String NAMESPACE = IActivityOrderDAO.class.getName().concat(".");

    public int update(ActivityOrder data);

    public int payGroup(ActivityOrder order);

    public int updateOrderPay(ActivityOrder data);

    public int finishOrder(ActivityOrder data);

    public ActivityOrder selectGroup(ActivityOrder data);

    public int cancelOrder(ActivityOrder order);

    public int applyRefund(ActivityOrder order);

}
