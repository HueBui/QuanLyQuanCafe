package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.BookingDetailModel;

import java.sql.ResultSet;

public class BookingDetailMapper implements RowMapper<BookingDetailModel> {


    @Override
    public BookingDetailModel mapRow(ResultSet resultSet) {
        BookingDetailModel model = new BookingDetailModel();
        try{
            model.setIdSanPham(resultSet.getLong("idsanpham"));
            model.setIdBooking(resultSet.getLong("idbooking"));
            model.setIdTable(resultSet.getLong("idtable"));
            model.setSoLuong(resultSet.getInt("quantity"));
            model.setCreateTime(resultSet.getTimestamp("create_time"));
            model.setCreateBy(resultSet.getLong("create_by"));
            model.setGia(resultSet.getInt("price"));

        }catch (Exception e){
            System.out.println("Loi"+e);
        }
        return model;
    }
}
