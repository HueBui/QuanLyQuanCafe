package com.quanlyquancafe.controller.web;

import com.quanlyquancafe.dao.impl.UserDAO;
import com.quanlyquancafe.model.UserModel;
import com.quanlyquancafe.security.AuthenticationFilter;
import com.quanlyquancafe.service.impl.UserService;
import com.quanlyquancafe.utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns ={"/dang-ky"})
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO=new UserDAO();
        UserService userService=new UserService();
        UserModel model= FormUtil.toModel(UserModel.class,request);
        if(userDAO.validate(model)==true){

            Long id= userService.save(model);
            UserModel userModel=new UserModel();
            userModel=userService.findOne(id);

            String url= AuthenticationFilter.of(userModel.getUserName(),userModel.getPassword()).urlRedirect(request);
            response.sendRedirect(request.getContextPath()+url);

        }
        else {
            request.setCharacterEncoding("utf-8");
            request.setAttribute("msg","Lỗi đăng ký.Tài khoản đã tồn tại!");
            RequestDispatcher rd=request.getRequestDispatcher("/views/web/register.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action=request.getParameter("action");
        if (action != null && action.equals("register")) {
            //trả về trang đăng ký
            String activeBtnRegister="btn active";
            request.setAttribute("activeBtnRegister",activeBtnRegister);
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/register.jsp");
            rd.forward(request, response);
        }
        else {
            response.sendRedirect("/dang-ky?action=register");
        }
    }
}
