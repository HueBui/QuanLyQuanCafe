package com.quanlyquancafe.controller.web;

import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;
import com.quanlyquancafe.model.custom.BookingTableCustom;
import com.quanlyquancafe.service.impl.BookingService;
import com.quanlyquancafe.service.impl.ManagementService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/management-product"})
public class ManagementListProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingService();
        Long idTable = Long.parseLong(request.getParameter("idTable"));
        List<BookingSanPhamBanCustom> bookingSanPhamTable = bookingService.listDetailBooking(idTable);
        request.setAttribute("bookingSanPhamTable", bookingSanPhamTable);
        Double tongTien = bookingService.tongSanPham(idTable);
        request.setAttribute("tongTien", tongTien);
        request.setAttribute("idTable", idTable);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/management-list.jsp");
        rd.forward(request, response);
    }
}
