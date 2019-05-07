package com.quanlyquancafe.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyquancafe.model.CategoryModel;
import com.quanlyquancafe.service.impl.CategoryService;
import com.quanlyquancafe.utils.HttpUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-list-category", "/admin-edit-category"})
public class AdminCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService service = new CategoryService();
        String action = request.getParameter("action");

        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setImage(request.getParameter("image"));
        categoryModel.setType(request.getParameter("type"));

        if (action != null && action.equals("themdanhmuc")) {

            Long result = service.saveCategory(categoryModel);
            if (result != null) {
                request.setAttribute("msg", "Thêm thành công");
            } else {
                request.setAttribute("msg", "Thêm không thành công");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category/category-edit.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("suadanhmuc")) {
            categoryModel.setId(Long.parseLong(request.getParameter("id")));
            if (service.update(categoryModel) == true) {
                request.setAttribute("msg", "Sửa thành công!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category/category-edit.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Sửa thất bại!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category/category-edit.jsp");
                rd.forward(request, response);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService service = new CategoryService();
        String action = request.getParameter("action");
        String active6 = "active";
        request.setAttribute("active6", active6);
        if (action != null && action.equals("list")) {
            List<CategoryModel> categoryModels = service.getAll();
            String msg = request.getParameter("msg");
            request.setAttribute("categoryModels", categoryModels);
            String thongbao = "";
            if (msg != null && msg.equals("xoathanhcong")) {
                thongbao = "Xóa Thành công";
            } else if (msg != null && msg.equals("xoathatbai")) {
                thongbao = "Xóa thất bại";
            }
            request.setAttribute("msg", thongbao);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category/category-list.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("edit")) {
            String categoryId = request.getParameter("id");
            if (categoryId != null) {
                CategoryService userService = new CategoryService();
                CategoryModel categoryModel = userService.findOne((Long.parseLong(categoryId)));
                request.setAttribute("categoryModel", categoryModel);
            }
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category/category-edit.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("/admin-edit-category?action=list");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        CategoryModel categoryModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
        CategoryService categoryService = new CategoryService();
        categoryService.delete(categoryModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }
}
