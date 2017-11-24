package com.cdkj.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.core.dao.IPublicityDAO;
import com.cdkj.core.dao.base.support.AMybatisTemplate;
import com.cdkj.core.domain.Publicity;

@Repository("publicityDAOImpl")
public class PublicityDAOImpl extends AMybatisTemplate implements IPublicityDAO {

    @Override
    public int insert(Publicity data) {
        return super.insert(NAMESPACE.concat("insert_publicity"), data);
    }

    @Override
    public int delete(Publicity data) {
        return super.delete(NAMESPACE.concat("delete_publicity"), data);
    }

    @Override
    public Publicity select(Publicity condition) {
        return super.select(NAMESPACE.concat("select_publicity"), condition,
            Publicity.class);
    }

    @Override
    public Long selectTotalCount(Publicity condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_publicity_count"), condition);
    }

    @Override
    public List<Publicity> selectList(Publicity condition) {
        return super.selectList(NAMESPACE.concat("select_publicity"),
            condition, Publicity.class);
    }

    @Override
    public List<Publicity> selectList(Publicity condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_publicity"), start,
            count, condition, Publicity.class);
    }

    @Override
    public int update(Publicity data) {
        return super.update(NAMESPACE.concat("update_publicity"), data);
    }

    @Override
    public int putOn(Publicity data) {
        return super.update(NAMESPACE.concat("update_putOn"), data);
    }

    @Override
    public int putOff(Publicity data) {
        return super.update(NAMESPACE.concat("update_putOff"), data);
    }
}
