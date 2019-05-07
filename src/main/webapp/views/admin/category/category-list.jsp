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
                        <h4 class="title">Danh Mục</h4>
                        <p class="category">Bảng danh sách các danh mục trong hệ thống</p>
                    </div>
                    <div class="header">
                        <button class="ti-trash" id="btnDeleteDanhMuc" disabled >Xóa</button>
                        <a class="ti-pencil" href='<c:url value="/admin-edit-category?action=edit"/>'> Thêm mới</a>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped" border="0">
                            <thead>
                            <th><input type="checkbox" id="checkAll"></th>
                            <th>ID</th>
                            <th>Type</th>
                            <th>Image</th>
                            <th class="ti-settings"> Thao Tác</th>
                            </thead>
                            <tbody>
                            <c:forEach var="ct" items="${categoryModels}">
                                <tr id="tr_${ct.id}">
                                    <td><input type="checkbox" id="checkbox_${ct.id}" value="${ct.id}"></td>
                                    <td>${ct.id}</td>
                                    <td>${ct.type}</td>
                                    <td><c:set var="image" value="/repository/${ct.image}"/>
                                        <img src="${image}" id="viewImage" width="70px"
                                             height="70px">
                                    </td>
                                    <td>
                                            <%--<a class="ti-eye" href="#"> Xem Trang Cá Nhân</a>--%>
                                        <a class="ti-pencil" href="<c:url value="/admin-edit-category?action=edit&userId=${ct.id}"/>"> Sửa </a>
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

