package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.NguyenLieuModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NguyenLieuMapper implements RowMapper<NguyenLieuModel> {
    @Override
    public NguyenLieuModel mapRow(ResultSet resultSet) {
        NguyenLieuModel nguyenLieu = new NguyenLieuModel();
        try {
            nguyenLieu.setId(resultSet.getLong("id"));
            nguyenLieu.setName(resultSet.getString("name"));
            nguyenLieu.setImage(resultSet.getString("image"));
            nguyenLieu.setNgayNhap(resultSet.getTimestamp("ngaynhap"));
            nguyenLieu.setPrice(resultSet.getInt("price"));
            nguyenLieu.setQuantity(resultSet.getInt("quantity"));

        } catch (SQLException e) {
            System.out.println("Loi mapper class: "+this.getClass() +e);
        }
        return nguyenLieu;
    }
}
