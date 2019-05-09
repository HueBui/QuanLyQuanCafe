package com.quanlyquancafe.mapper;

import com.quanlyquancafe.model.custom.CountCustom;

import java.sql.ResultSet;

public class CountMapper implements RowMapper<CountCustom> {
    @Override
    public CountCustom mapRow(ResultSet resultSet) {
        CountCustom countCustom = new CountCustom();
        try {
            countCustom.setCount(resultSet.getInt("count"));
        }catch (Exception e){
            System.out.println("Loi mapper class: "+this.getClass() +e);
        }
        return countCustom;
    }
}
