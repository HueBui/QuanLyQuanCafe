package com.quanlyquancafe.model;

import java.sql.Timestamp;

public class BookingDetailModel {
    private Long idSanPham;
    private Long idTable;
    private Long idBooking;
    private Integer soLuong;
    private Integer gia;
    private Timestamp createTime;
    private Long createBy;

    public BookingDetailModel() {
    }

    public Long getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Long idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Long getIdTable() {
        return idTable;
    }

    public void setIdTable(Long idTable) {
        this.idTable = idTable;
    }

    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public BookingDetailModel(Long idSanPham, Long idTable, Long idBooking, Integer soLuong, Integer gia, Timestamp createTime, Long createBy) {
        this.idSanPham = idSanPham;
        this.idTable = idTable;
        this.idBooking = idBooking;
        this.soLuong = soLuong;
        this.gia = gia;
        this.createTime = createTime;
        this.createBy = createBy;
    }
}
