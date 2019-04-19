package com.quanlyquancafe.controller.web;

import com.quanlyquancafe.model.UserModel;
import com.quanlyquancafe.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns ={"/user"})
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserModel model=new UserModel();
        String userId=request.getParameter("userId");
        HttpSession ss=request.getSession();
        UserModel userModelss=new UserModel();
        userModelss=(UserModel) ss.getAttribute("USERMODEL");
        Long idss=userModelss.getId();
        if(userId==""||userId==null){
            response.sendRedirect("/trang-chu");
        }if(Long.parseLong(userId)!=idss){
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            PrintWriter pr=response.getWriter();
            pr.println(" <h1> Ban khong the xem thong tin nguoi khac </h1>");
        }
        else {
            UserService userService = new UserService();
            model = userService.findOne(Long.parseLong(userId));
            request.setAttribute("userModel", model);
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/user.jsp");
            rd.forward(request, response);
        }
    }
}
