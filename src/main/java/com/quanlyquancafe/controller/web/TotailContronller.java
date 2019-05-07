package com.quanlyquancafe.controller.web;

import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;
import com.quanlyquancafe.service.impl.BookingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/totalByDate"})
public class TotailContronller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingService();

        Integer idUser =1;
        long millis=System.currentTimeMillis();
        java.sql.Date dates=new java.sql.Date(millis);
        String date = String.valueOf(dates);
        Double tongTien = bookingService.tinhTongTienTheoNgay(idUser,date);
        List<BookingSanPhamBanCustom> list = bookingService.getDetailBookingByDate(idUser,dates);
        request.setAttribute("listbill",list);
        request.setAttribute("tongTien", tongTien);

        RequestDispatcher rd = request.getRequestDispatcher("/views/web/bill-detail.jsp");
        rd.forward(request, response);
    }
}
