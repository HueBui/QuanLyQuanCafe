package com.quanlyquancafe.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyquancafe.model.TableModel;
import com.quanlyquancafe.service.impl.TableService;
import com.quanlyquancafe.utils.FormUtil;
import com.quanlyquancafe.utils.HttpUtil;

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
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        TableModel tableModel = FormUtil.toModel(TableModel.class, request);
        TableService tableService = new TableService();
        if (action != null && action.equals("addnew")) {
            Long kq = tableService.saveInforTable(tableModel);
            if (kq != null) {
                request.setAttribute("msg", "Thêm bàn thành công!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/table/table-edit.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Thêm bàn thất bại!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/table/table-edit.jsp");
                rd.forward(request, response);
            }

        } else if (action != null && action.equals("edit")) {
            boolean kq = tableService.update(tableModel);
            if (kq == true) {
                request.setAttribute("msg", "Cập nhật thành công!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/table/table-edit.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Cập nhật thất bại!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/table/table-edit.jsp");
                rd.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TableService tableService = new TableService();
        String action = request.getParameter("action");

        if (action != null && action.equals("list")) {

            String msg = request.getParameter("msg");
            String active5 = "active";
            List<TableModel> tableModels = tableService.getAll();
            request.setAttribute("tableList", tableModels);
            request.setAttribute("active5", active5);
            String thongbao = "";
            if (msg != null && msg.equals("xoathanhcong")) {
                thongbao = "Xóa Thành công";
            } else if (msg != null && msg.equals("xoathatbai")) {
                thongbao = "Xóa thất bại";
            }
            request.setAttribute("msg", thongbao);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/table/table-list.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("edit")) {
            String id = request.getParameter("id");
            if (id != null) {
                TableModel tableModel = tableService.findOne(Long.parseLong(id));
                request.setAttribute("tableModel", tableModel);
            }
            String active5 = "active";
            request.setAttribute("active5", active5);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/table/table-edit.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("/admin-table-edit?action=list");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        TableModel tableModel = HttpUtil.of(req.getReader()).toModel(TableModel.class);
        TableService tableService = new TableService();
        tableService.delete(tableModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }
}
