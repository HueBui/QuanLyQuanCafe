package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.custom.ProductCategoryCustom;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryMapper implements RowMapper<ProductCategoryCustom> {
    @Override
    public ProductCategoryCustom mapRow(ResultSet resultSet) {
        ProductCategoryCustom menuModel = new ProductCategoryCustom();
        try {
            menuModel.setId(resultSet.getLong("id"));
            menuModel.setTenSp(resultSet.getString("tensp"));
            menuModel.setGia(resultSet.getDouble("gia"));
            menuModel.setImage(resultSet.getString("image"));
            menuModel.setType(resultSet.getString("type"));
            menuModel.setIdCategory(resultSet.getLong("idcategory"));
        } catch (SQLException e) {
            System.out.println("Loi mapper class: "+this.getClass() +e);
        }

        return menuModel;
    }
}
