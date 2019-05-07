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
<form action="/admin-edit-table" method="post">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="form-group">
                <label>Tên Bàn</label>
                <input type="text" name="name" class="form-control" value="${tableModel.name}">
            </div>
            <div class="form-group">
                <label>Loại bàn</label>
                <input type="text" name="typeTable" class="form-control" value="${tableModel.typeTable}">
            </div>
            <div class="form-group">
                <label>Số lượng ghế</label>
                <input type="text" name="soLuongGhe" class="form-control" value="${tableModel.soLuongGhe}">
            </div>
            <div class="form-group">
                <label>Trạng thái</label>
                <input type="text" name="status" class="form-control" value="${tableModel.status}">
            </div>
            <div class="form-group">
                <label>Ghi chú</label>
                <input type="text" name="ghiChu" class="form-control" value="${tableModel.ghiChu}">
            </div>
            <div class="form-group">
                <label>Image</label>
                <input type="file" name="image" id="uploadImage" class="form-control">
            </div>
            <div class="form-group">
                <c:if test="${tableModel==null}">
                    <input type="hidden" name="action" value="addnew">
                    <input type="hidden" name="createdBy" value="${USERMODEL.userName}">
                    <button type="submit" class="btn btn-primary">Lưu</button>
                    <a class="btn btn-danger" href="">Quay lại</a>
                    </button>
                </c:if>
                <c:if test="${tableModel!=null}">
                    <input type="hidden" name="id" value="${tableModel.id}">
                    <input type="hidden" name="action" value="edit">
                    <button type="submit" class="btn btn-primary">Sửa thông tin</button>
                    <a class="btn btn-danger" href="">Quay lại</a>
                    </button>
                </c:if>
            </div>
        </div>
    </div>
</form>
</body>
