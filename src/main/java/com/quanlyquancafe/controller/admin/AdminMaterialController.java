package com.quanlyquancafe.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyquancafe.mapper.NguyenLieuMapper;
import com.quanlyquancafe.model.NguyenLieuModel;
import com.quanlyquancafe.model.UserModel;
import com.quanlyquancafe.service.impl.NguyenLieuService;
import com.quanlyquancafe.service.impl.UserService;
import com.quanlyquancafe.utils.HttpUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-list-nguyen-lieu","/admin-edit-nguyen-lieu"})
public class AdminMaterialController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NguyenLieuService service = new NguyenLieuService();
        String action = request.getParameter("action");

        String inputString = request.getParameter("ngayNhap");
        String[] output = inputString.split(" ");
        String[] output1 =  output[1].split("/");

        String ngayNhap = output1[2]+"-"+output1[1]+"-"+output1[0]+" "+output[0]+":00" ;

        NguyenLieuModel nguyenLieuModel = new NguyenLieuModel();
        nguyenLieuModel.setName(request.getParameter("name"));
        nguyenLieuModel.setQuantity(Integer.parseInt(request.getParameter("soluong")));
        nguyenLieuModel.setNgayNhap(Timestamp.valueOf(ngayNhap));
        nguyenLieuModel.setPrice(Integer.parseInt(request.getParameter("gia")));
        nguyenLieuModel.setImage(request.getParameter("image"));

        if (action != null && action.equals("themnguyenlieu")) {

            Long result = service.saveInforNguyenLieu(nguyenLieuModel);
            if (result != null) {
                request.setAttribute("msg", "Thêm thành công");
            } else {
                request.setAttribute("msg", "Thêm không thành công");
            }

            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/material/material-edit.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("suanguyenlieu")) {
            nguyenLieuModel.setId(Long.parseLong(request.getParameter("id")));
            if (service.update(nguyenLieuModel) == true) {
                request.setAttribute("msg", "Sửa thành công!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/material/material-edit.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Sửa thất bại!");
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/material/material-edit.jsp");
                rd.forward(request, response);
            }

        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        NguyenLieuService nguyenLieuService = new NguyenLieuService();
        if(action!=null&& action.equals("list")){
            String active3="active";
            request.setAttribute("active3",active3);
            List<NguyenLieuModel> nguyenLieuModels;
            nguyenLieuModels = nguyenLieuService.listAll();
            request.setAttribute("nguyenLieuModels",nguyenLieuModels);
            RequestDispatcher rd=request.getRequestDispatcher("/views/admin/material/material-list.jsp");
            rd.forward(request,response);
        }else if (action != null && action.equals("edit")) {
            String nguyenLieuId = request.getParameter("nguyenLieuId");
            if (nguyenLieuId != null) {
                NguyenLieuService service = new NguyenLieuService();
                NguyenLieuModel nguyenLieuModel = service.findOne((Long.parseLong(nguyenLieuId)));
                request.setAttribute("nguyenLieuModel", nguyenLieuModel);
            }
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/material/material-edit.jsp");
            rd.forward(request, response);
        }else {
            response.sendRedirect("/admin-edit-nguyen-lieu?action=list");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NguyenLieuModel nguyenLieuModel = HttpUtil.of(req.getReader()).toModel(NguyenLieuModel.class);
        NguyenLieuService nguyenLieuService = new NguyenLieuService();
        nguyenLieuService.delete(nguyenLieuModel.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }
}
