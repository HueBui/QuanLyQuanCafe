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

    @Override
    public void delete(long[] ids){
        for (long id : ids) {
            iNguyenLieuDAO.delete(id);
        }
    }

    @Override
    public Long saveInforNguyenLieu(NguyenLieuModel nguyenLieuModel) {
        Long userID=iNguyenLieuDAO.saveInforNguyenLieu(nguyenLieuModel);
        return userID;
    }

    @Override
    public NguyenLieuModel findOne(long id) {
        NguyenLieuModel model=iNguyenLieuDAO.findOne(id);
        return model;
    }
}
