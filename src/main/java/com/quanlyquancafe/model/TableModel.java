package com.quanlyquancafe.model;

public class TableModel extends AbstractModel<TableModel> {
    private Long id;
    private String name;
    private Long typeTable;
    private Long soLuongGhe;
    private Long status;
    private String ghiChu;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypeTable() {
        return typeTable;
    }

    public void setTypeTable(Long typeTable) {
        this.typeTable = typeTable;
    }

    public Long getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(Long soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public TableModel(Long id, String name, Long typeTable, Long soLuongGhe, Long status, String ghiChu, String image) {
        this.id = id;
        this.name = name;
        this.typeTable = typeTable;
        this.soLuongGhe = soLuongGhe;
        this.status = status;
        this.ghiChu = ghiChu;
        this.image = image;
    }

    @Override
    public String toString() {
        return "TableModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeTable=" + typeTable +
                ", soLuongGhe=" + soLuongGhe +
                ", status=" + status +
                ", ghiChu='" + ghiChu + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public TableModel() {
    }
}
