package com.quanlyquancafe.controller.web;

import com.quanlyquancafe.model.custom.BookingTableCustom;
import com.quanlyquancafe.service.impl.ManagementService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/management"})
public class ManagementController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManagementService managementService = new ManagementService();
        List<BookingTableCustom> bookingTable = managementService.getTable();
        request.setAttribute("bookingTable", bookingTable);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/management.jsp");
        rd.forward(request, response);
    }
}
