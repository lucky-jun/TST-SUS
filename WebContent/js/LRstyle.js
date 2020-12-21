//注册
var username_flage = false;
var password_flage = false;
var resetpassword_flage = false;
var tel_flage = false;
var email_flage = false;
var checkCode_flage = false;

function RshowTip(spanID, msg) {
    var span = document.getElementById(spanID)
    span.innerHTML = msg
}
function RcheckuserName(obj) {
    var username = obj.value;
    var span = document.getElementById("span_username");
    if (username.lenth <= 1) {
        span.innerHTML = "<font color='red'>用户名不可用</font>"
        username_flage = false;
    } else {
        span.innerHTML = "<font color='green'>√</font>"
    }
}
function RcheckpassWord(obj) {
    var password = obj.value;
    var span = document.getElementById("span_password");
    if (password.lenth <= 6) {
        span.innerHTML = "<font color='red'>密码长度不符合规定</font>"
        password_flage = false;
    } else {
        // 判断密码强弱
    }
}

// 登录.查询数据库是否正确，无用户或密码或用户名错误都提示 “用户名或密码错误”
var Lusername_flage = false;
var Lpassword_flage = false;

var sqlusername = "admin";
var sqlpassword = "admin"

function LshowTip(spanID, msg) {
    var span = document.getElementById(spanID);
    span.innerHTML = msg;
}
function LcheckuserName(obj) {
    var username = obj.value;
    var span = document.getElementById("span_username");

    if(username.length>0){
        span.innerHTML = "<font color='green'>√</font>"
        Lusername_flage = true;
    }else{
        span.innerHTML = "<font color='red'>X</font>"
        Lusername_flage = false;
    }

    // if (!username.test(sqlusername)) {
    //     span.innerHTML = "<font color='red'>用户名或密码错误</font>"
    //     Lusername_flage = false;
    // }else{
    //     span.innerHTML = "<font color='green'>√</font>"
    //     Lusername_flage = true;
    // }
}
function LcheckpassWord(obj) {
    var password = obj.value;
    var span = document.getElementById("span_password");
    if(password.length>=6){
        span.innerHTML = "<font color='green'>√</font>"
        Lpassword_flage = true;
    }else{
        span.innerHTML = "<font color='red'>X</font>"
        Lpassword_flage = false;
    }
    // if (!password.test(sqlpassword)) {
    //     span.innerHTML = "<font color='red'>用户名或密码错误</font>"
    //     Lpassword_flage = false;
    // }else{
    //     span.innerHTML = "<font color='green'>√</font>"
    //     Lpassword_flage = true;
    // }
}
function Lcheckflage() {
	//调用另一个js中的nihao()方法
//	nihao();
    return Lusername_flage && Lpassword_flage;
}