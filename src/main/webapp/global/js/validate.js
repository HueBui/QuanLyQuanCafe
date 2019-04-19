function validateRegister() {
    var fullname= document.getElementById('fullname').value;
    var username= document.getElementById('username').value;
    var password= document.getElementById('password').value;

    if(fullname=="" || fullname.length <6){
        document.getElementById("showMsg_fullname").innerHTML = "Họ và tên  tối thiểu 6 ký tự!";
        this.fullname.focus();
        return false;
    } else {
        document.getElementById("showMsg_fullname").innerHTML = "";
    }

    if(username =="" || username.length <6){
        document.getElementById("showMsg_username").innerHTML = "Tên đăng nhập  tối thiểu 6 ký tự!";
        this.username.focus();
        return false;
    }else {
        document.getElementById("showMsg_username").innerHTML = "";
    }
    if(password =="" || password.length <6){
        document.getElementById("showMsg_password").innerHTML = "Mật khẩu  tối thiểu 6 ký tự!";
        this.password.focus();
        return false;
    }else {
        document.getElementById("showMsg_password").innerHTML = "";
    }
    return true;
}

function validateLogin() {
    var username= document.getElementById('username').value;
    var password= document.getElementById('password').value;

    if(username =="" || username.length <6){
        document.getElementById("showMsg_username").innerHTML = "Tên đăng nhập  tối thiểu 6 ký tự!";
        this.username.focus();
        return false;
    }else {
        document.getElementById("showMsg_username").innerHTML = "";
    }
    if(password =="" || password.length <6){
        document.getElementById("showMsg_password").innerHTML = "Mật khẩu  tối thiểu 6 ký tự!";
        this.password.focus();
        return false;
    }else {
        document.getElementById("showMsg_password").innerHTML = "";
    }
    return true;
}