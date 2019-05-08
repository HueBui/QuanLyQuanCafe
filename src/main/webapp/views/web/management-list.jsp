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
                <th scope="col" style="text-align: center">STT</th>
                <th scope="col" style="text-align: center">Tên Sản Phẩm</th>
                <th scope="col" style="text-align: center">Số Lượng</th>
                <th scope="col" style="text-align: center">Đơn Giá</th>
                <th scope="col" style="text-align: center">Tổng Tiền</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="bst" items="${bookingSanPhamTable}" varStatus="loop">

                <tr>
                    <th style="text-align: center">${loop.index+1}</th>
                    </th>
                    <td>${bst.tenSp}</td>
                    <td style="text-align: center">${bst.soLuong}</td>
                    <td style="text-align: center">${bst.gia}</td>
                    <td style="text-align: center">${bst.gia * bst.soLuong}</td>
                </tr>
                    <input type="hidden" value="${idTable}" name="idTable" id="tableId">
                <input type="hidden" value="${bst.id}" id="idbooking"></input>
            </c:forEach>
            </tbody>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td align="center">Tổng:</td>
                <td align="center">${tongTien}</td>
                <input type="hidden" id="totalPrice" value="${tongTien}"/>

            </tr>
        </table>
        <button type="button" class="btn btn-success" id="btnThanhToan">Thanh Toán</button>

    </div>
</section>
</body>
</html>
