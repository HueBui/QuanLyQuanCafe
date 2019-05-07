package com.quanlyquancafe.model;

public class CategoryModel extends AbstractModel<CategoryModel> {
    private Long id;
    private String type;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public CategoryModel(Long id, String type, String image) {
        this.id = id;
        this.type = type;
        this.image = image;
    }

    public CategoryModel() {
    }
}
