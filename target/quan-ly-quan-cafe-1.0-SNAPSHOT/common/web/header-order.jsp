<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<head>
    <!-- Document Meta
    ============================================= -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--IE Compatibility Meta-->
    <meta name="author" content="zytheme" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="Elegant Restaurant & Cafe Html5 Template">
    <link href="assets/images/favicon/favicon.png" rel="icon">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/template/web/assets/thuvien/css/jquery.toast.css">
    <!-- Fonts
    ============================================= -->
    <link href="http://fonts.googleapis.com/css?family=Great+Vibes%7CKaushan+Script%7CRaleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" type="text/css">

    <!-- Stylesheets
    ============================================= -->
    <link href="assets/css/external.css" rel="stylesheet">
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    <title></title>
</head>

<body>
<div class="preloader">
    <div class="spinner">
        <div class="bounce1"></div>
        <div class="bounce2"></div>
        <div class="bounce3"></div>
    </div>
</div>
<!-- Document Wrapper
============================================= -->
<div id="wrapper" class="wrapper clearfix">
    <header id="navbar-spy" class="header header-10 header-2 header-transparent header-centered header-fixed">
        <div id="logo-centered" class="logo-centered">
            <div class="container">
                <div class="row">
                </div>
            </div>
        </div>
        <nav id="primary-menu" class="navbar navbar-fixed-top">
            <div class="container">
                <div class="">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="logo hidden-lg hidden-md" href="index.html">
                            <img class="logo-light" src="/template/web/assets/images/logo/logo-light.png" alt="granny Logo">
                            <img class="logo-dark" src="/template/web/assets/images/logo/logo-dark.png" alt="granny Logo">
                        </a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbar-collapse-1">
                        <ul class="nav navbar-nav nav-pos-right navbar-left">
                            <!-- Home Menu -->
                            <li class="has-dropdown mega-dropdown active">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle menu-item">home</a>
                            </li>
                            <!-- li end -->

                            <!-- About Menu -->
                            <li class="has-dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle menu-item">About</a>
                            </li>
                            <!-- li end -->

                            <!-- Menu Menu -->
                            <li class="has-dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle menu-item">Menu</a>
                            </li>
                            <!-- li end -->

                            <!-- Features Menu-->
                            <li class="has-dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle menu-item">features</a>
                            </li>
                            <!-- li end -->

                            <li>
                                <a class="menu-item" href="page-gallery.html">gallery</a>
                            </li>
                            <!-- li end -->

                            <!-- Blog Menu-->
                            <li class="has-dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle menu-item">Blog</a>
                            </li>
                            <!-- li end -->

                            <!-- shop Menu -->
                            <li class="has-dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle menu-item">shop</a>
                            </li>
                            <!-- li end -->

                            <!-- Elements Menu -->
                            <li class="has-dropdown mega-dropdown">
                                <a href="<c:url value="/login?action=logout"/>"  class="dropdown-toggle menu-item">Logout</a>
                            </li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
            </div>
            <!-- /.container-fluid -->
        </nav>
    </header>

    <!-- Page Title #1
    ============================================= -->
    <section id="page-title" class="page-title bg-overlay bg-parallax bg-overlay-gradient">
        <div class="bg-section">
            <img src="/template/web/assets/images/page-title/1.jpg" alt="Background" />
        </div>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12">
                    <div class="title title-1 text-center">
                        <div class="title--content">
                            <div class="title--heading">
                                <h1>WELCOME TO ORDER</h1>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <ol class="breadcrumb">
                            <li><a href="/order">Order</a></li>
                        </ol>
                        <div class="divider--shape-1down"></div>
                    </div>
                    <!-- .title end -->
                </div>
                <!-- .col-md-12 end -->
            </div>
            <!-- .row end -->
        </div>
        <!-- .container end -->
    </section>
    <!-- #page-title end -->
</div>

<script src="assets/js/jquery-2.2.4.min.js"></script>
<script src="assets/js/plugins.js"></script>
<script src="assets/js/functions.js"></script>
</body>

</html>
