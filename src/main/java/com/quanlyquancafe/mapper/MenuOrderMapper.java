package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.MenuOrderModel;
import com.quanlyquancafe.model.custom.MenuOrderCategoryCustom;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuOrderMapper implements RowMapper<MenuOrderCategoryCustom> {
    @Override
    public MenuOrderCategoryCustom mapRow(ResultSet resultSet) {
        MenuOrderCategoryCustom menuModel = new MenuOrderCategoryCustom();
        try {
            menuModel.setId(resultSet.getLong("id"));
            menuModel.setTenSp(resultSet.getString("tensp"));
            menuModel.setGia(resultSet.getDouble("gia"));
            menuModel.setImage(resultSet.getString("image"));
            menuModel.setType(resultSet.getString("type"));
            menuModel.setIdCategory(resultSet.getLong("idcategory"));
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

        return menuModel;
    }
}
