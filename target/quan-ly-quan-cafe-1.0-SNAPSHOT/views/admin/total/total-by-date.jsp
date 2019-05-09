<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thống kê theo ngày</title>
</head>
<body>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h3 class="title"><b>Doanh thu trong ngày hôm nay: ${tongTien} </b></h3>
                    </div>
                    <div class="header">
                        <p>Danh sách sản phẩm bán trong ngày hôm nay</p>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                            <th><b>STT</b></th>
                            <th><b>Tên Sản Phẩm</b></th>
                            <th><b>Số Lượng</b></th>
                            <th><b>Đơn Giá</b></th>
                            <th><b>Tổng Tiền</b></th>
                            </thead>
                            <tbody>
                            <c:forEach var="tbl" items="${listbill}" varStatus="loop">
                                <tr>
                                    <th style="text-align: center">${loop.index+1}</th>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${tbl.tenSp}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${tbl.soLuong}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${tbl.gia}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${tbl.gia*tbl.soLuong}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

