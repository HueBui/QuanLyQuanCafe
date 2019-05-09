package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.ICongThucDAO;
import com.quanlyquancafe.mapper.CongThucMapper;
import com.quanlyquancafe.mapper.SanPhamCongThucNguyenLieuMapper;
import com.quanlyquancafe.model.CongThucModel;
import com.quanlyquancafe.model.custom.SanPhamCongThucNguyenLieuCustom;

import java.util.List;

public class CongThucDAO  extends AbstractDAO<CongThucModel> implements ICongThucDAO {

    @Override
    public List<CongThucModel> getInforCongThucByIdSanPham(Integer idSanPham) {
        String sql = "SELECT  * FROM congthuc c " +
                "inner join sanpham s on s.id=c.idsanpham " +
                "inner join nguyenlieu sn on sn.id=c.idsanpham " +
                "where s.id='"+idSanPham+"'";
        List<CongThucModel> list = query(sql,new CongThucMapper());
        return list;
    }

    @Override
    public List<SanPhamCongThucNguyenLieuCustom> getInforCongThuc() {
        String sql = "select s.id as idsanpham, s.tensp, nl.id as idnguyenlieu,nl.name, ct.khoiluong  from sanpham s inner join congthuc ct on ct.idsanpham = s.id " +
                " inner join nguyenlieu nl on nl.id=ct.idnguyenlieu";
        List<SanPhamCongThucNguyenLieuCustom> list = query(sql,new SanPhamCongThucNguyenLieuMapper());
        return list;
    }


}
