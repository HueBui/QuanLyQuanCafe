package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.IBillDetailDAO;
import com.quanlyquancafe.mapper.BookingSanPhamBanMapper;
import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDetailDAO extends AbstractDAO<BookingSanPhamBanCustom> implements IBillDetailDAO {
    @Override
    public List<BookingSanPhamBanCustom> detailBill(Long idBan) {
        String sql = "select b.id,t.name , s.tensp,bd.quantity, s.gia" +
                " from booking b inner join booking_detail bd on b.id = bd.idbooking inner join sanpham s on bd.idsanpham=s.id" +
                " inner join tables t on t.id = bd.idban" +
                "  where bd.idban='"+idBan+"' and b.status = 1";
        List<BookingSanPhamBanCustom> list =  query(sql,new BookingSanPhamBanMapper());

        return list;
    }

    @Override
    public List<BookingSanPhamBanCustom> listDetailBillByDate(Integer idUser, Date date) {
        String sql = "select b.id,t.name , s.tensp,bd.quantity, s.gia" +
                " from booking b inner join booking_detail bd on b.id = bd.idbooking inner join sanpham s on bd.idsanpham=s.id" +
                " inner join tables t on t.id = bd.idban" +
                " where date(b.create_time) = '"+date+"' and b.status = 1 and b.create_by='"+idUser+"'" +
                " order by b.id desc";
        List<BookingSanPhamBanCustom> list =  query(sql,new BookingSanPhamBanMapper());
        return list;
    }
}
