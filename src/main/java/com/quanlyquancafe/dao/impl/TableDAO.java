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

    @Override
    public Long saveInforTable(TableModel tableModel) {
        String sql = "INSERT INTO tables (name, type,soluongghe,status,ghichu,image)"+
                " VALUES('"+ tableModel.getName()+"', '"+tableModel.getTypeTable()+"', '"+tableModel.getSoLuongGhe()+"', '"+tableModel.getStatus()+"', '"+tableModel.getGhiChu()+"', '"+tableModel.getImage()+"')";
        return insert(sql);
    }

    @Override
    public boolean update(TableModel tableModel) {
        StringBuilder sql = new StringBuilder("UPDATE tables SET name = ?, type = ?,");
        sql.append(" soluongghe = ?, status = ?, ghichu = ?, image=? WHERE id = ?");

        return update(sql.toString(), tableModel.getName(), tableModel.getTypeTable(), tableModel.getSoLuongGhe(),
                tableModel.getStatus(), tableModel.getGhiChu(),tableModel.getImage(),tableModel.getId());

    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM tables WHERE id = ?";
        delete(id);
    }

    @Override
    public TableModel findOne(Long id) {
       String sql="select * from tables where id=?";
        List<TableModel> tableModels = query(sql, new TableMapper(), id);
        return tableModels.isEmpty() ? null : tableModels.get(0);
    }

    @Override
    public boolean updateTableStatus(Long idTable, Integer status) {
        String sql = "update tables t set t.status='"+status+"' where t.id='"+idTable+"'";
        return  update(sql,idTable);
    }
}
