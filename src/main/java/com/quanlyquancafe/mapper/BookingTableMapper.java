package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.custom.BookingTableCustom;

import java.sql.ResultSet;

public class BookingTableMapper implements RowMapper<BookingTableCustom> {
    @Override
    public BookingTableCustom mapRow(ResultSet resultSet) {
        BookingTableCustom bookingTableCustom = new BookingTableCustom();
        try {
            bookingTableCustom.setIdTable(resultSet.getLong("id"));
            bookingTableCustom.setNameTable(resultSet.getString("name"));
        }catch (Exception e){
           e.printStackTrace();
        }
        return bookingTableCustom;
    }
}
