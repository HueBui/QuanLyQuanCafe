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
                        <h4 class="title"><b>Sản phẩm</b></h4>
                        <p class="category">Danh sách sản phẩm</p>
                    </div>
                    <div class="header">
                        <button class="ti-trash" id="btnDeleteMenu" disabled >Xóa</button>
                        <a class="ti-pencil" href="<c:url value="/admin-edit-menu?action=edit"/>"> Thêm mới</a>

                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                            <th><input type="checkbox" id="checkAll"></th>
                            <th style="font-family: initial; color: black;"><b>STT</b></th>
                            <th style="font-family: initial; color: black;"><b>Tên Sản Phẩm</b></th>
                            <th style="font-family: initial; color: black;"><b>Hình ảnh</b></th>
                            <th style="font-family: initial; color: black;"><b>Giá</b></th>
                            <th style="font-family: initial; color: black;"><b>Thể loại</b></th>
                            <th class="ti-settings"><b>Thao Tác</b>c</th>
                            </thead>
                            <tbody>
                            <c:forEach var="m" items="${menuModel}">
                            <tr>
                                <td><input type="checkbox"></td>
                                <td style="font-family: initial; color: black;font-size: 18px;">${m.id}</td>
                                <td style="font-family: initial; color: black;font-size: 18px;">${m.tenSp}</td>
                                <td><c:set var="image" value="/repository/${m.image}"/>
                                <img src="${image}" id="viewImage" width="70px"
                                height="70px">
                                </td>
                                <td style="font-family: initial; color: black;font-size: 18px;">${m.gia}</td>
                                <td style="font-family: initial; color: black;font-size: 18px;">${m.type}</td>
                                <td style="font-family: initial; color: black;font-size: 18px;">
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

