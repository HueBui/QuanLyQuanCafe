<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quản lý nhân viên</title>
</head>
<body>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title">NHÂN VIÊN</h4>
                        <p class="category">Bảng danh sách các nhân viên trong hệ thống</p>
                    </div>
                    <div class="header">
                        <button class="ti-trash" id="btnDeleteUser" disabled >Xóa</button>
                        <a class="ti-pencil" href='<c:url value="/admin-edit-account?action=edit"/>'> Thêm mới</a>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                            <th><input type="checkbox"></th>
                            <th>ID</th>
                            <th>Họ Tên</th>
                            <th>Email</th>
                            <th>UserName</th>
                            <th>SĐT</th>
                            <th>CMTND</th>
                            <th>Địa chỉ</th>
                            <th>Hình ảnh</th>
                            <th class="ti-settings"> Thao Tác</th>
                            </thead>
                            <tbody>
                            <c:forEach var="u" items="${userModel}">
                                <tr>
                                    <td><input type="checkbox" id="checkbox_${u.id}" value="${u.id}"></td>
                                    <td>${u.id}</td>
                                    <td>${u.fullName}</td>
                                    <td>${u.email}</td>
                                    <td>${u.userName}</td>
                                    <td>${u.phone}</td>
                                    <td>${u.cmtnd}</td>
                                    <td>${u.address}</td>
                                    <td>${u.image}</td>
                                    <td>
                                        <a class="ti-eye" href="#"> Xem Trang Cá Nhân</a>
                                        <a class="ti-pencil" href="<c:url value="/admin-edit-account?action=edit&userId=${u.id}"/>"> Sửa </a>
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

