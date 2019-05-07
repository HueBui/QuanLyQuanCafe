package com.quanlyquancafe.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyquancafe.model.CategoryModel;
import com.quanlyquancafe.model.ProductModel;
import com.quanlyquancafe.model.custom.ProductCategoryCustom;
import com.quanlyquancafe.service.impl.CategoryService;
import com.quanlyquancafe.service.impl.ProductService;
import com.quanlyquancafe.utils.HttpUtil;
import org.jboss.weld.logging.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-list-menu","/admin-edit-menu"})
public class AdminProductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = new ProductService();

        String action = request.getParameter("action");

        ProductModel productModel =new ProductModel();
        productModel.setName(request.getParameter("name"));
        productModel.setPrice(Integer.parseInt(request.getParameter("gia")));
        productModel.setImage(request.getParameter("image"));
        productModel.setIdCategory(Long.parseLong(request.getParameter("idCategory")));

        if (action != null && action.equals("themsanpham")) {

            Long result = service.saveProduct(productModel);
            if (result != null) {
                request.setAttribute("msg", "Thêm thành công");
            } else {
                request.setAttribute("msg", "Thêm không thành công");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/product-edit.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("suasanpham")) {
            productModel.setId(Long.parseLong(request.getParameter("id")));

            if (service.update(productModel) == true) {
                request.setAttribute("msg", "Sửa thành công!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/account/account-edit.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Sửa thất bại!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/account/account-edit.jsp");
                rd.forward(request, response);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService menuService = new ProductService();
        String action=request.getParameter("action");
        if(action!=null&& action.equals("list")){
            String active4="active";

            List<ProductCategoryCustom> menuModel= menuService.list();
            String msg = request.getParameter("msg");

            request.setAttribute("menuModel",menuModel);
            request.setAttribute("active4",active4);

            ProductService productService  = new ProductService();
            String idProduct = String.valueOf(Long.parseLong(request.getParameter( "id")));
            ProductModel menu = productService.findOne(Long.parseLong(idProduct));
            request.setAttribute("product", menu);

            String thongbao = "";
            if (msg != null && msg.equals("xoathanhcong")) {
                thongbao = "Xóa Thành công";
            } else if (msg != null && msg.equals("xoathatbai")) {
                thongbao = "Xóa thất bại";
            }
            request.setAttribute("msg", thongbao);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/product-list.jsp");
            rd.forward(request, response);
        }else if(action!=null && action.equals("edit")){
            CategoryService categoryService = new CategoryService();

            List<CategoryModel> categoryModelList = categoryService.getAll();
            request.setAttribute("categoryModelList",categoryModelList);

            String active6="active";
            request.setAttribute("active6",active6);
            RequestDispatcher rd=request.getRequestDispatcher("/views/admin/product/product-edit.jsp");
            rd.forward(request,response);
        }else {
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ProductModel productModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);
        ProductService productService = new ProductService();
        productService.delete(productModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }
}
