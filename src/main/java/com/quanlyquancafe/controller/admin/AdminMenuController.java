package com.quanlyquancafe.controller.admin;

import com.quanlyquancafe.model.MenuOrderModel;
import com.quanlyquancafe.model.custom.MenuOrderCategoryCustom;
import com.quanlyquancafe.service.impl.MenuOrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-list-menu","/admin-edit-menu"})
public class AdminMenuController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MenuOrderService menuService = new MenuOrderService();
        String action=request.getParameter("action");
        if(action!=null&& action.equals("list")){
            String active4="active";

            List<MenuOrderCategoryCustom> menuModel= menuService.list();

            request.setAttribute("menuModel",menuModel);
            request.setAttribute("active4",active4);
            RequestDispatcher rd=request.getRequestDispatcher("/views/admin/menu/menu-list.jsp");
            rd.forward(request,response);
        }else if(action!=null && action.equals("edit")){
            String active6="active";
            request.setAttribute("active6",active6);
            RequestDispatcher rd=request.getRequestDispatcher("/views/admin/menu/menu-edit.jsp");
            rd.forward(request,response);
        }else {
        }
    }
}
