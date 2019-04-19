<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Management</title>
</head>

<body>
<section id="portfolio-classic-3col" class="landing-demos portfolio portfolio-classic portfolio-3col bg-white">
    <div class="container">

        <table class="table table-striped" border="1">
            <thead>
            <tr>
                <th><input type="checkbox" id="checkAll"></th>
                <th scope="col" style="text-align: center">Tên Sản Phẩm</th>
                <th scope="col" style="text-align: center">Số Lượng</th>
                <th scope="col" style="text-align: center">Giá</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="bst" items="${bookingSanPhamTable}">

                <tr>
                    <th><input type="checkbox" id="checkbox_${bts.id}" value="${bts.id}"></th>
                    </th>
                    <td style="text-align: center">${bst.tenSp}</td>
                    <td style="text-align: center">${bst.soLuong}</td>
                    <td style="text-align: center">${bst.gia}</td>
                </tr>
                <input type="hidden" value="${idTable}" name="idTable">
            </c:forEach>
            </tbody>
            <tr>
                <td></td>
                <td></td>
                <td>Tổng:</td>
                <td>${tongTien}</td>
            </tr>
        </table>
        <button type="button" class="btn btn-success" id="btnThanhToan">Thanh Toán</button>
    </div>
</section>
</body>
</html>
