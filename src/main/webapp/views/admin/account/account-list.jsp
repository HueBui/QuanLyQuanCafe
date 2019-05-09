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
<%--<span style="color: red; font-size: 25px;margin-left: 10px">${msg}</span>--%>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title"><b>NHÂN VIÊN</b></h4>
                        <p class="category">Bảng danh sách các nhân viên trong hệ thống</p>
                    </div>
                    <div class="header">
                        <button class="ti-trash" id="btnDeleteUser" disabled >Xóa</button>
                        <a class="ti-pencil" href='<c:url value="/admin-edit-account?action=edit"/>'> Thêm mới</a>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped" border="0">
                            <thead>
                            <th><input type="checkbox" id="checkAll"></th>
                            <th style="font-family: initial; color: black;"><b>ID</b></th>
                            <th style="font-family: initial; color: black;"><b>Họ Tên</b></th>
                            <th style="font-family: initial; color: black;"><b>Email</b></th>
                            <th style="font-family: initial; color: black;"><b>UserName</b></th>
                            <th style="font-family: initial; color: black;"><b>SĐT</b></th>
                            <th style="font-family: initial; color: black;"><b>CMTND</b></th>
                            <th style="font-family: initial; color: black;"><b>Địa chỉ</b></th>
                            <th style="font-family: initial; color: black;"><b>Hình ảnh</b></th>
                            <th class="ti-settings"> <b>Thao Tác</b></th>
                            </thead>
                            <tbody>
                            <c:forEach var="u" items="${userModel}">
                                <tr id="tr_${u.id}">
                                    <td><input type="checkbox" id="checkbox_${u.id}" value="${u.id}"></td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${u.id}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${u.fullName}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;"> ${u.email}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${u.userName}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${u.phone}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${u.cmtnd}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${u.address}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;"><c:set var="image" value="/repository/${u.image}"/>
                                    <img src="${image}" id="viewImage" width="70px"
                                         height="70px">
                                    </td>
                                    <td>
                                        <%--<a class="ti-eye" href="#"> Xem Trang Cá Nhân</a>--%>
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

