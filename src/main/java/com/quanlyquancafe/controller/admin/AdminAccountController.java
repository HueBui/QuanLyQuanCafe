package com.quanlyquancafe.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyquancafe.model.UserModel;
import com.quanlyquancafe.service.impl.UserService;
import com.quanlyquancafe.utils.HttpUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-list-account", "/admin-edit-account"})
public class AdminAccountController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service = new UserService();
        String action = request.getParameter("action");

        UserModel userModel = new UserModel();
        userModel.setUserName(request.getParameter("name"));
        userModel.setFullName(request.getParameter("user_firstName"));
        userModel.setPassword(request.getParameter("password"));
        userModel.setRoleId(Long.parseLong(request.getParameter("user_level")));
        userModel.setAddress(request.getParameter("user_adress"));
        userModel.setImage(request.getParameter("user_img"));
        userModel.setPhone(Integer.parseInt(request.getParameter("user_phone")));
        userModel.setCmtnd(Integer.parseInt(request.getParameter("cmtnd")));
        userModel.setEmail(request.getParameter("email"));
        userModel.setCreatedBy("null");
        userModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        userModel.setModifiedBy("null");
        userModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        if (action != null && action.equals("themtaikhoan")) {

            Long result = service.saveInforUser(userModel);
            if (result != null) {
                request.setAttribute("msg", "Thêm thành công");
            } else {
                request.setAttribute("msg", "Thêm không thành công");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/account/account-edit.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("suataikhoan")) {
            userModel.setId(Long.parseLong(request.getParameter("id")));
            if (service.update(userModel) == true) {
                request.setAttribute("msg", "Sửa thành công!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/account/account-edit.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Sửa thất bại!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/account/account-edit.jsp");
                rd.forward(request, response);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service = new UserService();
        String action = request.getParameter("action");
        String active2 = "active";
        request.setAttribute("active2", active2);
        if (action != null && action.equals("list")) {
            List<UserModel> userModels = service.listAll();
            String msg = request.getParameter("msg");
            request.setAttribute("userModel", userModels);
            request.setAttribute("userModels", userModels);
            String thongbao = "";
            if (msg != null && msg.equals("xoathanhcong")) {
                thongbao = "Xóa Thành công";
            } else if (msg != null && msg.equals("xoathatbai")) {
                thongbao = "Xóa thất bại";
            }
            request.setAttribute("msg", thongbao);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/account/account-list.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("edit")) {
            String userId = request.getParameter("userId");
            if (userId != null) {
                UserService userService = new UserService();
                UserModel userModel = userService.findOne((Long.parseLong(userId)));
                request.setAttribute("userModel", userModel);
            }
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/account/account-edit.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("/admin-edit-account?action=list");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
        UserService userService = new UserService();
        userService.delete(userModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }
}
