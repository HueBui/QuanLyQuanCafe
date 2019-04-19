package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.impl.BillDetailDAO;
import com.quanlyquancafe.dao.impl.BookingDAO;
import com.quanlyquancafe.dao.impl.CongThucDAO;
import com.quanlyquancafe.dao.impl.NguyenLieuDAO;
import com.quanlyquancafe.model.BookingModel;
import com.quanlyquancafe.model.CongThucModel;
import com.quanlyquancafe.model.custom.BookingSanPhamBanCustom;
import com.quanlyquancafe.model.custom.SanPhamNguyenLieuCongThucCustom;
import com.quanlyquancafe.service.IBookingService;

import java.util.ArrayList;
import java.util.List;

public class BookingService implements IBookingService {
    @Override
    public Long save(BookingModel bookingModel) {
        Long result;
        CongThucDAO congThucDAO = new CongThucDAO();
        BookingDAO bookingDAO = new BookingDAO();
        NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAO();

        List<SanPhamNguyenLieuCongThucCustom> listKhoiLuong = nguyenLieuDAO.listKhoiLuong(bookingModel.getIdSanPham());
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

        if (bookingModel.getSoLuong() > Math.round(min)) {
            result = new Double(min).longValue();
        } else {
            bookingDAO.save(bookingModel);
            result = 1L;
            if (result != null) {
                List<CongThucModel> listCongThuc = congThucDAO.getInforCongThucByIdSanPham(bookingModel.getIdSanPham());
                for (int i = 0; i < listCongThuc.size(); i++) {
                    Double tong = bookingModel.getSoLuong() * listCongThuc.get(i).getKhoiLuong();
                    nguyenLieuDAO.updateQuantity(tong, listCongThuc.get(i).getIdNguyenLieu());
                }
            }
        }
        return result;
    }

    @Override
    public List<BookingSanPhamBanCustom> listDetailBooking(Long idBan) {
        BillDetailDAO billDetailDAO = new BillDetailDAO();
        List<BookingSanPhamBanCustom> list = billDetailDAO.detailBill(idBan);
        return list;
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
