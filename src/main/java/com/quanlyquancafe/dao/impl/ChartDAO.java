package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.mapper.CountMapper;
import com.quanlyquancafe.mapper.DateCustomMapper;
import com.quanlyquancafe.model.custom.CountCustom;
import com.quanlyquancafe.model.custom.DateCustom;

import java.util.List;

public class ChartDAO extends AbstractDAO<DateCustom> {
    public List<DateCustom> getAllDateBill(){
        String sql = "SELECT distinct date(b.create_time) as date_time FROM booking b";
        List<DateCustom> dateCustoms = query(sql,new DateCustomMapper());
        return dateCustoms;
    }

    public List<CountCustom> getTotal(){
        String sql = "select sum(b.total) as count from booking b where b.status=0 group by date(b.create_time)";
        List<CountCustom> dateCustoms = query(sql,new CountMapper());
        return dateCustoms;
    }

    public List<CountCustom> getTotalNguyenLieu(){
        String sql = "select sum(b.price) as total_price from nguyenlieu b group by date(b.ngaynhap) order by date(b.ngaynhap) asc";
        List<CountCustom> dateCustoms = query(sql,new CountMapper());
        return dateCustoms;
    }
}
