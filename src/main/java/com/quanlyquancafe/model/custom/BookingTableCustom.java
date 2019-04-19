package com.quanlyquancafe.model.custom;

public class BookingTableCustom {
    private Long idTable;
    private String nameTable;

    public BookingTableCustom() {
    }

    public BookingTableCustom(Long idTable, String nameTable) {
        this.idTable = idTable;
        this.nameTable = nameTable;
    }

    @Override
    public String toString() {
        return "BookingTableCustom{" +
                "idTable=" + idTable +
                ", nameTable='" + nameTable + '\'' +
                '}';
    }

    public Long getIdTable() {
        return idTable;
    }

    public void setIdTable(Long idTable) {
        this.idTable = idTable;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }
}
