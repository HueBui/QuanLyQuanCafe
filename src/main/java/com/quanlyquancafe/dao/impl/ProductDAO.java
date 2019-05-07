package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.IProductDAO;
import com.quanlyquancafe.mapper.ProductCategoryMapper;
import com.quanlyquancafe.mapper.ProductMapper;
import com.quanlyquancafe.model.ProductModel;
import com.quanlyquancafe.model.custom.ProductCategoryCustom;

import java.util.List;


public class ProductDAO extends AbstractDAO<ProductCategoryCustom> implements IProductDAO {

    @Override
    public List<ProductCategoryCustom> getAllProduct() {
        String sql = "SELECT c.id as idcategory, s.image, s.id,s.tensp,s.gia, c.type FROM sanpham s inner join category c on s.idcategory = c.id where s.status =1 " +
                " order by c.id";
        List<ProductCategoryCustom> menu = query(sql, new ProductCategoryMapper());
        return menu;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM sanpham WHERE id = ?";
        update(sql, id);
    }

    @Override
    public Long saveProduct(ProductModel productModel) {
        String sql = "INSERT INTO sanpham (tensp,gia,image,status,idcategory)" +
                " VALUES('" + productModel.getName() + "', '" + productModel.getPrice() + "','" + productModel.getImage() + "', '" + 1 + "', '" + productModel.getIdCategory() + "')";
        return insert(sql);
    }

    @Override
    public boolean update(ProductModel productModel) {
        StringBuilder sql = new StringBuilder("UPDATE sanpham SET tensp = ?, gia = ?,");
        sql.append(" image = ?, status = ?, idcategory = ? WHERE id = ?");

        return update(sql.toString(), productModel.getName(), productModel.getPrice(), productModel.getImage(),
                productModel.getImage(), 1,productModel.getImage(),productModel.getId());
    }

    @Override
    public List<ProductModel> listAllProduct() {
        String sql = "SELECT * From sanpham";
        List<ProductModel> productModels = query(sql, new ProductMapper());
        return productModels;
    }

    @Override
    public ProductModel findOne(long id) {
        String sql="select * from sanpham where id=?";
        List<ProductModel> productModels = query(sql, new ProductMapper(), id);
        return productModels.isEmpty() ? null : productModels.get(0);
    }
}
