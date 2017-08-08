package com.std.activity.dao;

import com.std.activity.dao.base.IBaseDAO;
import com.std.activity.domain.Activity;

/**
 * 
 * @author: shan 
 * @since: 2016年12月9日 下午9:36:16 
 * @history:
 */
public interface IActivityDAO extends IBaseDAO<Activity> {
    String NAMESPACE = IActivityDAO.class.getName().concat(".");

    public int update(Activity data);

    public int putOn(Activity data);

    public int downActivity(Activity data);

    public int auto(Activity data);

    public int addSignNum(Activity data);
}
