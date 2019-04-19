package com.quanlyquancafe.dao;

import com.quanlyquancafe.model.TableModel;
import com.quanlyquancafe.model.custom.BookingTableCustom;

import java.util.List;

public interface ITableDAO {
    List<TableModel> getAll();

    List<BookingTableCustom> getTable();
}
