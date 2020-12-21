    //下拉框可能会用到 New option
        var userid = u_storage.get("userid");
    	alert("userid:"+userid);
    	console.log("userid:"+userid);
    	if (userid == undefined){
    		userid=""
    		};
   //这个里面的参数说明 第一个是显示的文本，第二个是value值 
   //例如：new Option(item.xm, item.id)第一个参数是下拉列表中显示的值  第二个参数是选中传递给后台的值
    layui.use(['form', 'upload', 'layer'],function(){
    	$ = layui.jquery;
        var form = layui.form;
        
        //获取sessionID
        var userid = u_storage.get("userid");
    	layer.alert("userid:"+userid);
    	console.log("userid:"+userid);
    	if (userid == undefined || userid == null){
    		userid=""
    		};
    		mfGetDate();
    		spGetDate();
        function mfGetDate(){
        	console.log("444444444444444");
            $.ajax({
                url: 'selectGetData.mfdo1',
                dataType: 'json',
                type: 'post',
        		beforeSend : function(request) {
        			request.setRequestHeader("userid", userid);
        		},
                success: function (data) {
                	console.log("11111111111111111");
                    console.log(data);//下面会提到这个data是什么值
                    //使用循环遍历，给下拉列表赋值
                    $.each(data.data, function (index, value) {
                        // console.log(value.department_id);
                        $('#mf_name').append(new Option(value.m_name,value.m_id));// 下拉菜单里添加元素
                    });
                    layui.form.render("select");//重新渲染 固定写法
                }
        		,error:function(data){
        			console.log("2222222222222");
    	        	if(data.responseText=="Header has no value"){
    	        		window.location.href="./html/login.html";
    	        	}else{
    	        		layer.msg('有错误！');
    	        	}
            	}
            })
            }
            function spGetDate(){
                $.ajax({
                	url: 'selectGetData.spdo',
                	dataType: 'json',
                	type: 'post',
                	success: function (data) {
                		console.log(data);//下面会提到这个data是什么值
                		//使用循环遍历，给下拉列表赋值
                		$.each(data.data, function (index, value) {
                			// console.log(value.department_id);
                			$('#sp_name').append(new Option(value.s_name,value.s_id));// 下拉菜单里添加元素
                		});
                		layui.form.render("select");//重新渲染 固定写法
                	}
        			,headers:{
        	      		userid:userid,
        	      		token:"aaaa"
        			}
        			,error:function(data){
        	        	if(data.responseText=="Header has no value"){
        	        		window.location.href="./html/login.html";
        	        	}else{
        	        		layer.msg('有错误！');
        	        	}
        	    	}
                })
            }
    });
