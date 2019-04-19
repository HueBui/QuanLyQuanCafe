package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingSanPhamBanMapper implements RowMapper<BookingSanPhamBanCustom> {
    @Override
    public BookingSanPhamBanCustom mapRow(ResultSet resultSet) {
        BookingSanPhamBanCustom maper = new BookingSanPhamBanCustom();
        try {
            maper.setId(resultSet.getLong("id"));
            maper.setSoLuong(resultSet.getInt("soluong"));
            maper.setTenBan(resultSet.getString("name"));
            maper.setTenSp(resultSet.getString("tensp"));
            maper.setGia(resultSet.getDouble("gia"));
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return maper;
    }
}
