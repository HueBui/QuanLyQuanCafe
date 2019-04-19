package com.quanlyquancafe.model;

import java.sql.Timestamp;

public class BookingModel  {
    private Long id;
    private Integer idUser;
    private Integer idSanPham;
    private Integer status;
    private Integer idTable;
    private Timestamp date;
    private Integer soLuong;
    public BookingModel() {
    }

    public BookingModel(Long id, Integer idUser, Integer idSanPham, Integer status, Integer idTable, Timestamp date,Integer soLuong) {
        this.id = id;
        this.idUser = idUser;
        this.idSanPham = idSanPham;
        this.status = status;
        this.idTable = idTable;
        this.date = date;
        this.soLuong = soLuong;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "BookingModel{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idSanPham=" + idSanPham +
                ", status=" + status +
                ", idTable=" + idTable +
                ", date=" + date +
                ", soLuong=" + soLuong +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdTable() {
        return idTable;
    }

    public void setIdTable(Integer idTable) {
        this.idTable = idTable;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
