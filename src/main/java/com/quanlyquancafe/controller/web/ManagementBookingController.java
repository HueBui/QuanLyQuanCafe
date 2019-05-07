package com.quanlyquancafe.controller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyquancafe.model.BookingModel;
import com.quanlyquancafe.service.impl.BookingService;
import com.quanlyquancafe.service.impl.ManagementService;
import com.quanlyquancafe.service.impl.TableService;
import com.quanlyquancafe.utils.HttpUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/booking-detail"})
public class ManagementBookingController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        List<String> listData = new ArrayList<>();
        String[] myJsonData = req.getParameterValues("json[]");

        for (int i = 0; i < myJsonData.length; ++i) {
            String phanTu = myJsonData[i];
            listData.add(phanTu);
        }

        TableService tableService = new TableService();
        BookingService bookingService = new BookingService();
        boolean idtable = tableService.updateStatusTable(Long.valueOf(listData.get(0)),0);
        boolean idbooking =bookingService.thanhToan(Long.valueOf(listData.get(1)));

        boolean updateTotal = bookingService.updateTotailPrice(Math.toIntExact(Long.parseLong(listData.get(1))), Double.valueOf(listData.get(2)));
        if (idbooking && idtable){
            mapper.writeValue(resp.getOutputStream(), "Thanh toán thành công!");

        }
        else {
            mapper.writeValue(resp.getOutputStream(), "Thanh toán không thành công!");
        }

    }
}
