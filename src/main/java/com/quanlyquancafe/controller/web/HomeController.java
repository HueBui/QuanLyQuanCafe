package com.quanlyquancafe.controller.web;

import com.quanlyquancafe.model.UserModel;
import com.quanlyquancafe.security.AuthenticationFilter;
import com.quanlyquancafe.utils.FormUtil;
import com.quanlyquancafe.utils.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu", "/login"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("login")) {
            //lấy ra những thứ cần hiển thị trong trang chủ
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/admin-login.jsp");
            rd.forward(req, resp);
        }
        //xóa session và trả về trang chủ hoặc trang login
        else {
            SessionUtil.getInstance().removeValue(req, "USERMODEL");
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel model = FormUtil.toModel(UserModel.class, req);
        String url = AuthenticationFilter.of(model.getUserName(), model.getPassword()).urlRedirect(req);
        resp.sendRedirect(req.getContextPath() + url);
    }
}
