package com.quanlyquancafe.controller.admin;

import com.quanlyquancafe.service.impl.CountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-count"})
public class AdminCountController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CountService countService = new CountService();

        Integer countTable = countService.countTable();
        request.setAttribute("countTable",countTable);

        Integer countCategory = countService.countCategory();
        request.setAttribute("countCategory",countCategory);

        Integer countProduct = countService.countProduct();
        request.setAttribute("countProduct",countProduct);

        Integer countNguyenLieu = countService.countNguyenLieu();
        request.setAttribute("countNguyenLieu",countNguyenLieu);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/thong-ke.jsp");
        rd.forward(request, response);

    }
}

