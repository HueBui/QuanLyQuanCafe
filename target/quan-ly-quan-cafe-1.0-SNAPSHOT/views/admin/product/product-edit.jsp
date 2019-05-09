<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quản lý nguyên liêu</title>
</head>
<body>
<span style="color: red">${msg}</span>
<form action="/admin-edit-menu" method="post">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="form-group">
                <label>Tên sản phẩm</label>
                <input type="text" name="name" class="form-control" value="${menuModel.name}">
            </div>
            <div class="form-group">
                <label>Giá</label>
                <input type="text" name="gia" class="form-control" value="${menuModel.price}">
            </div>
            <div class="form-group">
                <label>Danh mục: </label>
                <select name="idCategory">
                    <c:forEach var="category" items="${categoryModelList}">
                    <option value="${category.id}" >${category.type}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Image</label>
                <input type="file" name="image" id="uploadImage" class="form-control">
            </div>
            <div class="form-group">
                <c:if test="${menuModel==null}">
                    <input type="hidden" name="action" value="themsanpham">
                    <button type="submit" class="btn btn-primary">Lưu</button>
                    <a class="btn btn-danger" href="">Quay lại</a>
                    </button>
                </c:if>
                <c:if test="${menuModel!=null}">
                    <input type="hidden" name="id" value="${menuModel.id}">
                    <input type="hidden" name="action" value="suasanpham">
                    <button type="submit" class="btn btn-primary">Sửa thông tin</button>
                    <a class="btn btn-danger" href="">Quay lại</a>
                    </button>
                </c:if>
            </div>
        </div>

    </div>
</form>
</body>
