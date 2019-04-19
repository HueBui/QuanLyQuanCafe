package com.quanlyquancafe.service;

import com.quanlyquancafe.model.BookingModel;
import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;

import java.sql.Timestamp;
import java.util.List;

public interface IBookingService {
    Long save(BookingModel bookingModel);

    List<BookingSanPhamBanCustom> listDetailBooking(Long idBan);
}
