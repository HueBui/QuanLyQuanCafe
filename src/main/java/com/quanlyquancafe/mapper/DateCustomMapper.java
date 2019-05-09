package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.custom.DateCustom;

import java.sql.ResultSet;

public class DateCustomMapper implements RowMapper<DateCustom > {
    @Override
    public DateCustom mapRow(ResultSet resultSet) {
        DateCustom dateCustom = new DateCustom();
        try {
            dateCustom.setDate(resultSet.getString("date_time"));
        }catch (Exception e){
            System.out.println("Loi "+this.getClass()+e);
        }
        return dateCustom;
    }
}
