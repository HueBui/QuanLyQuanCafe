<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List menu</title>
</head>
<body>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title">Sản phẩm</h4>
                        <p class="category">Danh sách sản phẩm</p>
                    </div>
                    <div class="header">
                        <a class="ti-pencil" href="<c:url value="/admin-edit-menu?action=edit"/>"> Thêm</a>
                        <button class="ti-trash" id="btnDeleteMenu" disabled >Xóa</button>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                            <th><input type="checkbox" id="checkAll"></th>
                            <th>STT</th>
                            <th>Tên Sản Phẩm</th>
                            <th>Hình ảnh</th>
                            <th>Giá</th>
                            <th>Thể loại</th>
                            <th class="ti-settings">Thao Tác</th>
                            </thead>
                            <tbody>
                            <c:forEach var="m" items="${menuModel}">
                            <tr>
                                <td><input type="checkbox"></td>
                                <td>${m.id}</td>
                                <td>${m.tenSp}</td>
                                <td><c:set var="image" value="/repository/${m.image}"/>
                                <img src="${image}" id="viewImage" width="70px"
                                height="70px">
                                </td>
                                <td>${m.gia}</td>
                                <td>${m.type}</td>
                                <td>
                                    <a class="ti-pencil" href="<c:url value="/admin-edit-menu?action=edit&id=${m.id}"/>"> Sửa </a>
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

