package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.INguyenLieuDAO;
import com.quanlyquancafe.mapper.NguyenLieuMapper;
import com.quanlyquancafe.mapper.SanPhamNguyenLieuKhoiLuongMapper;
import com.quanlyquancafe.model.CategoryModel;
import com.quanlyquancafe.model.NguyenLieuModel;
import com.quanlyquancafe.model.custom.SanPhamNguyenLieuCongThucCustom;

import java.util.List;

public class NguyenLieuDAO extends AbstractDAO<NguyenLieuModel> implements INguyenLieuDAO  {
    @Override
    public List<NguyenLieuModel> listAll() {
        String sql = "select*from nguyenlieu";
        List<NguyenLieuModel> nguyenLieu = query(sql,new NguyenLieuMapper());
        return nguyenLieu;
    }
    @Override
    public boolean update(NguyenLieuModel nguyenLieuModel) {
        StringBuilder sql = new StringBuilder("UPDATE nguyenlieu SET name = ?, quantity = ?,");
        sql.append(" image = ?, price = ?, ngaynhap = ? WHERE id = ?");

        return update(sql.toString(), nguyenLieuModel.getName(), nguyenLieuModel.getQuantity(), nguyenLieuModel.getImage(),
                nguyenLieuModel.getPrice(), nguyenLieuModel.getNgayNhap(),nguyenLieuModel.getId());
    }

    @Override
    public boolean updateQuantity(Double quantity, Long id) {
        StringBuilder sql = new StringBuilder("UPDATE nguyenlieu SET  quantity = quantity - '"+quantity+"' WHERE id = '"+id+"'");

        return update(sql.toString());
    }

    @Override
    public List<SanPhamNguyenLieuCongThucCustom> listKhoiLuong(Integer idSanPham) {
        String sql = "SELECT ct.khoiluong, nl.quantity" +
                " FROM nguyenlieu nl inner join congthuc ct on nl.id = ct.idnguyenlieu" +
                " inner join sanpham sp on sp.id = ct.idsanpham" +
                " where sp.id ='"+idSanPham+"'";
        List<SanPhamNguyenLieuCongThucCustom> listKhoiLuong =query(sql,new SanPhamNguyenLieuKhoiLuongMapper());

        return listKhoiLuong;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM nguyenlieu WHERE id = ?";
        update(sql,id);
    }

    @Override
    public Long saveInforNguyenLieu(NguyenLieuModel nguyenLieuModel) {
        String sql = "INSERT INTO nguyenlieu (name,quantity,image,price,ngaynhap)"+
                " VALUES('"+ nguyenLieuModel.getName()+"', '"+nguyenLieuModel.getQuantity()+"', '"+nguyenLieuModel.getImage()+"', '"+nguyenLieuModel.getPrice()+"', '"+nguyenLieuModel.getNgayNhap()+"')";
        return insert(sql);
    }

    @Override
    public NguyenLieuModel findOne(Long id) {
        String sql = "SELECT * FROM nguyenlieu WHERE id = ?";
        List<NguyenLieuModel> nguyenLieuModels = query(sql, new NguyenLieuMapper(), id);
        return nguyenLieuModels.isEmpty() ? null : nguyenLieuModels.get(0);
    }
}
