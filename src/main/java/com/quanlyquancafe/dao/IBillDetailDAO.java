package com.quanlyquancafe.dao;

import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;

import java.sql.Timestamp;
import java.util.List;

public interface IBillDetailDAO {
    List<BookingSanPhamBanCustom> detailBill(Long idBan);
}
