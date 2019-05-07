package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.ProductModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper {
    @Override
    public ProductModel mapRow(ResultSet resultSet) {
        ProductModel maper = new ProductModel();
        try {
            maper.setId(resultSet.getLong("id"));
            maper.setImage(resultSet.getString("image"));
            maper.setIdCategory(resultSet.getLong("idcategory"));
            maper.setPrice(resultSet.getInt("gia"));
            maper.setName(resultSet.getString("tensp"));
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return maper;
    }
}
