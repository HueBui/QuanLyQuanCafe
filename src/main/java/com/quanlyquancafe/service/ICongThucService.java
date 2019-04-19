package com.quanlyquancafe.service;

import com.quanlyquancafe.model.CongThucModel;

import java.util.List;

public interface ICongThucService {
    List<CongThucModel> getInforCongThucByIdSanPham(Integer idSanPham);
}
