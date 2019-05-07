package com.quanlyquancafe.dao;

import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface IBillDetailDAO {
    List<BookingSanPhamBanCustom> detailBill(Long idBan);

    List<BookingSanPhamBanCustom> listDetailBillByDate(Integer idUser, Date date);
}
