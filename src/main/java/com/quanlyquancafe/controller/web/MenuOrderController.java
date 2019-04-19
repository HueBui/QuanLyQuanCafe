package com.quanlyquancafe.controller.web;

import com.quanlyquancafe.model.CategoryModel;
import com.quanlyquancafe.model.MenuOrderModel;
import com.quanlyquancafe.model.custom.MenuOrderCategoryCustom;
import com.quanlyquancafe.service.impl.CategoryService;
import com.quanlyquancafe.service.impl.MenuOrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns ={"/menu-order"})
public class MenuOrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idTable = request.getParameter("idTable");
        request.setAttribute("idTable",idTable);
        MenuOrderService menuOrderService = new MenuOrderService();
        CategoryService categoryService = new CategoryService();
        List<MenuOrderCategoryCustom> menuOrderModels = menuOrderService.list();
        List<CategoryModel> categoryModels = categoryService.getAll();
        request.setAttribute("menuOrderModels", menuOrderModels);
        request.setAttribute("categoryModels", categoryModels);
        RequestDispatcher rd=request.getRequestDispatcher("/views/web/menu-order.jsp");
        rd.forward(request,response);
    }
}
