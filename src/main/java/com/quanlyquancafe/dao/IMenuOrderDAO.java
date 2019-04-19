package com.quanlyquancafe.dao;

import com.quanlyquancafe.model.MenuOrderModel;
import com.quanlyquancafe.model.custom.MenuOrderCategoryCustom;

import java.util.List;

public interface IMenuOrderDAO {
    List<MenuOrderCategoryCustom> getAllMenu();
}
