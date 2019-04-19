package com.quanlyquancafe.dao.impl;

import com.quanlyquancafe.dao.ICongThucDAO;
import com.quanlyquancafe.mapper.CongThucMapper;
import com.quanlyquancafe.model.CongThucModel;

import java.util.List;

public class CongThucDAO extends AbstractDAO<CongThucModel> implements ICongThucDAO {

    @Override
    public List<CongThucModel> getInforCongThucByIdSanPham(Integer idSanPham) {
        String sql = "SELECT  * FROM congthuc c " +
                "inner join sanpham s on s.id=c.idsanpham " +
                "inner join nguyenlieu sn on sn.id=c.idsanpham " +
                "where s.id='"+idSanPham+"'";
        List<CongThucModel> list = query(sql,new CongThucMapper());
        return list;
    }
}
