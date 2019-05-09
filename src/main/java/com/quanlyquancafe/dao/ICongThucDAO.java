package com.quanlyquancafe.dao;

import com.quanlyquancafe.model.CongThucModel;
import com.quanlyquancafe.model.custom.SanPhamCongThucNguyenLieuCustom;

import java.util.List;

public interface ICongThucDAO {
    List<CongThucModel> getInforCongThucByIdSanPham(Integer idSanPham);

    List<SanPhamCongThucNguyenLieuCustom> getInforCongThuc();
}
