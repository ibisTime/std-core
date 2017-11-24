package com.cdkj.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.core.dao.ICurrencyActivityDAO;
import com.cdkj.core.dao.base.support.AMybatisTemplate;
import com.cdkj.core.domain.CurrencyActivity;

@Repository("currencyActivityDAOImpl")
public class CurrencyActivityDAOImpl extends AMybatisTemplate implements
        ICurrencyActivityDAO {

    @Override
    public int insert(CurrencyActivity data) {
        return super.insert(NAMESPACE.concat("insert_currencyActivity"), data);
    }

    @Override
    public int delete(CurrencyActivity data) {
        return super.delete(NAMESPACE.concat("delete_currencyActivity"), data);
    }

    @Override
    public CurrencyActivity select(CurrencyActivity condition) {
        return super.select(NAMESPACE.concat("select_currencyActivity"),
            condition, CurrencyActivity.class);
    }

    @Override
    public Long selectTotalCount(CurrencyActivity condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_currencyActivity_count"), condition);
    }

    @Override
    public List<CurrencyActivity> selectList(CurrencyActivity condition) {
        return super.selectList(NAMESPACE.concat("select_currencyActivity"),
            condition, CurrencyActivity.class);
    }

    @Override
    public List<CurrencyActivity> selectList(CurrencyActivity condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_currencyActivity"),
            start, count, condition, CurrencyActivity.class);
    }

    @Override
    public int update(CurrencyActivity data) {
        return super.update(NAMESPACE.concat("update_currencyActivity"), data);
    }

    @Override
    public int putOn(CurrencyActivity data) {
        return super.update(NAMESPACE.concat("update_putOn"), data);
    }

    @Override
    public int putOff(CurrencyActivity data) {
        return super.update(NAMESPACE.concat("update_putOff"), data);
    }

}
