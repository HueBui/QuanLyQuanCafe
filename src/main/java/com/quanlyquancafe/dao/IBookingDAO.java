package com.quanlyquancafe.dao;

import com.quanlyquancafe.model.BookingDetailModel;
import com.quanlyquancafe.model.BookingModel;

import java.util.List;

public interface IBookingDAO {
    Long saveBookingDetail(BookingDetailModel bookingModel);

    Long saveBooking(BookingModel bookingModel);

    List<BookingModel> checkStatusBooking(Long idBan);

    List<BookingDetailModel> getBookingDetailByIdBooking(Long idBooking);

    boolean updateQuantityBookingDetail(Integer quantity, Long idSanPham, Long idBooking);

    boolean thanhToan(Long idBooking);

    List<BookingModel> tinhTongTienTheoNgay(Integer idUser, String date);

    List<BookingModel> tinhTongTienTuNgayDenNgay(Integer idUser, String dateFrom, String dateTo);

    boolean updateTotalPrice(Integer idBooking, Double totalPrice);
}
