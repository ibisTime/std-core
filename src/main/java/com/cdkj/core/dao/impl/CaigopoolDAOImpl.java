package com.cdkj.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.core.dao.ICaigopoolDAO;
import com.cdkj.core.dao.base.support.AMybatisTemplate;
import com.cdkj.core.domain.Caigopool;

@Repository("caigopoolDAOImpl")
public class CaigopoolDAOImpl extends AMybatisTemplate implements ICaigopoolDAO {

    @Override
    public int insert(Caigopool data) {
        return super.insert(NAMESPACE.concat("insert_caigopool"), data);
    }

    @Override
    public int delete(Caigopool data) {
        return super.delete(NAMESPACE.concat("delete_caigopool"), data);
    }

    @Override
    public Caigopool select(Caigopool condition) {
        return super.select(NAMESPACE.concat("select_caigopool"), condition,
            Caigopool.class);
    }

    @Override
    public Long selectTotalCount(Caigopool condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_caigopool_count"), condition);
    }

    @Override
    public List<Caigopool> selectList(Caigopool condition) {
        return super.selectList(NAMESPACE.concat("select_caigopool"),
            condition, Caigopool.class);
    }

    @Override
    public List<Caigopool> selectList(Caigopool condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_caigopool"), start,
            count, condition, Caigopool.class);
    }

    @Override
    public int addAmount(Caigopool data) {
        return super.update(NAMESPACE.concat("update_addAmount"), data);
    }

    @Override
    public int outAmount(Caigopool data) {
        return super.update(NAMESPACE.concat("update_outAmount"), data);
    }

}
