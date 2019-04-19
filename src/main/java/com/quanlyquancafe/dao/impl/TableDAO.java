package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.ITableDAO;
import com.quanlyquancafe.mapper.BookingTableMapper;
import com.quanlyquancafe.mapper.TableMapper;
import com.quanlyquancafe.model.TableModel;
import com.quanlyquancafe.model.custom.BookingTableCustom;

import java.util.List;

public class TableDAO extends AbstractDAO<TableModel> implements ITableDAO {
    @Override
    public List<TableModel> getAll() {
        String sql = "SELECT * FROM tables t";
        List<TableModel> list = query(sql,new TableMapper());
        return list;
    }

    @Override
    public List<BookingTableCustom> getTable() {
        String sql = "select distinct t.name,t.id from booking b inner join tables t on t.id=b.idban where b.status=0";
        List<BookingTableCustom> list = query(sql,new BookingTableMapper());
        return list;
    }
}
