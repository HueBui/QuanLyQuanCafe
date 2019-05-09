package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.BookingModel;

import java.sql.ResultSet;

public class BookingMapper implements RowMapper<BookingModel> {
    @Override
    public BookingModel mapRow(ResultSet resultSet) {
        BookingModel model = new BookingModel();
        try {
            model.setId(resultSet.getLong("id"));
            model.setStatus(resultSet.getInt("status"));
            model.setTotalPrice(resultSet.getDouble("total"));
            model.setCreateBy(resultSet.getLong("create_by"));
            model.setCreateTime(resultSet.getTimestamp("create_time"));
        } catch (Exception e) {
            System.out.println("Loi mapper class: "+this.getClass() +e);
        }
        return model;
    }
}
