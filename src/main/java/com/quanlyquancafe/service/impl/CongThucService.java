package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.impl.CongThucDAO;
import com.quanlyquancafe.model.CongThucModel;
import com.quanlyquancafe.model.custom.SanPhamCongThucNguyenLieuCustom;
import com.quanlyquancafe.model.custom.SanPhamNguyenLieuCongThucCustom;
import com.quanlyquancafe.service.ICongThucService;

import java.util.List;

public class CongThucService implements ICongThucService {
    @Override
    public List<CongThucModel> getInforCongThucByIdSanPham(Integer idSanPham) {
        CongThucDAO dao = new CongThucDAO();
        return dao.getInforCongThucByIdSanPham(idSanPham);
    }

    @Override
    public List<SanPhamCongThucNguyenLieuCustom> getInforCongThuc() {
        CongThucDAO dao = new CongThucDAO();
        return dao.getInforCongThuc();
    }
}
