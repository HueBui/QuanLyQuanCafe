package com.quanlyquancafe.controller.web;

import com.quanlyquancafe.model.TableModel;
import com.quanlyquancafe.service.impl.TableService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/order"})
public class OderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TableService tableService = new TableService();
        List<TableModel> tableModels = tableService.getAll();
        request.setAttribute("tableModels", tableModels);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/order.jsp");
        rd.forward(request, response);
    }
}
