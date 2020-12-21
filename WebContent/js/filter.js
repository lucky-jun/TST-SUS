$(document).ready(function(){
	var userid = u_storage.get("userid");
	if (userid == undefined){
		userid = "";
		}
	$.ajax({
		url : "1.do"/*"http://localhost:8080/SuperMarket/AdminGetData.mdo"*/,
		type : "post",
		data : {},
		contenType : "application/x-www-form-urlencoded",
		dataType : "json",
		beforeSend : function(request) {
			request.setRequestHeader("userid", userid);
		},
		async : false,//是否异步
		xhrFields : {
			withCredentials : true
		},
		error : function(request) {
//			alert("错误");
		},
		success : function(data) {
			console.log(data);
			if (data.flag == "true") {
				alert("你的操作成功了！")
			} else {
				$(location).attr("href", "./html/login.html");
			}
		}
	})

});