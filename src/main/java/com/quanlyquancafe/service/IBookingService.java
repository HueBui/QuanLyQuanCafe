package com.quanlyquancafe.service;

import com.quanlyquancafe.model.BookingDetailModel;
import com.quanlyquancafe.model.BookingModel;
import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;

import java.util.Date;
import java.util.List;

public interface IBookingService {
    Long saveBookingDetail(BookingDetailModel bookingDetailModel);

    Long saveBooking(BookingModel bookingModel);

    List<BookingSanPhamBanCustom> listDetailBooking(Long idBan);

    List<BookingModel> getIdBooking(Long idBan);

    List<BookingDetailModel> getBookingDetailByIdBooking(Long idBooking);

    Long updateQuantityBookingDetail(Integer quantity, Long idSanPham, Long idBooking,BookingDetailModel bookingDetailModel);

    boolean thanhToan(Long ids);

    Double tinhTongTienTheoNgay(Integer idUser, String date);

    List<BookingSanPhamBanCustom> getDetailBookingByDate(Integer idUser, Date date);
    
    Double tinhTongTienTheoNgayDenNgay(Integer idUser, String dateFrom, String dateTo);

    boolean updateTotailPrice(Integer idbooking, Double tongTien);
}
