<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quản lý nhân viên</title>
</head>
<body>
<span style="color: red">${msg}</span>
<form action="/admin-edit-account" method="post">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="form-group">
                <label>Username</label>
                <input type="text" name="name" class="form-control" value="${userModel.userName}">
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="text" name="email" class="form-control" value="${userModel.email}">
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" class="form-control">
            </div>
            <div class="form-group">
                <label>Chọn chức vụ</label>
                <select class="form-control" name="user_level">
                    <option value="2" <c:if test="${userModel.roleId==2}">selected</c:if>>Nhân viên order</option>
                    <option value="1" <c:if test="${userModel.roleId==1}">selected</c:if>>Admin</option>
                    <option value="3" <c:if test="${userModel.roleId==3}">selected</c:if>>Nhân Viên Quầy</option>
                </select>
            </div>
            <div class="form-group">
                <label>Full Name:</label>
                <input type="text" name="user_firstName" placeholder="Full Name" class="form-control" value="${userModel.fullName}" >
            </div>
            <div class="form-group">
                <label>CMTND</label>
                <input type="text" name="cmtnd" class="form-control" value="${userModel.cmtnd}">
            </div>
            <div class="form-group">
                <label>Birth day</label>
                <input type="date" name="user_birth" class="form-control">
            </div>
            <div class="form-group">
                <label>Adress</label>
                <input type="text" name="user_adress" class="form-control" value="${userModel.address}">
            </div>
            <div class="form-group">
                <label>Phone</label>
                <input type="text" name="user_phone" class="form-control" value="${userModel.phone}">
            </div>
            <div class="form-group">
                <label>Image</label>
                <input type="file" name="user_img" id="uploadImage" class="form-control">
            </div>
            <div class="form-group">
                    <c:if test="${userModel==null}">
                        <input type="hidden" name="action" value="themtaikhoan">
                        <input type="hidden" name="createdBy" value="${USERMODEL.userName}">
                        <button type="submit" class="btn btn-primary">Lưu</button>
                        <a class="btn btn-danger" href="">Quay lại</a>
                        </button>
                    </c:if>
                    <c:if test="${userModel!=null}">
                        <input type="hidden" name="id" value="${userModel.id}">
                        <input type="hidden" name="modifiedBy" value="${USERMODEL.userName}">
                        <input type="hidden" name="action" value="suataikhoan">
                        <button type="submit" class="btn btn-primary">Sửa thông tin</button>
                        <a class="btn btn-danger" href="">Quay lại</a>
                        </button>
                    </c:if>
            </div>
        </div>

    </div>
</form>
</body>
