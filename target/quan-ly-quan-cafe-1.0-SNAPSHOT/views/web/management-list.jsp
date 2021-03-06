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
                <th scope="col" style="font-size: 17px;color: black;font-style: inherit;text-align: center">STT</th>
                <th scope="col" style="font-size: 17px;color: black;font-style: inherit;text-align: center">Tên Sản Phẩm</th>
                <th scope="col" style="font-size: 17px;color: black;font-style: inherit;text-align: center">Số Lượng</th>
                <th scope="col" style="font-size: 17px;color: black;font-style: inherit;text-align: center">Đơn Giá</th>
                <th scope="col" style="font-size: 17px;color: black;font-style: inherit;text-align: center">Tổng Tiền</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="bst" items="${bookingSanPhamTable}" varStatus="loop">

                <tr>
                    <th style="font-size: 17px;color: black;font-style: inherit;text-align: center">${loop.index+1}</th>
                    </th>
                    <td style="font-size: 17px;color: black;font-style: inherit;">${bst.tenSp}</td>
                    <td style="font-size: 17px;color: black;font-style: inherit;text-align: center">${bst.soLuong}</td>
                    <td style="font-size: 17px;color: black;font-style: inherit;text-align: center">${bst.gia}</td>
                    <td style="font-size: 17px;color: black;font-style: inherit;text-align: center">${bst.gia * bst.soLuong}</td>
                </tr>
                    <input type="hidden" value="${idTable}" name="idTable" id="tableId">
                <input type="hidden" value="${bst.id}" id="idbooking"></input>
            </c:forEach>
            </tbody>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td align="center" style="font-size: 17px;color: black;font-style: inherit;">Tổng:</td>
                <td align="center" style="font-size: 17px;color: black;font-style: inherit;">${tongTien}</td>
                <input type="hidden" id="totalPrice" value="${tongTien}"/>

            </tr>
        </table>
        <button type="button" class="btn btn-success" id="btnThanhToan" style="border-radius: 35px">Thanh Toán</button>

    </div>
</section>
</body>
</html>
