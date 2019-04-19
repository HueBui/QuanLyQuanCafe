package com.quanlyquancafe.controller.admin;

import com.quanlyquancafe.model.TableModel;
import com.quanlyquancafe.model.custom.MenuOrderCategoryCustom;
import com.quanlyquancafe.service.impl.MenuOrderService;
import com.quanlyquancafe.service.impl.TableService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-list-table", "/admin-edit-table"})
public class AdminTableController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TableService tableService = new TableService();
        String action = request.getParameter("action");
        if (action != null && action.equals("list")) {
            String active5 = "active";

            List<TableModel> tableModels = tableService.getAll();

            request.setAttribute("tableList", tableModels);
            request.setAttribute("active5", active5);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/table/table-list.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("edit")) {
            String active5 = "active";
            request.setAttribute("active5", active5);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/menu/menu-edit.jsp");
            rd.forward(request, response);
        } else {
        }
    }
}
