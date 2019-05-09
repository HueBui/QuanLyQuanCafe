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
                        <h4 class="title"><b>Bàn</b></h4>
                        <p class="category">Danh sách bàn</p>
                    </div>
                    <div class="header">
                        <button class="ti-trash" id="btnDeleteTable" disabled >Xóa</button>
                        <a class="ti-pencil" href="<c:url value="/admin-edit-table?action=edit"/>"> Thêm mới</a>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                            <th><input type="checkbox" id="checkAll"></th>
                            <th style="font-family: initial; color: black;"><b>STT</b></th>
                            <th style="font-family: initial; color: black;"><b>Tên Bàn</b></th>
                            <th style="font-family: initial; color: black;"><b>Hình ảnh</b></th>
                            <th style="font-family: initial; color: black;"><b>Type</b></th>
                            <th style="font-family: initial; color: black;"><b>Số lượng ghế</b></th>
                            <th style="font-family: initial; color: black;"><b>Trạng thái</b></th>
                            <th style="font-family: initial; color: black;"><b>Ghi chú</b></th>
                            <th class="ti-settings"><b>Thao Tác</b></th>
                            </thead>
                            <tbody>
                            <c:forEach var="tbl" items="${tableList}">
                                <tr>
                                    <td><input type="checkbox" id="checkbox_${tbl.id}" value="${tbl.id}"></td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${tbl.id}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${tbl.name}</td>
                                    <td><c:set var="image" value="/repository/${tbl.image}"/>
                                        <img src="${image}" id="viewImage" width="70px"
                                             height="70px">
                                    </td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${tbl.typeTable}</td>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${tbl.soLuongGhe}</td>
                                    <c:if test="${tbl.status==0}">
                                        <td style="font-family: initial; color: black;font-size: 18px;">Chưa đặt</td>
                                    </c:if>
                                    <c:if test="${tbl.status==1}">
                                        <td style="font-family: initial; color: black;font-size: 18px;">Đang đặt</td>
                                    </c:if>
                                    <td style="font-family: initial; color: black;font-size: 18px;">${tbl.ghiChu}</td>
                                    <td style="font-family: initial; color: black;font-size: 16px;">
                                        <a class="ti-pencil" href="<c:url value="/admin-edit-table?action=edit&id=${tbl.id}"/>"> Sửa </a>
                                        <%--<a class="ti-eye" href="#">Xem Trước</a>--%>

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

