package com.quanlyquancafe.model.custom;

public class SanPhamCongThucNguyenLieuCustom {
    private Long idSanPham;
    private Long idNguyenLieu;
    private String tenSanPham;
    private String tenNguyenLieu;
    private Double khoiLuong;

    public SanPhamCongThucNguyenLieuCustom() {
    }

    public SanPhamCongThucNguyenLieuCustom(Long idSanPham, Long idNguyenLieu, String tenSanPham, String tenNguyenLieu, Double khoiLuong) {
        this.idSanPham = idSanPham;
        this.idNguyenLieu = idNguyenLieu;
        this.tenSanPham = tenSanPham;
        this.tenNguyenLieu = tenNguyenLieu;
        this.khoiLuong = khoiLuong;
    }

    public Long getIdSanPham() {
        return idSanPham;
    }

    public Long getIdNguyenLieu() {
        return idNguyenLieu;
    }

    public void setIdSanPham(Long idSanPham) {
        this.idSanPham = idSanPham;
    }

    public void setIdNguyenLieu(Long idNguyenLieu) {
        this.idNguyenLieu = idNguyenLieu;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public Double getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(Double khoiLuong) {
        this.khoiLuong = khoiLuong;
    }
}
