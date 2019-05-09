package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.CongThucModel;

import java.sql.ResultSet;

public class CongThucMapper implements RowMapper<CongThucModel> {
    @Override
    public CongThucModel mapRow(ResultSet resultSet) {
        CongThucModel congThucModel = new CongThucModel();
        try {
            congThucModel.setIdNguyenLieu(resultSet.getLong("idnguyenlieu"));
            congThucModel.setIdSanPham(resultSet.getLong("idsanpham"));
            congThucModel.setKhoiLuong(resultSet.getDouble("khoiluong"));
        }catch (Exception e){
            System.out.println("Loi mapper class: "+this.getClass() +e);
        }
        return congThucModel;
    }
}
