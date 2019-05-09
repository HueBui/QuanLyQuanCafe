<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Menu-order</title>
</head>

<body>
<section id="portfolio-classic-3col" class="landing-demos portfolio portfolio-classic portfolio-3col bg-white">
    <div class="container">
        <div class="panel-group" id="accordion">
            <c:forEach var="s" items="${categoryModels}">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse"
                                data-target="#collapse1_${s.id}"
                                style="font-family: initial;font-size: 18px; background-color: #CC3300; color: white; text-align: center; width: 100%"
                                aria-expanded="false" aria-controls="collapse1_${s.id}"
                                data-parent="#accordion">
                               <b>${s.type}</b>
                        </button>
                    </h4>
                </div>
                <div id="collapse1_${s.id}" class="panel-collapse collapse">
                    <div class="panel-body">
                        <table class="table table-striped" border="1">
                            <thead>
                            <tr>
                                <th scope="col" style="width: 40px"><input type="checkbox" style="zoom:1.8;"/></th>
                                <th scope="col" style="width: 40px"><input type="hidden" style="zoom:1.8;"/></th>
                                <th scope="col" style="text-align: center;font-family: initial; font-size: 20px;color: #000000 ">Tên Sản Phẩm
                                </th>
                                <th scope="col" style="font-family: initial; font-size: 20px;color: #000000; text-align: center">Giá</th>
                                <th scope="col" style="text-align: center;font-family: initial; font-size: 20px;color: #000000">Hình ảnh</th>
                                <th scope="col" style="text-align: center;font-family: initial; font-size: 20px;color: #000000">Số lượng</th>
                                <th scope="col" style="text-align: center;font-family: initial; font-size: 20px;color: #000000">Hành động</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="c" items="${menuOrderModels}">
                                <c:if test="${c.idCategory==s.id}">
                                    <tr>
                                        <th scope="col" style="width: 40px"><input type="checkbox" style="zoom:1.8;"/>
                                        </th>
                                        <th scope="col" style="width: 40px"><input type="hidden" style="zoom:1.8;"
                                                                                   value="${c.id}" id="sanpham_${c.id}"
                                                                                   name="idSanPham"/>
                                        </th>
                                        <td style=" font-family: initial; font-size: 18px;color: #000000">${c.tenSp}</td>
                                        <td style=" font-family: initial; font-size: 18px;color: #000000">${c.gia}</td>
                                        <td width="100px"><c:set var="image" value="/repository/${c.image}"/>
                                            <img src="${image}" id="viewImage" width="100px"
                                                 height="100px">
                                        </td>
                                        <td width="200px"><input type="number" name="soluong" min="0"
                                                                 id="soluong_${c.id}"
                                                                 style="margin-left:40px; margin-top:30px; width: 100px; height: 30px"/>
                                        </td>
                                        <c:if test="${idTable==null}">
                                            <td>
                                                <button class="btn btn-primary add_something"
                                                        onclick="order(${c.id},-1)">Thêm
                                                </button>
                                            </td>
                                        </c:if>
                                        <c:if test="${idTable!=null}">
                                            <td>
                                                <button class="btn btn-primary add_something" style="border-radius: 30px"
                                                        onclick="order(${c.id},${idTable})">Thêm
                                                </button>
                                            </td>
                                        </c:if>
                                    </tr>
                                    <input type="hidden" value="${idTable}" name="idTable">
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
    </div>
    </div>
    </div>
</section>
</body>
