package com.quanlyquancafe.dao;

import com.quanlyquancafe.model.CongThucModel;

import java.util.List;

public interface ICongThucDAO {
    List<CongThucModel> getInforCongThucByIdSanPham(Integer idSanPham);
}
