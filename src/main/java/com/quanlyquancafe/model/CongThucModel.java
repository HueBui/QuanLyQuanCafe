package com.quanlyquancafe.model;

public class CongThucModel {
    private Long idSanPham;
    private Long idNguyenLieu;
    private Double khoiLuong;

    public CongThucModel() {
    }

    public CongThucModel(Long idSanPham, Long idNguyenLieu, Double khoiLuong) {
        this.idSanPham = idSanPham;
        this.idNguyenLieu = idNguyenLieu;
        this.khoiLuong = khoiLuong;
    }

    @Override
    public String toString() {
        return "CongThucModel{" +
                "idSanPham=" + idSanPham +
                ", idNguyenLieu=" + idNguyenLieu +
                ", khoiLuong=" + khoiLuong +
                '}';
    }

    public Long getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Long idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Long getIdNguyenLieu() {
        return idNguyenLieu;
    }

    public void setIdNguyenLieu(Long idNguyenLieu) {
        this.idNguyenLieu = idNguyenLieu;
    }

    public Double getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(Double khoiLuong) {
        this.khoiLuong = khoiLuong;
    }
}
