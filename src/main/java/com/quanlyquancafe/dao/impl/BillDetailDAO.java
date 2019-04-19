package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.IBillDetailDAO;
import com.quanlyquancafe.mapper.BookingSanPhamBanMapper;
import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BillDetailDAO extends AbstractDAO<BookingSanPhamBanCustom> implements IBillDetailDAO {
    @Override
    public List<BookingSanPhamBanCustom> detailBill(Long idBan) {
        String sql = "select b.id,t.name , s.tensp,b.soluong, s.gia" +
                " from booking b inner join sanpham s on b.idsanpham=s.id" +
                " inner join tables t on t.id = b.idban" +
                " where b.idban='"+idBan+"' and b.status = 0";
        List<BookingSanPhamBanCustom> list =  query(sql,new BookingSanPhamBanMapper());

        return list;
    }
}
