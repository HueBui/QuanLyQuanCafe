package com.quanlyquancafe.model.custom;

public class BookingSanPhamBanCustom {
    private Long id;
    private String tenSp;
    private String tenBan;
    private Integer soLuong;
    private Double gia;

    private  Long idTable;

    public Long getIdTable() {
        return idTable;
    }

    public void setIdTable(Long idTable) {
        this.idTable = idTable;
    }

    public BookingSanPhamBanCustom() {
    }

    public BookingSanPhamBanCustom(Long id, String tenSp, String tenBan, Integer soLuong, Double gia) {
        this.id = id;
        this.tenSp = tenSp;
        this.tenBan = tenBan;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "BookingSanPhamBanCustom{" +
                "id=" + id +
                ", tenSp='" + tenSp + '\'' +
                ", tenBan='" + tenBan + '\'' +
                ", soLuong=" + soLuong +
                ", gia=" + gia +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }
}
