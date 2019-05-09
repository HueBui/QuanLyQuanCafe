<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>Chart</title>

</head>
<body>
<div>

    <canvas id="line-chart" width="1000" height="450"></canvas>

</div>
<script>


    var list_date =<c:out value="${listDateBillString}" />
    var list_total =<c:out value="${listTotalInt}" />

    new Chart(document.getElementById("line-chart"), {
        type: 'line',
        data: {
            labels: list_date,
            datasets: [
                {
                    label: 'Doanh số',
                    data: list_total,
                    backgroundColor: 'rgba(0, 128, 128, 0.7)',
                    borderColor: 'rgba(0, 128, 128, 1)',
                    borderWidth: 1
                }
                // ,
                // {
                //     label: 'Nguyên liệu',
                //     data: [0, 0, 0, 0],
                //     backgroundColor: 'rgba(0, 128, 128, 0.7)',
                //     borderColor: 'rgba(0, 128, 128, 1)',
                //     borderWidth: 1
                // }
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