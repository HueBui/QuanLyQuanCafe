package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.impl.BillDetailDAO;
import com.quanlyquancafe.dao.impl.BookingDAO;
import com.quanlyquancafe.dao.impl.CongThucDAO;
import com.quanlyquancafe.dao.impl.NguyenLieuDAO;
import com.quanlyquancafe.model.BookingDetailModel;
import com.quanlyquancafe.model.BookingModel;
import com.quanlyquancafe.model.CongThucModel;
import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;
import com.quanlyquancafe.model.custom.SanPhamNguyenLieuCongThucCustom;
import com.quanlyquancafe.service.IBookingService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingService implements IBookingService {
    @Override
    public Long saveBookingDetail(BookingDetailModel bookingDetailModel) {
        Long result;
        CongThucDAO congThucDAO = new CongThucDAO();
        BookingDAO bookingDAO = new BookingDAO();
        NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAO();

        List<SanPhamNguyenLieuCongThucCustom> listKhoiLuong = nguyenLieuDAO.listKhoiLuong(Math.toIntExact(bookingDetailModel.getIdSanPham()));
        ArrayList<Double> listTrungBinh = new ArrayList<>();
        for (int i = 0; i < listKhoiLuong.size(); i++) {
            listTrungBinh.add(listKhoiLuong.get(i).getKhoiLuongNguyenLieu() / listKhoiLuong.get(i).getKhoiLuongCongThuc());
        }

        Double min = listTrungBinh.get(0);
        for (int i = 0; i < listTrungBinh.size(); i++) {
            if (listTrungBinh.get(i).compareTo(min) < 0) {
                min = listTrungBinh.get(i);
            }
        }

        if (bookingDetailModel.getSoLuong() > Math.round(min)) {
            result = new Double(min).longValue();
        } else {
            bookingDAO.saveBookingDetail(bookingDetailModel);
            result = -1L;
            if (result != null) {
                List<CongThucModel> listCongThuc = congThucDAO.getInforCongThucByIdSanPham(Math.toIntExact(bookingDetailModel.getIdSanPham()));
                for (int i = 0; i < listCongThuc.size(); i++) {
                    Double tong = bookingDetailModel.getSoLuong() * listCongThuc.get(i).getKhoiLuong();
                    nguyenLieuDAO.updateQuantity(tong, listCongThuc.get(i).getIdNguyenLieu());
                }
            }
        }
        return result;
    }

    @Override
    public Long saveBooking(BookingModel bookingModel) {
        BookingDAO bookingDAO = new BookingDAO();
        return bookingDAO.saveBooking(bookingModel);
    }

    @Override
    public List<BookingSanPhamBanCustom> listDetailBooking(Long idBan) {
        BillDetailDAO billDetailDAO = new BillDetailDAO();
        List<BookingSanPhamBanCustom> list = billDetailDAO.detailBill(idBan);
        return list;
    }

    @Override
    public List<BookingModel> getIdBooking(Long idBan) {
        BookingDAO bookingDAO = new BookingDAO();
        return bookingDAO.checkStatusBooking(idBan);
    }

    @Override
    public List<BookingDetailModel> getBookingDetailByIdBooking(Long idBooking) {
        BookingDAO bookingDAO = new BookingDAO();
        return bookingDAO.getBookingDetailByIdBooking(idBooking);
    }

    @Override
    public Long updateQuantityBookingDetail(Integer quantity, Long idSanPham, Long idBooking, BookingDetailModel bookingDetailModel) {
        BookingDAO bookingDAO = new BookingDAO();
        Long result;
        CongThucDAO congThucDAO = new CongThucDAO();
        NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAO();

        List<SanPhamNguyenLieuCongThucCustom> listKhoiLuong = nguyenLieuDAO.listKhoiLuong(Math.toIntExact(bookingDetailModel.getIdSanPham()));
        ArrayList<Double> listTrungBinh = new ArrayList<>();
        for (int i = 0; i < listKhoiLuong.size(); i++) {
            listTrungBinh.add(listKhoiLuong.get(i).getKhoiLuongNguyenLieu() / listKhoiLuong.get(i).getKhoiLuongCongThuc());
        }

        Double min = listTrungBinh.get(0);
        for (int i = 0; i < listTrungBinh.size(); i++) {
            if (listTrungBinh.get(i).compareTo(min) < 0) {
                min = listTrungBinh.get(i);
            }
        }

        if (bookingDetailModel.getSoLuong() > Math.round(min)) {
            result = new Double(min).longValue();
        } else {
             bookingDAO.updateQuantityBookingDetail(quantity, idSanPham, idBooking);
            result = -1L;
            if (result != null) {
                List<CongThucModel> listCongThuc = congThucDAO.getInforCongThucByIdSanPham(Math.toIntExact(bookingDetailModel.getIdSanPham()));
                for (int i = 0; i < listCongThuc.size(); i++) {
                    Double tong = bookingDetailModel.getSoLuong() * listCongThuc.get(i).getKhoiLuong();
                    nguyenLieuDAO.updateQuantity(tong, listCongThuc.get(i).getIdNguyenLieu());
                }
            }
        }
        return result;
    }

    @Override
    public boolean thanhToan(Long ids) {
        BookingDAO bookingDAO = new BookingDAO();
        return bookingDAO.thanhToan(ids);
    }

    @Override
    public Double tinhTongTienTheoNgay(Integer idUser, String date) {
        BookingDAO bookingDAO =new BookingDAO();
        List<BookingModel> bookingModels = bookingDAO.tinhTongTienTheoNgay(idUser,date);
        Double tongTien =0.0;
        for (int i=0; i<bookingModels.size(); i++){
            tongTien += bookingModels.get(i).getTotalPrice();
        }
        return tongTien;
    }

    @Override
    public List<BookingSanPhamBanCustom> getDetailBookingByDate(Integer idUser, Date date) {
        BillDetailDAO billDetailDAO = new BillDetailDAO();
        List<BookingSanPhamBanCustom> bookingModelList = billDetailDAO.listDetailBillByDate(idUser,date);
        return bookingModelList;
    }

    @Override
    public Double tinhTongTienTheoNgayDenNgay(Integer idUser, String dateFrom, String dateTo) {
        BookingDAO bookingDAO =new BookingDAO();
        List<BookingModel> bookingModels = bookingDAO.tinhTongTienTuNgayDenNgay(idUser,dateFrom,dateTo);
        Double tongTien =0.0;
        for (int i=0; i<bookingModels.size(); i++){
            tongTien += bookingModels.get(i).getTotalPrice();
        }
        return tongTien;
    }

    @Override
    public boolean updateTotailPrice(Integer idbooking, Double tongTien) {
        BookingDAO bookingDAO = new BookingDAO();
        return bookingDAO.updateTotalPrice(idbooking,tongTien);
    }

    public Double tongSanPham(Long idBan) {
        BillDetailDAO billDetailDAO = new BillDetailDAO();
        List<BookingSanPhamBanCustom> list = billDetailDAO.detailBill(idBan);
        Double tong = 0.0;
        for (int i = 0; i < list.size(); i++) {
            tong += list.get(i).getSoLuong() * list.get(i).getGia();
        }
        return tong;
    }

}
