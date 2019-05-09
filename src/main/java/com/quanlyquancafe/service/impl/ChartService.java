package com.quanlyquancafe.service.impl;

import com.quanlyquancafe.dao.impl.ChartDAO;
import com.quanlyquancafe.model.custom.CountCustom;
import com.quanlyquancafe.model.custom.DateCustom;

import java.util.List;

public class ChartService {
    public List<DateCustom> getAllDateBill(){
        ChartDAO chartDAO = new ChartDAO();

        return chartDAO.getAllDateBill();
    }

    public List<CountCustom> getAllTotal(){
        ChartDAO chartDAO = new ChartDAO();

        return chartDAO.getTotal();
    }
}
