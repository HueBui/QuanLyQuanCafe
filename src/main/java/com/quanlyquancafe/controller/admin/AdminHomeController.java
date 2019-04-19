package com.quanlyquancafe.controller.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-home"})
public class AdminHomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action != null && action.equals("login")) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/admin-login.jsp");
            rd.forward(req, resp);
        }else if(action != null && action.equals("about")){
            String active8="active";
            req.setAttribute("active8",active8);
            String pageTitle="Giới Thiệu";
            req.setAttribute("pageTitle",pageTitle);
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/gioi-thieu.jsp");
            rd.forward(req, resp);
        }
        else if(action != null && action.equals("nottification")){
            String active7="active";
            req.setAttribute("active7",active7);
            String pageTitle="Thông Báo";
            req.setAttribute("pageTitle",pageTitle);
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/thong-bao.jsp");
            rd.forward(req, resp);
        }
        else if(action != null && action.equals("statistical")){
            String active1="active";
            req.setAttribute("active1",active1);
            String pageTitle="Thống Kê";
            req.setAttribute("pageTitle",pageTitle);
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/thong-ke.jsp");
            rd.forward(req, resp);
        }
        else {
            String active1="active";
            req.setAttribute("active1",active1);
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/thong-ke.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
