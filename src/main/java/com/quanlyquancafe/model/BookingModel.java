package com.quanlyquancafe.model;

import java.sql.Timestamp;

public class BookingModel extends AbstractModel<BookingModel> {
    private Double totalPrice;
    private Integer status;
    private Timestamp createTime;
    private Long createBy;

    public BookingModel() {
    }

    public BookingModel(Double totalPrice, Integer status, Timestamp createTime, Long createBy) {
        this.totalPrice = totalPrice;
        this.status = status;
        this.createTime = createTime;
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "BookingModel{" +
                "totalPrice=" + totalPrice +
                ", status=" + status +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                '}';
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
}
