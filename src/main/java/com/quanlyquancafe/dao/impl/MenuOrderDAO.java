package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.IMenuOrderDAO;
import com.quanlyquancafe.mapper.MenuOrderMapper;
import com.quanlyquancafe.model.AbstractModel;
import com.quanlyquancafe.model.MenuOrderModel;
import com.quanlyquancafe.model.custom.MenuOrderCategoryCustom;

import java.util.List;


public class MenuOrderDAO extends AbstractDAO<MenuOrderCategoryCustom> implements IMenuOrderDAO {

    @Override
    public List<MenuOrderCategoryCustom> getAllMenu() {
        String sql = "SELECT c.id as idcategory, c.image, s.id,s.tensp,s.gia, c.type FROM sanpham s inner join category c on s.idcategory = c.id where s.status =1 " +
                " order by c.id";
        List<MenuOrderCategoryCustom> menu = query(sql,new MenuOrderMapper());
        return menu;
    }
}
