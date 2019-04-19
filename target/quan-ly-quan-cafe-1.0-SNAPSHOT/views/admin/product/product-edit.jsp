<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quản lý nguyên liệu</title>
</head>
<body>
<span style="color: red">${msg}</span>
<form action="/admin-edit-nguyen-lieu" method="post">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="form-group">
                <label>Tên nguyên liệu</label>
                <input type="text" name="name" class="form-control" value="${nguyenLieuModel.name}">
            </div>
            <div class="form-group">
                <label>Số lượng</label>
                <input type="text" name="soluong" class="form-control" value="${nguyenLieuModel.quantity}">
            </div>

            <div class="form-group">
                <label>Ngày nhập</label>
                <input id="input" width="312" name="ngayNhap" value="${nguyenLieuModel.ngayNhap}"/>
            </div>
            <div class="form-group">
                <label>Giá</label>
                <input type="text" name="gia" class="form-control" value="${nguyenLieuModel.price}">
            </div>
            <div class="form-group">
                <label>Image</label>
                <input type="file" name="image"  class="form-control" value="${nguyenLieuModel.image}">
            </div>

            <div class="form-group">
                <c:if test="${nguyenLieuModel==null}">
                    <input type="hidden" name="action" value="themnguyenlieu">
                    <button type="submit" class="btn btn-primary">Lưu</button>
                    <a class="btn btn-danger" href="">Quay lại</a>
                    </button>
                </c:if>
                <c:if test="${nguyenLieuModel!=null}">
                    <input type="hidden" name="id" value="${nguyenLieuModel.id}">
                    <input type="hidden" name="action" value="suanguyenlieu">
                    <button type="submit" class="btn btn-primary">Sửa thông tin</button>
                    <a class="btn btn-danger" href="">Quay lại</a>
                    </button>
                </c:if>
            </div>
        </div>

    </div>
</form>
<script>
    $('#input').datetimepicker({ footer: true, modal: true });
</script>
</body>

