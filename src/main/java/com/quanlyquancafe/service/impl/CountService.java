package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.impl.CategoryDAO;
import com.quanlyquancafe.dao.impl.NguyenLieuDAO;
import com.quanlyquancafe.dao.impl.ProductDAO;
import com.quanlyquancafe.dao.impl.TableDAO;
import com.quanlyquancafe.model.custom.CountCustom;

import java.util.List;

public class CountService {
    public Integer countTable() {
        TableDAO dao = new TableDAO();
        List<CountCustom> list = dao.count();
        return list.get(0).getCount();
    }

    public Integer countNguyenLieu() {
        NguyenLieuDAO dao = new NguyenLieuDAO();
        List<CountCustom> list = dao.count();
        return list.get(0).getCount();
    }

    public Integer countCategory() {
        CategoryDAO dao = new CategoryDAO();
        List<CountCustom> list = dao.count();
        return list.get(0).getCount();
    }

    public Integer countProduct() {
        ProductDAO dao = new ProductDAO();
        List<CountCustom> list = dao.count();
        return list.get(0).getCount();
    }
}
