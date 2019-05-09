package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.RoleModel;
import com.quanlyquancafe.model.TableModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TableMapper implements RowMapper<TableModel> {
    @Override
    public TableModel mapRow(ResultSet resultSet) {
        TableModel table = new TableModel();
        try {
            table.setId(resultSet.getLong("id"));
            table.setName(resultSet.getString("name"));
            table.setGhiChu(resultSet.getString("ghichu"));
            table.setTypeTable(resultSet.getLong("type"));
            table.setStatus(resultSet.getLong("status"));
            table.setSoLuongGhe(resultSet.getLong("soluongghe"));
            table.setImage(resultSet.getString("image"));

        } catch (SQLException e) {
            System.out.println("Loi mapper class: "+this.getClass() +e);
        }
        return table;
    }
}
