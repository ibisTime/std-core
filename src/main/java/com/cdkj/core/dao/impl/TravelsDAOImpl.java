package com.cdkj.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.core.dao.ITravelsDAO;
import com.cdkj.core.dao.base.support.AMybatisTemplate;
import com.cdkj.core.domain.Travels;

@Repository("travelsDAOImpl")
public class TravelsDAOImpl extends AMybatisTemplate implements ITravelsDAO {

    @Override
    public int insert(Travels data) {
        return super.insert(NAMESPACE.concat("insert_travels"), data);
    }

    @Override
    public int delete(Travels data) {
        return super.delete(NAMESPACE.concat("delete_travels"), data);
    }

    @Override
    public int updateTravels(Travels data) {
        return super.update(NAMESPACE.concat("update_travels"), data);
    }

    @Override
    public int updateLocation(Travels data) {
        return super.update(NAMESPACE.concat("update_location"), data);
    }

    @Override
    public int updateStatus(Travels data) {
        return super.update(NAMESPACE.concat("update_status"), data);
    }

    @Override
    public Travels select(Travels condition) {
        return super.select(NAMESPACE.concat("select_travels"), condition,
            Travels.class);
    }

    @Override
    public Long selectTotalCount(Travels condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_travels_count"),
            condition);
    }

    @Override
    public List<Travels> selectList(Travels condition) {
        return super.selectList(NAMESPACE.concat("select_travels"), condition,
            Travels.class);
    }

    @Override
    public List<Travels> selectList(Travels condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_travels"), start,
            count, condition, Travels.class);
    }
}
