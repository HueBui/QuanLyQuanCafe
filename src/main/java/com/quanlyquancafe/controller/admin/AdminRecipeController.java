package com.quanlyquancafe.controller.admin;

import com.quanlyquancafe.model.custom.SanPhamCongThucNguyenLieuCustom;
import com.quanlyquancafe.model.custom.SanPhamNguyenLieuCongThucCustom;
import com.quanlyquancafe.service.impl.CongThucService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-list-recipe"})
public class AdminRecipeController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CongThucService congThucService = new CongThucService();
        String action = request.getParameter("action");
        String active2 = "active";
        request.setAttribute("active7", active2);
        if (action != null && action.equals("list")) {
            List<SanPhamCongThucNguyenLieuCustom> congThucCustoms = congThucService.getInforCongThuc();
            request.setAttribute("congThucCustoms", congThucCustoms);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/recipe/recipe-list.jsp");
            rd.forward(request, response);
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
