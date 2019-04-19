package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.custom.SanPhamNguyenLieuCongThucCustom;

import java.sql.ResultSet;

public class SanPhamNguyenLieuKhoiLuongMapper implements RowMapper<SanPhamNguyenLieuCongThucCustom> {
    @Override
    public SanPhamNguyenLieuCongThucCustom mapRow(ResultSet resultSet) {
        SanPhamNguyenLieuCongThucCustom model = new SanPhamNguyenLieuCongThucCustom();
        try{
            model.setKhoiLuongCongThuc(resultSet.getDouble("khoiluong"));
            model.setKhoiLuongNguyenLieu(resultSet.getDouble("quantity"));
        }catch (Exception e){
            System.out.println("Loi"+e);
        }
        return model;
    }
}
