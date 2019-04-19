<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title">Nguyên Liệu</h4>
                        <p class="category">Danh sách nguyên liệu</p>
                    </div>
                    <div class="header">
                        <a class="ti-trash" href="#"> Thêm</a>
                        <a class="ti-trash" href="#"> Sửa</a>
                        <a class="ti-pencil" href="#"> Xóa</a>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                            <th><input type="checkbox"></th>
                            <th>STT</th>
                            <th>Tên Nguyên Liệu</th>
                            <th>Số Lượng</th>
                            <th>Hình Ảnh</th>
                            <th>Ngày nhập</th>
                            <th>Giá</th>
                            <th class="ti-settings">Thao Tác</th>
                            </thead>
                            <tbody>
                            <c:forEach var="n" items="${nguyenLieuModels}">
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>${n.id}</td>
                                    <td>${n.name}</td>
                                    <td>${n.quantity}</td>
                                    <td>${n.image}</td>
                                    <td>${n.ngayNhap}</td>
                                    <td>${n.price}</td>
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

