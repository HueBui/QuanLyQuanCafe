<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List công thức</title>
</head>
<body>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <h4 class="title"><b>Công Thức</b></h4>
                        <p class="category">Danh sách công thức</p>
                    </div>
                    <div class="header">
                        <%--<button class="ti-trash" id="btnDeleteMenu" disabled >Xóa</button>--%>
                        <%--<a class="ti-pencil" href="<c:url value="/admin-edit-menu?action=edit"/>"> Thêm mới</a>--%>

                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                            <th><input type="checkbox" id="checkAll"></th>
                            <th style="font-family: initial; color: black;"><b>Tên Sản Phẩm</b></th>
                            <th style="font-family: initial; color: black;"><b>Tên Nguyên Liệu</b></th>
                            <th style="font-family: initial; color: black;"><b>Khối Lượng</b></th>
                            <%--<th class="ti-settings">Thao Tác</th>--%>
                            </thead>
                            <tbody>
                            <c:forEach var="ctc" items="${congThucCustoms}">
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <td style="font-family: initial; color: black;font-size: 18px;">${ctc.tenSanPham}</td>
                                        <td style="font-family: initial; color: black;font-size: 18px;">${ctc.tenNguyenLieu}</td>
                                        <td style="font-family: initial; color: black;font-size: 18px;">${ctc.khoiLuong}</td>
                                            <%--<td>--%>
                                            <%--<a class="ti-pencil" href="<c:url value="/admin-edit-menu?action=edit&id=${m.id}"/>"> Sửa </a>--%>
                                            <%--</td>--%>
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

