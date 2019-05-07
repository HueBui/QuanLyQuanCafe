package com.quanlyquancafe.controller.web;

import com.quanlyquancafe.model.TableModel;
import com.quanlyquancafe.model.custom.BookingTableCustom;
import com.quanlyquancafe.service.impl.ManagementService;
import com.quanlyquancafe.service.impl.TableService;

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
        TableService tableService = new TableService();

        List<TableModel> tableModelList = tableService.getAll();
        request.setAttribute("tableModels", tableModelList);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/management.jsp");
        rd.forward(request, response);
    }
}
