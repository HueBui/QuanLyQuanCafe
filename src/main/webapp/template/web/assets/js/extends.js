function order(idSanPham, idTable) {
    var soLuong = document.getElementById("soluong_" + idSanPham).value;

    var json = [idTable, idSanPham, soLuong];

    $.ajax({
        url: "/booking",
        type: "POST",
        dataType: 'json',
        data: {json: json},

        success: function (data) {
            alert(data);
            $("#output").append(data);
        },
        error: function () {
            console.log('fail');   // doesn't print....
            console.log(typeof data); // prints 'undefined'
            $("#output").append('fail');
        }

    });
}

// $('#buttom').click(function(){
//     alert_success('1 cais gi day',3000)
// })

function alert_success(mes, time) {
    $.toast({
        heading: 'Action success',
        text: mes,
        position: 'top-right',
        loaderBg: '#ff6849',
        icon: 'success',
        hideAfter: time,
        showHideTransition: 'slide',
        stack: 6
    });
}

function alert_fail(mes, time) {
    $.toast({
        heading: 'Action fail',
        text: mes,
        position: 'top-right',
        loaderBg: '#ff6849',
        icon: 'error',
        hideAfter: time,
        stack: 6,
        showHideTransition: 'slide',
    });
}


enableOrDisableDeleteAllUser();
autoCheckBoxChild();
autoCheckBoxParent();
enableOrDisableDeleteAllNguyenLieu();
enableOrDisableDeleteAllMenu();

//Xóa user
$('#btnDeleteUser').click(function (e) {
    var kqXoa = confirm("Bạn có chắc muốn xóa không?");
    e.preventDefault();
    if (kqXoa == true) {
        var dataArray = $(' tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        var data = {};
        data["ids"] = dataArray;
        $.ajax({
            url: '/admin-list-account',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "/admin-list-account?action=list&msg=xoathanhcong";
            },
            error: function (error) {
                console.log("that bai");
                window.location.href = "/admin-list-account?action=list&msg=xoathatbai";
            }
        });
    }
    else {
        return false;
    }
});

//Xóa nguyên liệu

$('#btnDeleteNguyenLieu').click(function (e) {
    var kqXoa = confirm("Bạn có chắc muốn xóa không?");
    e.preventDefault();
    if (kqXoa == true) {
        var dataArray = $(' tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        var data = {};
        data["ids"] = dataArray;
        $.ajax({
            url: '/admin-list-nguyen-lieu',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "/admin-list-nguyen-lieu?action=list&msg=xoathanhcong";
            },
            error: function (error) {
                console.log("that bai");
                window.location.href = "/admin-list-nguyen-lieu?action=list&msg=xoathatbai";
            }
        });
    }
    else {
        return false;
    }
});

$('#btnDeleteMenu').click(function (e) {
    var kqXoa = confirm("Bạn có chắc muốn xóa không?");
    e.preventDefault();
    if (kqXoa == true) {
        var dataArray = $(' tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        var data = {};
        data["ids"] = dataArray;
        $.ajax({
            url: '/admin-list-menu',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "/admin-list-menu?action=list&msg=xoathanhcong";
            },
            error: function (error) {
                console.log("That bai");
                window.location.href = "/admin-list-menu?action=list&msg=xoathatbai";
            }
        });
    }
    else {
        return false;
    }
});

$('#btnDeleteTable').click(function (e) {
    var kqXoa = confirm("Bạn có chắc muốn xóa không?");
    e.preventDefault();
    if (kqXoa == true) {
        var dataArray = $(' tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        var data = {};
        data["ids"] = dataArray;
        $.ajax({
            url: '/admin-edit-table',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "/admin-edit-table?action=list&msg=xoathanhcong";
            },
            error: function (error) {
                console.log("That bai");
                window.location.href = "/admin-edit-table?action=list&msg=xoathatbai";
            }
        });
    }
    else {
        return false;
    }
});

