package com.quanlyquancafe.controller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyquancafe.service.impl.BookingService;
import com.quanlyquancafe.utils.HttpUtil;

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

        mapper.writeValue(resp.getOutputStream(), "{}");
    }
}
