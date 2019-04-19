<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title><dec:title default="Trang chủ" /></title>
    <!-- Title -->
    <title>| Home</title>

    <!-- Bootstrap core CSS     -->
    <link href="/template/admin/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="/template/admin/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="/template/admin/css/paper-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="/template/admin/css/demo.css" rel="stylesheet" />


    <!--  Fonts and icons     -->
    <%--<link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">--%>
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="/template/admin/css/themify-icons.css" rel="stylesheet">

</head>
<body>
<div class="wrapper">
    <%@ include file="/common/admin/menu.jsp" %>
    <div class="main-panel">
        <%@ include file="/common/admin/header.jsp" %>
        <div class="content">
            <dec:body/>
        </div>
        <%@ include file="/common/admin/footer.jsp" %>
    </div>
</div>
</body>
<!--   Core JS Files   -->
<script src="/template/admin/js/jquery.min.js" type="text/javascript"></script>
<script src="/template/admin/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="/template/admin/js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="/template/admin/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="/template/admin/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="/template/admin/js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="/template/admin/js/demo.js"></script>

<%--<script type="text/javascript">
    $(document).ready(function(){

        demo.initChartist();

        $.notify({
            icon: 'ti-gift',
            message: "Welcome to <b>Paper Dashboard</b> - a beautiful Bootstrap freebie for your next project."

        },{
            type: 'success',
            timer: 4000
        });

    });
</script>--%>
</html>