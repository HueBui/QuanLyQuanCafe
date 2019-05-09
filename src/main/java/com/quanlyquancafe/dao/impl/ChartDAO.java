package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.mapper.DateCustomMapper;
import com.quanlyquancafe.model.custom.DateCustom;

import java.util.List;

public class ChartDAO extends AbstractDAO<DateCustom> {
    public List<DateCustom> getAllDateBill(){
        String sql = "SELECT distinct date(b.create_time) as date_time FROM booking b";
        List<DateCustom> dateCustoms = query(sql,new DateCustomMapper());
        return dateCustoms;
    }
}
