package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.IMenuOrderDAO;
import com.quanlyquancafe.dao.impl.MenuOrderDAO;
import com.quanlyquancafe.model.MenuOrderModel;
import com.quanlyquancafe.model.custom.MenuOrderCategoryCustom;
import com.quanlyquancafe.service.IMenuOrderService;

import java.util.List;

public class MenuOrderService implements IMenuOrderService {
    private IMenuOrderDAO iMenuDAO;

    public MenuOrderService() {
        iMenuDAO = new MenuOrderDAO();
    }

    @Override
    public List<MenuOrderCategoryCustom> list() {
        return iMenuDAO.getAllMenu();
    }

}
