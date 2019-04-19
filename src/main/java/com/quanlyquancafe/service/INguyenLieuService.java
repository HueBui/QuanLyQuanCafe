package com.quanlyquancafe.service;

import com.quanlyquancafe.model.NguyenLieuModel;

import java.util.List;

public interface INguyenLieuService {
    List<NguyenLieuModel> listAll();
    boolean update(NguyenLieuModel nguyenLieuModel);

    void delete(long[] ids);

    Long saveInforNguyenLieu(NguyenLieuModel nguyenLieuModel);

    NguyenLieuModel findOne(long id);
}
