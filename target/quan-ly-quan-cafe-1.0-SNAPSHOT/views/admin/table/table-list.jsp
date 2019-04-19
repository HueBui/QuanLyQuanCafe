<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List table</title>
</head>
<body>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title">Table</h4>
                        <p class="category">Danh sách table</p>
                    </div>
                    <div class="header">
                        <a class="ti-pencil" href="#"> Thêm</a>
                        <a class="ti-trash" href="#"> Sửa</a>
                        <a class="ti-pencil" href="#"> Xóa</a>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                            <th><input type="checkbox"></th>
                            <th>STT</th>
                            <th>Tên Bàn</th>
                            <th>Hình ảnh</th>
                            <th>Type</th>
                            <th>Số lượng ghế</th>
                            <th>Trạng thái</th>
                            <th>Ghi chú</th>
                            <th class="ti-settings">Thao Tác</th>
                            </thead>
                            <tbody>
                            <c:forEach var="tbl" items="${tableList}">
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>${tbl.id}</td>
                                    <td>${tbl.name}</td>
                                    <td>${tbl.image}</td>
                                    <td>${tbl.typeTable}</td>
                                    <td>${tbl.soLuongGhe}</td>
                                    <td>${tbl.status}</td>
                                    <td>${tbl.ghiChu}</td>
                                    <td>
                                        <a class="ti-eye" href="#">Xem Trước</a>
                                    </td>
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

