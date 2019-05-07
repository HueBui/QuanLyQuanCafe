<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<div class="sidebar" data-background-color="white" data-active-color="danger">

    <div class="sidebar-wrapper">
        <div class="logo">
            <a href="<c:url value="/trang-chu"/> " class="simple-text">
                Trang Chủ
            </a>
        </div>

        <ul class="nav">
            <li class="${active1}">
                <a href="<c:url value='/admin-home?action=statistical'/> ">
                    <i class="ti-panel"></i>
                    <p>Thống Kê Hệ Thống</p>
                </a>
            </li>
            <li class="${active2}">
                <a href="<c:url value="/admin-list-account?action=list"/> ">
                    <i class="ti-user"></i>
                    <p>Quản Lý Tài Khoản</p>
                </a>
            </li>
            <li class="${active3}">
                <a href='<c:url value="/admin-list-nguyen-lieu?action=list"/> '>
                    <i class="ti-view-list-alt"></i>
                    <p>Quản Lý Nguyên Liệu</p>
                </a>
            </li>
            <li class="${active4}">
                <a href='<c:url value="/admin-list-menu?action=list"/> '>
                    <i class="ti-view-list-alt"></i>
                    <p>Quản Lý Sản Phẩm</p>
                </a>
            </li>
            <li class="${active5}">
                <a href='<c:url value="/admin-list-table?action=list"/> '>
                    <i class="ti-view-list-alt"></i>
                    <p>Quản Lý Bàn</p>
                </a>
            </li>
            <li class="${active6}">
                <a href='<c:url value="/admin-list-category?action=list"/>'>
                    <i class="ti-pencil-alt2"></i>
                    <p>Quản Lý Danh Mục</p>
                </a>
            </li>
            <li class="${active7}">
                <a href='<c:url value="/admin-home?action=nottification"/> '>
                    <i class="ti-bell"></i>
                    <p>Thông Báo</p>
                </a>
            </li>
            <li class="active-pro">
                <a href='<c:url value="/admin-home?action=about"/> '>
                    <i class="ti-export"></i>
                    <p>Giới Thiệu Hệ Thống</p>
                </a>
            </li>
        </ul>
    </div>
</div>