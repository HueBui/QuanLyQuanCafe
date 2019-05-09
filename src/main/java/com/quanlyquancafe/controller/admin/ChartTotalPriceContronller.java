package com.quanlyquancafe.controller.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-chart-price"})
public class ChartTotalPriceContronller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("demo", "1212121");
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/chart-total-price.jsp");
        rd.forward(request, response);
    }
}
