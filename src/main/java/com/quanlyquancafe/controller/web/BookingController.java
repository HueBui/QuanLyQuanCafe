package com.quanlyquancafe.controller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyquancafe.model.BookingModel;
import com.quanlyquancafe.service.impl.BookingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/booking"})
public class BookingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingService();
        BookingModel bookingModel = new BookingModel();

        List<Integer> listData = new ArrayList<>();
        String[] myJsonData = request.getParameterValues("json[]");

        for (int i = 0; i < myJsonData.length; ++i) {
            Integer phanTu = Integer.parseInt(myJsonData[i]);
            listData.add(phanTu);
        }
            bookingModel.setIdTable(listData.get(0));
            bookingModel.setIdSanPham(listData.get(1));
            bookingModel.setSoLuong(listData.get(2));

        bookingModel.setDate(new Timestamp(System.currentTimeMillis()));
        bookingModel.setStatus(0);
        bookingModel.setIdUser(1);

        Long result = bookingService.save(bookingModel);
        ObjectMapper mapper = new ObjectMapper();
        if (result !=1){
            mapper.writeValue(response.getOutputStream(), "Sản Phẩm Yêu Cầu Lớn. Hiện tại còn: "+result);
        }else {
            mapper.writeValue(response.getOutputStream(), "Thêm Thành Công");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/order.jsp");
        rd.forward(request, response);
    }
}
