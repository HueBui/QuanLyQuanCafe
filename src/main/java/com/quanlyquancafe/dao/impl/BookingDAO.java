package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.IBookingDAO;
import com.quanlyquancafe.mapper.BookingDetailMapper;
import com.quanlyquancafe.mapper.BookingMapper;
import com.quanlyquancafe.model.BookingDetailModel;
import com.quanlyquancafe.model.BookingModel;

import java.util.List;

public class BookingDAO extends AbstractDAO<BookingDetailModel> implements IBookingDAO {
    @Override
    public Long saveBookingDetail(BookingDetailModel bookingModel) {
        String sql = "INSERT INTO booking_detail (idbooking, idsanpham, idban, quantity, price, create_by, create_time) VALUES(?, ?, ?, ?, ?,?,?)";
        return insert(sql, bookingModel.getIdBooking(),
                bookingModel.getIdSanPham(), bookingModel.getIdTable(), bookingModel.getSoLuong(), bookingModel.getGia(), bookingModel.getCreateBy(), bookingModel.getCreateTime());
    }

    @Override
    public Long saveBooking(BookingModel bookingModel) {
        String sql = "INSERT INTO booking (total,status, create_time, create_by) VALUES(?, ?, ?, ?)";
        return insert(sql, bookingModel.getTotalPrice(),
                bookingModel.getStatus(), bookingModel.getCreateTime(), bookingModel.getCreateBy());
    }

    @Override
    public List<BookingModel> checkStatusBooking(Long idBan) {
        String sql = "select b.id from booking b" +
                " inner join booking_detail bd on b.id = bd.idbooking " +
                " inner join tables t on bd.idban = t.id" +
                " where b.status=1 and t.id='" + idBan + "'";
        return query(sql, new BookingMapper());
    }

    @Override
    public List<BookingDetailModel> getBookingDetailByIdBooking(Long idBooking) {
        String sql = "select *from booking b " +
                "inner join booking_detail bd on b.id = bd.idbooking " +
                "where  b.id='" + idBooking + "'";
        return query(sql, new BookingDetailMapper());
    }

    @Override
    public boolean updateQuantityBookingDetail(Integer quantity, Long idSanPham, Long idBooking) {
        String sql = "update booking_detail db set db.quantity = db.quantity + '" + quantity + "' where db.idbooking ='" + idBooking + "' and db.idsanpham='" + idSanPham + "'";
        return update(sql, new BookingDetailMapper());
    }

    @Override
    public boolean thanhToan(Long idBooking) {
        String sql = "update booking b set b.status=0 where b.id='" + idBooking + "'";
        return update(sql, idBooking);
    }

    @Override
    public List<BookingModel> tinhTongTienTheoNgay(Integer idUser, String date) {
        String sql = "SELECT * FROM quanlyquancafe.booking where date(create_time) = '" + date + "' and status=1 and create_by = '" + idUser + "'";
        return query(sql, new BookingMapper());
    }

    @Override
    public List<BookingModel> tinhTongTienTuNgayDenNgay(Integer idUser, String dateFrom, String dateTo) {
        String sql = "SELECT * FROM booking b where date(b.create_time) >= '" + dateFrom + "' AND  date(b.create_time) <= '" + dateTo + "'";
        return query(sql,new BookingMapper());
    }

    @Override
    public boolean updateTotalPrice(Integer idBooking, Double totalPrice) {
        String sql = "update booking b set b.total='"+totalPrice+"' where b.id='"+idBooking+"'";
        return update(sql);
    }

}
