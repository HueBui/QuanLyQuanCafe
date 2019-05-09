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
<form action="/admin-edit-category" method="post">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="form-group">
                <label>Type</label>
                <input type="text" name="type" class="form-control" value="${categoryModel.type}">
            </div>

            <div class="form-group">
                <label>Image</label>
                <input type="file" name="images" id="uploadImage" class="form-control" value="${categoryModel.image}">
            </div>
            <div class="form-group">
                <c:if test="${categoryModel==null}">
                    <input type="hidden" name="action" value="themdanhmuc">
                    <button type="submit" class="btn btn-primary">Lưu</button>
                    <a class="btn btn-danger" href="">Quay lại</a>
                    </button>
                </c:if>
                <c:if test="${categoryModel!=null}">
                    <input type="hidden" name="id" value="${categoryModel.id}">
                    <input type="hidden" name="action" value="suadanhmuc">
                    <button type="submit" class="btn btn-primary">Sửa thông tin</button>
                    <a class="btn btn-danger" href="">Quay lại</a>
                    </button>
                </c:if>
            </div>
        </div>

    </div>
</form>
</body>
