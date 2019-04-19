package com.quanlyquancafe.dao;

import com.quanlyquancafe.mapper.RowMapper;

import java.util.List;

public interface GenericDAO <T>{
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    boolean update (String sql, Object... parameters);
    Long insert (String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
