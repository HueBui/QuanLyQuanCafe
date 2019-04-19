package com.quanlyquancafe.model.custom;

public class SanPhamNguyenLieuCongThucCustom {
    private Double khoiLuongCongThuc;
    private Double khoiLuongNguyenLieu;

    public SanPhamNguyenLieuCongThucCustom() {
    }

    @Override
    public String toString() {
        return "SanPhamNguyenLieuCongThucCustom{" +
                "khoiLuongCongThuc=" + khoiLuongCongThuc +
                ", khoiLuongNguyenLieu=" + khoiLuongNguyenLieu +
                '}';
    }

    public SanPhamNguyenLieuCongThucCustom(Double khoiLuongCongThuc, Double khoiLuongNguyenLieu) {
        this.khoiLuongCongThuc = khoiLuongCongThuc;
        this.khoiLuongNguyenLieu = khoiLuongNguyenLieu;
    }

    public Double getKhoiLuongCongThuc() {
        return khoiLuongCongThuc;
    }

    public void setKhoiLuongCongThuc(Double khoiLuongCongThuc) {
        this.khoiLuongCongThuc = khoiLuongCongThuc;
    }

    public Double getKhoiLuongNguyenLieu() {
        return khoiLuongNguyenLieu;
    }

    public void setKhoiLuongNguyenLieu(Double khoiLuongNguyenLieu) {
        this.khoiLuongNguyenLieu = khoiLuongNguyenLieu;
    }


}
