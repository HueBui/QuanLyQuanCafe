package com.quanlyquancafe.service;

import com.quanlyquancafe.model.CongThucModel;
import com.quanlyquancafe.model.custom.SanPhamCongThucNguyenLieuCustom;
import com.quanlyquancafe.model.custom.SanPhamNguyenLieuCongThucCustom;

import java.util.List;

public interface ICongThucService {
    List<CongThucModel> getInforCongThucByIdSanPham(Integer idSanPham);

    List<SanPhamCongThucNguyenLieuCustom> getInforCongThuc();
}
