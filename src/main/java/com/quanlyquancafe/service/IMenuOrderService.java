package com.quanlyquancafe.service;

import com.quanlyquancafe.model.MenuOrderModel;
import com.quanlyquancafe.model.custom.MenuOrderCategoryCustom;

import java.util.List;

public interface IMenuOrderService {
    public List<MenuOrderCategoryCustom> list();
}
