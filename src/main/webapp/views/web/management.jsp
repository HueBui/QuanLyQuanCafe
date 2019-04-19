<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Management</title>
</head>
<body>

<div class="preloader">
    <div class="spinner">
        <div class="bounce1"></div>
        <div class="bounce2"></div>
        <div class="bounce3"></div>
    </div>
</div>

<div id="wrapper" class="">

    <%--header--%>

    <section id="portfolio-classic-3col" class="landing-demos portfolio portfolio-classic portfolio-3col bg-white"
             style="padding-bottom:70px;">
        <div class="container">
            <div class="row clearfix">
                <!-- .row end -->
                <div class="row">
                    <c:forEach var="bt" items="${bookingTable}">
                        <!-- Home #1 -->
                        <div class="col-xs-12 col-sm-6 col-md-4 portfolio-item">
                            <a href="<c:url value="/management-product?idTable=${bt.idTable}"/>">
                                <div class="portfolio-item-box">
                                    <div class="portfolio-img">
                                        <img src="template/web/assets/images/landing/images.png" alt="Home Page"
                                             width="100%">
                                    </div>
                                    <!-- .Portfolio-img end -->
                                    <div class="portfolio-bio">
                                        <div class="portfolio-meta">
                                            <div class="portfolio-title">
                                                <h4>${bt.nameTable}</h4>
                                            </div>
                                        </div>
                                        <!-- .Portfolio-meta end -->
                                    </div>
                                    <!-- .portfolio-bio end -->
                                </div>
                                <!-- .portfolio-item end -->
                            </a>
                        </div>
                    </c:forEach>
                    <!-- .portfolio-item  end -->
                </div>
                <!-- .row end -->
            </div>
            <!-- .container end -->
        </div>
    </section>

    <%--foter--%>
</div>
</body>
</html>