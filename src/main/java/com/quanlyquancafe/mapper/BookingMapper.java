package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.BookingModel;

import java.sql.ResultSet;
import java.sql.Timestamp;

public class BookingMapper implements RowMapper<BookingModel> {


    @Override
    public BookingModel mapRow(ResultSet resultSet) {
        BookingModel model = new BookingModel();
        try{
            model.setId(resultSet.getLong("id"));
            model.setIdUser(resultSet.getInt("iduser"));
            model.setIdSanPham(resultSet.getInt("idsanpham"));
            model.setStatus(resultSet.getInt("status"));
            model.setIdTable(resultSet.getInt("idtable"));
            model.setSoLuong(resultSet.getInt("soluong"));
            model.setDate(resultSet.getTimestamp("date"));

        }catch (Exception e){
            System.out.println("Loi"+e);
        }
        return model;
    }
}
