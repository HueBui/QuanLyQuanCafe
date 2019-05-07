package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.ITableDAO;
import com.quanlyquancafe.dao.impl.TableDAO;
import com.quanlyquancafe.model.TableModel;
import com.quanlyquancafe.service.ITableService;

import java.util.List;

public class TableService implements ITableService {
    private ITableDAO tableDAO;

    public TableService() {
        tableDAO = new TableDAO();
    }

    @Override
    public List<TableModel> getAll() {
        TableDAO dao = new TableDAO();
        List<TableModel> list = dao.getAll();
        return list;
    }

    @Override
    public Long saveInforTable(TableModel tableModel) {
        return tableDAO.saveInforTable(tableModel);
    }

    @Override
    public boolean update(TableModel tableModel) {
        return tableDAO.update(tableModel);
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            tableDAO.delete(id);
        }
    }

    @Override
    public TableModel findOne(Long id) {
        return tableDAO.findOne(id);
    }

    @Override
    public boolean updateStatusTable(Long idTable, Integer status) {
        return tableDAO.updateTableStatus(idTable,status);
    }
}
