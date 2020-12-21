function login(){
	if(Lcheckflage()){
		$.ajax({
			url:"http://localhost:8080/SuperMarket/Login",
			type:"post",
			data:{
				//获取输入的用户名和密码
				username:$("[name='username']").val(),
				password:$("[name='password']").val()
			},
			contentType:"application/x-www-form-urlencoded",
			dataType:"json",
			async:false,//是否支持异步
			error:function(request){
				alert("有错误")
			},
			success:function(data){
				console.log(data);
				if(data.userid!=0){
					//设置session
					u_storage.set("userid",data.userid);
					u_storage.set("id",data.id)
					//跳转页面
						if(data.type==6){
							$(location).attr("href","../index.html");
						}else if(data.type==1){
							alert("即将跳转非管理员用户使用界面");
						}else if(data.type==0){
							alert("即将跳转客户使用界面");
						}
				}else{
				    document.getElementById("spanmsg").innerHTML = "<font color='red'>用户名或密码错误</font>";;
				}
			}
				
		});
	}else{
		document.getElementById("spanmsg").innerHTML = "<font color='red'>用户名或密码不符合规范</font>";
	}
}


//function nihao(){
//	alert("你好呀");
//}