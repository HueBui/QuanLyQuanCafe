package com.quanlyquancafe.controller.admin;

import com.quanlyquancafe.model.BookingModel;
import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;
import com.quanlyquancafe.model.custom.CountCustom;
import com.quanlyquancafe.model.custom.DateCustom;
import com.quanlyquancafe.service.impl.BookingService;
import com.quanlyquancafe.service.impl.ChartService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-chart-price"})
public class AdminChartContronller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChartService chartService = new ChartService();
        BookingService bookingService = new BookingService();

        List<DateCustom> listDateBillObject = chartService.getAllDateBill();

        List<String> listDate = new ArrayList<>();

        for (int i = 0; i<listDateBillObject.size(); i++){
            String [] string = listDateBillObject.get(i).getDate().split("-");
            String str1 = string[0];
            String str2 = string[1];
            String str3 = string[2];
            String str4 = str3+str2+str1;
            listDate.add(str4);
        }
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date dateT=ts;
        List<CountCustom> listTotalByDate = chartService.getAllTotal();

        List<String> listTotalInt = new ArrayList<>();
        for (int i=0; i<listTotalByDate.size();i++){
            listTotalInt.add(String.valueOf(listTotalByDate.get(i).getCount()));
        }
        List<BookingModel> listTotal = bookingService.listbookingbydate(listDateBillObject.get(0).getDate(), String.valueOf(dateT));

        request.setAttribute("listDateBillString", listDate);
        request.setAttribute("listTotalInt", listTotalInt);

        RequestDispatcher rd = request.getRequestDispatcher("/views/web/chart-total-price.jsp");
        rd.forward(request, response);
    }
}
