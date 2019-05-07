package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.impl.TableDAO;
import com.quanlyquancafe.model.custom.BookingTableCustom;
import com.quanlyquancafe.service.IManagementService;

import java.util.List;

public class ManagementService implements IManagementService {
    @Override
    public List<BookingTableCustom> getTable() {
        TableDAO dao = new TableDAO();
        return dao.getTable();
    }
}
