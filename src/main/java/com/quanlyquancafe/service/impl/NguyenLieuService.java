package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.INguyenLieuDAO;
import com.quanlyquancafe.dao.impl.NguyenLieuDAO;
import com.quanlyquancafe.model.NguyenLieuModel;
import com.quanlyquancafe.service.INguyenLieuService;

import java.util.List;

public class NguyenLieuService implements INguyenLieuService {
    private INguyenLieuDAO iNguyenLieuDAO;

    public NguyenLieuService() {
       iNguyenLieuDAO = new NguyenLieuDAO();
    }

    @Override
    public List<NguyenLieuModel> listAll() {
        return iNguyenLieuDAO.listAll();
    }

    @Override
    public boolean update(NguyenLieuModel nguyenLieuModel) {
        return iNguyenLieuDAO.update(nguyenLieuModel);
    }
}