//thanh toán
$('#btnThanhToan').click(function (e) {
    var kqThanhToan = confirm("Bạn có chắc thanh toán không?");
    e.preventDefault();
    if (kqThanhToan == true) {

        var idTable1 = document.getElementById("tableId").value;
        var idBooking1 = document.getElementById("idbooking").value;
        var totalPrice = document.getElementById("totalPrice").value;
        var data = [idTable1, idBooking1, totalPrice];

        $.ajax({
            url: "/booking-detail",
            type: "POST",
            dataType: 'json',
            data: {json: data},
            success: function (data) {
                alert(data);
                $("#output").append(data);
                window.location.href = "/management";
            },
            error: function () {
                console.log('fail');   // doesn't print....
                console.log(typeof data); // prints 'undefined'
                $("#output").append('fail');
            }

        });
    }
    else {
        return false;
    }
});

function enableOrDisableDeleteAllNguyenLieu() {
    $('input[type=checkbox]').click(function () {
        if ($('input[type=checkbox]:checked').length > 0) {
            $('#btnDeleteNguyenLieu').prop('disabled', false);
            $('#btnDeleteNguyenLieu').css("background-color", "#E8E8E8");
        } else {
            $('#btnDeleteNguyenLieu').prop('disabled', true);
            $('#btnDeleteNguyenLieu').css("background-color", "");
        }
    });
}


function enableOrDisableDeleteAllUser() {
    $('input[type=checkbox]').click(function () {
        if ($('input[type=checkbox]:checked').length > 0) {
            $('#btnDeleteUser').prop('disabled', false);
            $('#btnDeleteUser').css("background-color", "#E8E8E8");
        } else {
            $('#btnDeleteUser').prop('disabled', true);
            $('#btnDeleteUser').css("background-color", "");
        }
    });
}

function enableOrDisableDeleteAllMenu() {
    $('input[type=checkbox]').click(function () {
        if ($('input[type=checkbox]:checked').length > 0) {
            $('#btnDeleteMenu').prop('disabled', false);
            $('#btnDeleteUser').css("background-color", "#E8E8E8");
        } else {
            $('#btnDeleteMenu').prop('disabled', true);
            $('#btnDeleteMenu').css("background-color", "");
        }
    });
}

function autoCheckBoxChild() {
    $('#checkAll').change(function () {
        if ((this).checked) {
            $(this).closest('table').find('tbody input[type=checkbox]').prop('checked', true);
        } else {
            $(this).closest('table').find('tbody input[type=checkbox]').prop('checked', false);
            $('#btnDeleteUser').prop('disabled', true);
            $('#btnDeleteNguyenLieu').prop('disabled', true);
        }
    });
}

function autoCheckBoxParent() {
    var totalCheckboxChild = $('#checkAll').closest('table').find('tbody input[type=checkbox]').length;
    $('#checkAll').closest('table').find('tbody input[type=checkbox]').each(function () {
        $(this).on('change', function () {
            var totalCheckboxChecked = $('#checkAll').closest('table').find('tbody input[type=checkbox]:checked').length;
            if (totalCheckboxChild == totalCheckboxChecked) {
                $('#checkAll').prop('checked', true);
            } else {
                $('#checkAll').prop('checked', false);
            }
        });
    });
}


//upload anh
$('#uploadImage').change(function () {
    var dataArray = {};
    var files = $(this)[0].files[0];
    if (files != undefined) {
        var reader = new FileReader();
        reader.onload = function (e) {
            dataArray["base64"] = e.target.result;
            dataArray["name"] = files.name;
            uploadFile(dataArray);
        };
        reader.readAsDataURL(files);
    }
});

function uploadFile(data) {
    $.ajax({
        url: '/upload-file',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function (res) {
            console.log(res);
            $('#kq-upload').html("<label style='color: blue'>Up thành công</label>");
        },
        error: function (res) {
            console.log(res);
            $('#kq-upload').html("<label style='color: red'>Up thất bại</label>");
        }
    });
}
