package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.custom.SanPhamCongThucNguyenLieuCustom;

import java.sql.ResultSet;

public class SanPhamCongThucNguyenLieuMapper implements RowMapper<SanPhamCongThucNguyenLieuCustom> {
    @Override
    public SanPhamCongThucNguyenLieuCustom mapRow(ResultSet resultSet) {
        SanPhamCongThucNguyenLieuCustom model = new SanPhamCongThucNguyenLieuCustom();
        try{
            model.setIdNguyenLieu(resultSet.getLong("idnguyenlieu"));
            model.setIdSanPham(resultSet.getLong("idsanpham"));
            model.setKhoiLuong(resultSet.getDouble("khoiluong"));
            model.setTenNguyenLieu(resultSet.getString("name"));
            model.setTenSanPham(resultSet.getString("tensp"));
        }catch (Exception e){
            System.out.println("Loi mapper class: "+this.getClass() +e);
        }
        return model;
    }
}
