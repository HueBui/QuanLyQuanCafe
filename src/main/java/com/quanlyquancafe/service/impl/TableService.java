package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.impl.TableDAO;
import com.quanlyquancafe.model.TableModel;
import com.quanlyquancafe.service.ITableService;

import java.util.List;

public class TableService implements ITableService {
    @Override
    public List<TableModel> getAll() {
        TableDAO dao = new TableDAO();
        List<TableModel> list = dao.getAll();
        return list;
    }
}
