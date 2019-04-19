package com.quanlyquancafe.controller.admin;

import com.quanlyquancafe.mapper.NguyenLieuMapper;
import com.quanlyquancafe.model.NguyenLieuModel;
import com.quanlyquancafe.service.impl.NguyenLieuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-list-nguyen-lieu","/admin-edit-nguyen-lieu"})
public class AdminNguyenLieuController extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        NguyenLieuService nguyenLieuService = new NguyenLieuService();
        if(action!=null&& action.equals("list")){
            String active3="active";
            request.setAttribute("active3",active3);
            List<NguyenLieuModel> nguyenLieuModels;
            nguyenLieuModels = nguyenLieuService.listAll();
            request.setAttribute("nguyenLieuModels",nguyenLieuModels);
            RequestDispatcher rd=request.getRequestDispatcher("/views/admin/product/product-list.jsp");
            rd.forward(request,response);
        }else if(action!=null && action.equals("edit")){
            String active5="active";
            request.setAttribute("active5",active5);
            RequestDispatcher rd=request.getRequestDispatcher("/views/admin/product/product-list.jsp");
            rd.forward(request,response);
        }else {

        }

    }
}
