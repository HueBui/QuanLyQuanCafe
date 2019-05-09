<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Chart</title>

</head>
<body>
<div>
    <canvas id="line-chart" width="1000" height="450"></canvas>
    <input id="idtabel"  value="${demo}" type="hidden">
</div>
<script>

    var f = document.getElementById("idtabel").value;

    alert(f);
    new Chart(document.getElementById("line-chart"), {
        type: 'line',
        data: {
            labels: [f,"21-12-2019","21-12-2019","21-12-2019","21-12-2019","21-12-2019","21-12-2019"], // lấy mảng ngày
            datasets: [
            {
                data: [0,350,411,502,635,809,947,1402,3700,5267],
                label: "Doanh Số",
                borderColor: "#8e5ea2",
                fill: false
            }, {
                data: [0,7000,178,190,203,276,408,547,675,734],
                label: "Nguyên Liệu",
                borderColor: "#3cba9f",
                fill: false
            }
            ]
        },
        options: {
            title: {
                display: true,
                text: 'Thống kê doanh thu theo ngày'
            }
        }
    });
</script>
</body>

</html>