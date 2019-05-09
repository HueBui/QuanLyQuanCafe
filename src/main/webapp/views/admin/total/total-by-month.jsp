<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thống kê theo ngày</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="header">
                        <div class="col-md-4">
                            <h3 class="title"><b>Chọn khoảng ngày: </b></h3>
                        </div>
                        <div class="col-md-4">
                            <h3 class="title"><b>From </b></h3>
                            <input id="input1"  width="312" name="ngayNhap" value=""/>
                        </div>
                        <div class="col-md-4">
                            <h3 class="title"><b>To </b></h3>
                            <input id="input2" width="312" name="ngayNhap" value=""/>
                        </div>
                        <button class="btn btn-primary" id="btnThongKe">Tìm</button>
                        <h3 class="title"><b>Doanh thu: ${tongTien} </b></h3>
                    </div>
                    <div class="header">
                        <p>Danh sách sản phẩm bán</p>
                    </div>
                    <div class="content table-responsive table-full-width">
                        <table class="table table-striped">
                            <thead>
                            <th>STT</th>
                            <th>Tên Sản Phẩm</th>
                            <th>Số Lượng</th>
                            <th>Đơn Giá</th>
                            <th>Tổng Tiền</th>
                            </thead>
                            <tbody>
                            <c:forEach var="tbl" items="${listbill}" varStatus="loop">
                                <tr>
                                    <th style="text-align: center">${loop.index+1}</th>
                                    <td>${tbl.tenSp}</td>
                                    <td>${tbl.soLuong}</td>
                                    <td>${tbl.gia}</td>
                                    <td>${tbl.gia*tbl.soLuong}</td>
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

<script>
    $('#input1').datetimepicker({ footer: true, modal: true });
    $('#input2').datetimepicker({ footer: true, modal: true });
</script>
</body>

