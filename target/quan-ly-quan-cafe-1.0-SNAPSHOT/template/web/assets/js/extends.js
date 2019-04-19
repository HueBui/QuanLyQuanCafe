function order(idSanPham, idTable) {
    var soLuong = document.getElementById("soluong_"+idSanPham).value;

    var json = [idTable,idSanPham,soLuong];
    $.ajax({
        url:"/booking",
        type:"POST",
        dataType:'json',
        data: {json:json},

        success:function(data){
            alert(data);
            $("#output").append( data );
        },
        error: function() {
            console.log('fail');   // doesn't print....
            console.log(typeof data); // prints 'undefined'
            $("#output").append('fail');
        }

    });
}

// $('#buttom').click(function(){
//     alert_success('1 cais gi day',3000)
// })

function alert_success(mes,time){
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
function alert_fail(mes,time) {
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

//Xóa user
$('#btnDeleteUser').click(function (e) {
    var kqXoa=confirm("Bạn có chắc muốn xóa không?");
    e.preventDefault();
    if(kqXoa==true){
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
    var kqXoa=confirm("Bạn có chắc muốn xóa không?");
    e.preventDefault();
    if(kqXoa==true){
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

//thanh toán
$('#btnThanhToan').click(function (e) {
    var kqThanhToan=confirm("Bạn có chắc thanh toán không?");
    e.preventDefault();
    if(kqThanhToan==true){
        var dataArray = $(' tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        var data = {};
        data["ids"] = dataArray;
        $.ajax({
            url: '/booking-detail',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                alert("Thanh toan thanh cong")
                // window.location.href = "/management";
            },
            error: function (error) {
                console.log("that bai");
                // window.location.href = "/management";
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
function autoCheckBoxChild() {
    $('#checkAll').change(function () {
        if ((this).checked) {
            $(this).closest('table').find('tbody input[type=checkbox]').prop('checked', true);
        } else {
            $ (this).closest('table').find('tbody input[type=checkbox]').prop('checked', false);
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
