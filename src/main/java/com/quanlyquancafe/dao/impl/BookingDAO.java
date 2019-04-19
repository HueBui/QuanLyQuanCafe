package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.IBookingDAO;
import com.quanlyquancafe.model.BookingModel;

public class BookingDAO extends AbstractDAO<BookingModel> implements IBookingDAO {
    @Override
    public Long save(BookingModel bookingModel) {
        String sql = "INSERT INTO booking (iduser,idban, idsanpham, soluong, date, status) VALUES(?, ?, ?, ?, ?,?)";
        return insert(sql, bookingModel.getIdUser(),
                bookingModel.getIdTable(),bookingModel.getIdSanPham(),bookingModel.getSoLuong(),bookingModel.getDate(),bookingModel.getStatus());
    }
}
