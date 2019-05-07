package com.quanlyquancafe.controller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlyquancafe.model.BookingDetailModel;
import com.quanlyquancafe.model.BookingModel;
import com.quanlyquancafe.service.impl.BookingService;
import com.quanlyquancafe.service.impl.TableService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/booking"})
public class BookingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingService();
        BookingDetailModel bookingDetailModel = new BookingDetailModel();
        TableService tableService = new TableService();

        List<Long> listData = new ArrayList<>();
        String[] myJsonData = request.getParameterValues("json[]");

        for (int i = 0; i < myJsonData.length; ++i) {
            Long phanTu = Long.valueOf(Integer.parseInt(myJsonData[i]));
            listData.add(phanTu);
        }
        Long resultSaveBooking;
        List<BookingModel> listCheck = bookingService.getIdBooking(listData.get(0));
        if (listCheck.size() == 0){
            BookingModel bookingModel = new BookingModel();
            bookingModel.setCreateTime(new Timestamp(System.currentTimeMillis()));
            bookingModel.setCreateBy(1l);
            bookingModel.setTotalPrice(0.0);
            bookingModel.setStatus(1);
            resultSaveBooking = bookingService.saveBooking(bookingModel);
        }
        else {
            resultSaveBooking = listCheck.get(0).getId();
        }

        bookingDetailModel.setIdTable(listData.get(0));
        bookingDetailModel.setIdSanPham(listData.get(1));
        bookingDetailModel.setSoLuong(Math.toIntExact(listData.get(2)));
        bookingDetailModel.setIdBooking(resultSaveBooking);
        bookingDetailModel.setGia(0);
        bookingDetailModel.setCreateBy(1L);
        bookingDetailModel.setCreateTime(new Timestamp(System.currentTimeMillis()));

        List<BookingDetailModel> detailModelList = bookingService.getBookingDetailByIdBooking(resultSaveBooking);
        Long resultSaveBookingDetail = null;
        Long idSanPham = null;
        if (listCheck.size()!=0){
            idSanPham = detailModelList.get(0).getIdSanPham();
        }

        if(bookingDetailModel.getIdSanPham().equals(idSanPham)){
            resultSaveBookingDetail = bookingService.updateQuantityBookingDetail(Math.toIntExact(listData.get(2)),detailModelList.get(0).getIdSanPham(),resultSaveBooking,bookingDetailModel);
        }else{
             resultSaveBookingDetail = bookingService.saveBookingDetail(bookingDetailModel);
             tableService.updateStatusTable(listData.get(0),1);
        }

        ObjectMapper mapper = new ObjectMapper();
        if (resultSaveBookingDetail != -1) {
            mapper.writeValue(response.getOutputStream(), "Sản Phẩm Yêu Cầu Lớn. Hiện tại còn: " + resultSaveBookingDetail);
        } else {
            mapper.writeValue(response.getOutputStream(), "Thêm Thành Công");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/order.jsp");
        rd.forward(request, response);
    }
}
