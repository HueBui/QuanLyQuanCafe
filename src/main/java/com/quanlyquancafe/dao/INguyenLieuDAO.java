package com.quanlyquancafe.dao;

import com.quanlyquancafe.model.CategoryModel;
import com.quanlyquancafe.model.NguyenLieuModel;
import com.quanlyquancafe.model.custom.SanPhamNguyenLieuCongThucCustom;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface INguyenLieuDAO {
    List<NguyenLieuModel> listAll();
    boolean update(NguyenLieuModel nguyenLieuModel);
    boolean updateQuantity(Double quantity, Long id);

    List<SanPhamNguyenLieuCongThucCustom> listKhoiLuong(Integer idSanPham);
}
