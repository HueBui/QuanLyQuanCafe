package com.quanlyquancafe.service;

import com.quanlyquancafe.model.TableModel;

import java.util.List;

public interface ITableService {
    List<TableModel> getAll();
    Long saveInforTable(TableModel tableModel);

    boolean update(TableModel tableModel);

     void delete(long[] ids);

    TableModel  findOne(Long id);

    boolean updateStatusTable(Long idTable, Integer status);
}
