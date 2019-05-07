package com.quanlyquancafe.model.custom;

public class ProductCategoryCustom {
    private Long id;
    private String tenSp;
    private Double gia;
    private String image;
    private String type;
    private Long idCategory;

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductCategoryCustom() {
    }

    public ProductCategoryCustom(Long id, String tenSp, Double gia, String image, String type, Long idCategory) {
        this.id = id;
        this.tenSp = tenSp;
        this.gia = gia;
        this.image = image;
        this.type = type;
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "MenuOrderCategoryCustom{" +
                "id=" + id +
                ", tenSp='" + tenSp + '\'' +
                ", gia=" + gia +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                ", idCategory=" + idCategory +
                '}';
    }
}
