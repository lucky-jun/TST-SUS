layui.use(['element','jquery','layer','form','table','laydate'], function(){
  /*var laydate = layui.laydate;*/
	var laydate = layui.laydate;
  var table = layui.table;
  /*var element = layui.element;*/
  var form =layui.form;
  /*var $ = layui.jquery;*/
  var layer = layui.layer;
  //滑动开关
  var tableData;
  //方法级渲染
  
  //获取请求头

  var userid = u_storage.get("userid");
//	alert("userid:"+userid);
	if (userid == undefined){
		userid=""
		};
table.render({
    elem: '#table_user'
/*    ,url: 'http://localhost:8080/SuperMarket/PageDemoController'*/
    ,url: 'queryPage.mdo'
    ,request: {
		    pageName: 'page' //页码的参数名称，默认：page
		    ,limitName: 'limit' //每页数据量的参数名，默认：limit
	}
	/*,height:615*/
	,height:500
  	,limit:10
  	,limits:[5,10,15]
    ,defaultToolbar: ['filter']
  	,method:'post'
  	,toolbar: '#toolbarDemo'
	,beforeSend: function(request) {
		request.setRequestHeader("userid", userid);
	}
    ,cols: [[
      {checkbox: true, fixed: true}
      ,{field:'g_id', title: 'ID', width:80, sort: true, fixed: true}
      ,{field:'g_name', title: '名称', width:80,fixed: true}
      ,{field:'g_price', title: '单价', width:80, sort: true ,align:'center'}
      ,{field:'g_code', title: '条形码', width:80}
      ,{field:'g_discount', title: '是否促销', width:100,templet:function(d){
    	  return d.g_discount==1?'是':'否';
      }}
      ,{field:'g_promt_data', title: '是否限期销售', width:120,templet:function(d){
    	  return d.g_promt_data==1?'是':'否';
      }}
      ,{field:'g_promt_num', title: '是否限量销售', width:120,templet:function(d){
    	  if(d.g_promt_num==1){
    		  return "是";
    	  }else if(d.g_promt_num==0){
    		  return "否";
    	  }
      }}
      ,{field:'g_promt_price', title: '促销价格'}
      ,{field:'g_promt_date_start', title: '限期开始时间', sort: true, width:80}
      ,{field:'g_promt_date_stop', title: '限期结束时间', width:80}
      ,{field:'g_promt_num_number', title: '限制销售数量', width:80}
      
      ,{field:'g_stock', title: '库存量', width:80}
      ,{field:'g_stock_urgent', title: '报警数量', width:80}
      ,{field:'g_plan', title: '计划进货数', width:80}
//      ,{field:'g_sale', title: '是否允许销售', width:120 ,templet: function(d){
//    	  if(d.g_sale==1){
//    		  return "是";
//    	  }else if(d.g_sale==0){
//    		  return "否";
//    	  }
//      }}
      ,{field:'g_sale', title: '是否允许销售', width:120 ,templet: function(d) {
    	   // 三元运算符
    	   var isCkecked = d.g_sale == "1" ? "checked" : "";
    	   return '<input type="checkbox" lay-skin="switch" lay-filter="switchTest" lay-text="已上架|已下架" '+ isCkecked +'> ';
    	}}
      ,{field:'mf_id', title: '生产厂商ID', width:80}
      ,{field:'sp_id', title: '供货商ID', width:80}
      ,{field:'right', title: '操作',toolbar:'#userBar', width:200 ,align:'center'}
      
    ]]
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
    ,text:{
    	none:"无相关数据"
    }
    ,id: 'testReload'
    ,page: true
//    滑动开关
    ,done:function(data){
        tableData = table.cache.testReload;
    }
  });
  
var check = form.on('radio(ChoiceRadio)', function(data){
	
	  console.log(data.elem); //得到 radio 原始 DOM 对象
	  console.log(data.value); //被点击的 radio 的 value 值
	  layui.alert("++++++++++:"+data.value);
	});


 //搜索
  	var $ = layui.$, active = {reload:function(){
			var demoReload = $('#div111 .layui-inline #demoReload'); 
			var check;
		    /*alert("输入的值为："+demoReload.val());*/
		    console.log(demoReload.val());
//		    alert("OOOO:"+demoReload.val())
//		    alert("OOOO:"+userid)
		    //执行重载
		    if(demoReload.val()==""){
		    	location.reload();
		    }else{	
		    	alert("8888check:"+check);
		    	table.reload('testReload', {
		        url:"queryByName.mdo"      	
		        /*url:"queryByName.mdo" */     	
		       ,page: {curr: 1}//重新从第 1 页开始
		       ,where: {
		    	   g_name: demoReload.val(),
		    	   check:"777",
		    	   page:1,
		    	   limit:10
		       }
		       }, 'data');
		    }
		    }
		  };
		  
		  $('#div111 .layui-btn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });

		  
//			复选框监控	  
		  var checkfuxuan= table.on('checkbox(user)', function(obj){
		  			  console.log(obj.checked); //当前是否选中状态
		  			  console.log(obj.data); //选中行的相关数据
		  			  console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
		  			  if(obj.type=='all'){
		  				  layer.msg("全选");
		  			  }else{
		  				  layer.msg(obj.data.g_name);
		  			  }
		  			});
		  
//		  function setpage() {
//			  layer.alert("2222222");
//			    if ($(window).width() < 458) {
//			        return ['100%', '100%'];
//			    } else {
//			        return ['70%', '70%'];
//			    }
//		  }
		  

		
	//监听事件
		  table.on('toolbar(user)', function(obj){
			  var checkStatus = table.checkStatus(obj.config.id);
			  var data = obj.data
			  switch(obj.event){
			    case 'add':
			      layer.msg('添加新商品');
			      layer.open({
			          type: 2 //此处以iframe举例
			          ,title: '添加操作'
			          ,area: ['790px', '560px']
//			          ,area: setpage()
			          ,shade: 0
			          ,maxmin: true
			          /*,offset: [ //为了演示，随机坐标
			            Math.random()*($(window).height()-300)
			            ,Math.random()*($(window).width()-390)
			          ] */
			          ,content: './html/addNewGoods.html'
			          ,btn: ['确认', '取消'] // 按钮
			          ,yes: function(index, layero){
			        	  //layer.iframeAuto(index)
			        	 /* var body = layer.getChildFrame('body', index);
			        	  var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
			        	  console.log(body.html()) //得到iframe页的body内容
			        	  body.find('input').val('Hi，我是从父页来的')*/
			        	  var body = layer.getChildFrame('body', index);
//			        	  console.log(body.html())
			        	  //表单提交验证
//			        	  if(body.find("#submit").click().val()=="true"){
//				        	  console.log("添加新商品关键校验成功");
//				        	  
//			        	  }else{
//				        	  console.log("添加新商品关键校验失败");
//			        	  }
//		                  	console.log("333333:"+body.find("#demo1").click().val())
		        		  if(body.find("#demo1").click().val()=="true"){
				        	  $.ajax({
				                  url:'http://localhost:8080/SuperMarket/addGoods.mdo',
				                  type:'post',
				                  dataType:'json',
				                  data:{
				                  	/*g_id:body.find('#g_id').val(),*/
				                  	g_name:body.find('#g_name').val(),
				                  	g_price:body.find('#g_price').val(),
				                  	g_code:body.find('#g_code').val(),
				                  	g_promt_price:body.find('#g_promt_price').val(),
				                  	g_promt_date_start:body.find('#g_promt_date_start').val(),
				                  	/*g_promt_date_stop:body.find('#g_promt_date_stop').val(),*/
				                  	g_promt_num_number:body.find('#g_promt_num_number').val(),
				                  	g_discount:body.find('#g_discount').val(),
				                  	g_promt_data:body.find('#g_promt_data').val(),
				                  	g_promt_num:body.find('#g_promt_num').val(),
				                  	g_stock:body.find('#g_stock').val(),
				                  	g_stock_urgent:body.find('#g_stock_urgent').val(),
				                  	g_plan:body.find('#g_plan').val(),
				                  	g_sale:body.find('#g_sale').val(),
				                  	mf_id:body.find('#mf_id').val(),
				                  	mf_name:body.find('#mf_name').val(),
				                  	mf_add:body.find('#mf_add').val(),
				                  	mf_tel:body.find('#mf_tel').val(),
				                  	sp_id:body.find('#sp_id').val(),
				                  	sp_name:body.find('#sp_name').val(),
				                  	sp_add:body.find('#sp_add').val(),
				                  	sp_tel:body.find('#sp_tel').val()
				                  }
				        	  	,headers:{
				        	  		userid:userid,
				        	  		token:"aaaa"
				        	  	},
				                  success:function(data){
				                  	console.log(data);
				                      if (data.flag == "true") {
				                          layer.alert('添加成功！');
				                      }else if(data.flag == "false"){
				                          layer.alert('添加失败！');
				                      }else{
				                    	  layer.alert(data.flag)
				                      }
				                    	setTimeout(function(){
					                      layer.closeAll();
					                      table.reload('testReload');
				                      },2000)
				                  },
				                  error:function(data){
//				                	  console.log("错误map："+data.data.flag);
				                	  /*console.log("错误："+data.data.val());*/
				                  }
	/*			                  ,yes: function(index, layero){
				                	  layer.alert("22222222");
	                                  layero.find('.layui-btn').click();    // 这一句就是点击确认按钮触发form的隐藏提交
	                              }*/
				              }); 
		        		  }
		        		  
//				              $(this).click();
//			        	  layer.alert("99999999999:"+body.find("#submit").click());
			            // 添加管理员
//			        	  $.ajax({
//			                  url:'http://localhost:8080/SuperMarket/addGoods.mdo',
//			                  type:'post',
//			                  dataType:'json',
//			                  data:{
//			                  	/*g_id:body.find('#g_id').val(),*/
//			                  	g_name:body.find('#g_name').val(),
//			                  	g_price:body.find('#g_price').val(),
//			                  	g_code:body.find('#g_code').val(),
//			                  	g_promt_price:body.find('#g_promt_price').val(),
//			                  	g_promt_date_start:body.find('#g_promt_date_start').val(),
//			                  	/*g_promt_date_stop:body.find('#g_promt_date_stop').val(),*/
//			                  	g_promt_num_number:body.find('#g_promt_num_number').val(),
//			                  	g_discount:body.find('#g_discount').val(),
//			                  	g_promt_data:body.find('#g_promt_data').val(),
//			                  	g_promt_num:body.find('#g_promt_num').val(),
//			                  	g_stock:body.find('#g_stock').val(),
//			                  	g_stock_urgent:body.find('#g_stock_urgent').val(),
//			                  	g_plan:body.find('#g_plan').val(),
//			                  	g_sale:body.find('#g_sale').val(),
//			                  	mf_id:body.find('#mf_id').val(),
//			                  	mf_name:body.find('#mf_name').val(),
//			                  	mf_add:body.find('#mf_add').val(),
//			                  	mf_tel:body.find('#mf_tel').val(),
//			                  	sp_id:body.find('#sp_id').val(),
//			                  	sp_name:body.find('#sp_name').val(),
//			                  	sp_add:body.find('#sp_add').val(),
//			                  	sp_tel:body.find('#sp_tel').val()
//			                  },
//			                  success:function(data){
//			                  	console.log(data);
//			                      if (data.flag == "true") {
//			                          layer.alert('添加成功！');
//			                      }else if(data.flag == "false"){
//			                          layer.alert('添加失败！');
//			                      }else{
//			                    	  layer.alert(data.flag+"---------")
//			                      }
//			                    	setTimeout(function(){
//				                      layer.closeAll();
////				                      table.reload('testReload');
//			                      },1000)
//			                  }
///*			                  ,yes: function(index, layero){
//			                	  layer.alert("22222222");
//                                  layero.find('.layui-btn').click();    // 这一句就是点击确认按钮触发form的隐藏提交
//                              }*/
//			              }); 
			          }
			          ,btn2: function(){
			            layer.closeAll();
			          }
			          //,zIndex: layer.zIndex //重点1
			          ,success: function(layero){
			            //layer.setTop(layero); //重点2
			          }
			        });
			    break;
			    case 'delete':
			    	var checkStatus1 = table.checkStatus('testReload');
			    	var data2 = checkStatus.data;
			    	var dataList="";
			    	if(data2.length!=0){
				    	for(var i=0;i<data2.length;i++){
						    dataList+=data2[i].g_id+",";
				    	}
					    layer.msg(dataList);
					    $.ajax({
				          	url:"deleteGoods.mdo",
				          	type:"post",
				          	headers:{
				          		userid:userid,
				          		token:"aaaa"
				          	},
				          	data:{
				          		g_idList:dataList
				          	},
				          	contentType:"application/x-www-form-urlencoded",
				          	dataType:"json",
				          	success:function(data){
				          		console.log(data);
				          		if(data.flag == true){
				          				table.reload('testReload');
				          				layer.msg('删除成功！');
				          		}else{
				          			layer.close(index);
				          			layer.msg('删除失败！');
				          		}
				          	},
				          	error:function(){
				          		layer.msg('服务在加载中...');
				          	}
				          });
			    	}else{
			    		layer.msg("未选择数据！");
			    	}
			    break;
			    case 'offshelf':
			    	var checkStatus1 = table.checkStatus('testReload');
			    	
			    	/*layer.msg("4批量下架");*/
			    	var data2 = checkStatus.data;
			    	var dataList="";
			    	if(data2.length!=0){
				    	for(var i=0;i<data2.length;i++){
						    dataList+=data2[i].g_id+",";
				    	}
					    layer.msg(dataList);
					    $.ajax({
				          	url:"updataSale.mdo",
				          	type:"post",
				          	headers:{
				          		userid:userid,
				          		token:"aaaa"
				          	},
				          	data:{
				          		g_idList:dataList
				          	},
				          	contentType:"application/x-www-form-urlencoded",
				          	dataType:"json",
				          	success:function(data){
				          		console.log(data);
				          		if(data.flag == true){
				          			layer.msg('下架成功！');
			          				table.reload('testReload');
				          		}else{
				          			layer.msg('下架失败！');
				          		}
				          	},
				          	error:function(){
				          		layer.msg('服务在加载中...');
				          	}
				          });
			    	}else{
			    		layer.msg("未选择数据！");
			    	}
			    	break;
			  };
			});
		  





//监听————商品下架
  form.on('switch(switchTest)', function(data){
	  
		var index  = data.othis.parents('tr').attr("data-index");
		var id = tableData[index].g_id;
	  
	  var check = this.checked ? 'true' : 'false';
//	  layer.msg('开关checked：----'+ (check), {
//	    offset: '6px'
//	  });
	  if(check=='true'){
		  var sale=1;
	  }else{
		  var sale=0;
	  }
	  layer.tips('温馨提示：商品下架，并未删除商品！')
	  $.ajax({
	    	url:"updataSale.mdo",
	    	type:"post",
	    	data:{
	    		g_id:id,
	    		g_sale:sale
	    	},  	
	    	headers:{
	      		userid:userid,
	      		token:"aaaa"
	      	},
	    	contentType:"application/x-www-form-urlencoded",
	    	dataType:"json",
	    	success:function(data){
	    		console.log(data);
	    		if(data.flag == true){
	    			if(data.value==1){
		    			layer.msg('商品上架成功！');
	    			}else{
	    				layer.msg('商品下架成功！');
	    			}
	    		}else{
	    			if(data.value==1){
		    			layer.msg('商品下架成功！');
	    			}else{
		    			layer.msg('商品下架失败！');
	    			}
	    		}
	    	},
	    	error:function(){
	    		layer.msg('服务在加载中...');
	    	}
	    });
	});

//时间控件
//TimeJS.js中


//监听行工具事件
table.on('tool(user)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
  var data = obj.data //获得当前行数据
  ,layEvent = obj.event; //获得 lay-event 对应的值
  if(layEvent === 'add'){
//    layer.msg('添加商品数量');
    layer.open({
        type: 2 //此处以iframe举例
        ,title: '添加商品数量操作'
        ,area: ['590px', '460px']
        ,shade: 0
        ,maxmin: true
        /*,offset: [ //为了演示，随机坐标
          Math.random()*($(window).height()-300)
          ,Math.random()*($(window).width()-390)
        ] */
        ,content: './html/addGoodsNumber.html'
        ,btn: ['确认', '取消'] // 按钮
        ,yes: function(index, layero){
      	  layer.iframeAuto(index)
      	 /* var body = layer.getChildFrame('body', index);
      	  var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
      	  console.log(body.html()) //得到iframe页的body内容
      	  body.find('input').val('Hi，我是从父页来的')*/
      	  var body = layer.getChildFrame('body', index);
      	  var iframeWin = window[layero.find('iframe')[0]['name']];
      	  console.log(data);
      	  console.log(body.find("#g_id").val());
            $(this).click();
            // 编辑管理员
      	  $.ajax({
                url:'http://localhost:8080/SuperMarket/updateGoods.mdo',
                type:'post',
              	headers:{
              		userid:userid,
              		token:"aaaa"
              	},
                dataType:'json',
                data:{
                	g_id:body.find('#g_id').val(),
                	g_name:body.find('#g_name').val(),
                	g_price:body.find('#g_price').val(),
                	g_code:body.find('#g_code').val(),
                	g_promt_price:body.find('#g_promt_price').val(),
                	g_promt_date_start:body.find('#g_promt_date_start').val(),
                	g_promt_date_stop:body.find('#g_promt_date_stop').val(),
                	g_promt_num_number:body.find('#g_promt_num_number').val(),
                	g_discount:body.find('#g_discount').val(),
                	g_promt_data:body.find('#g_promt_data').val(),
                	g_promt_num:body.find('#g_promt_num').val(),
                	g_stock:body.find('#g_stock').val(),
                	g_stockTianJia:body.find('#g_stockTianJia').val(),
                	g_stock_urgent:body.find('#g_stock_urgent').val(),
                	g_plan:body.find('#g_plan').val(),
                	g_sale:body.find('#g_sale').val(),
                	mf_id:body.find('#mf_id').val(),
                	sp_id:body.find('#sp_id').val(),
                	type:"addNumber"
                },
                success:function(data){
                	console.log(data);
                    if (data.flag == true) {
                        layer.alert('修改成功！');
//                    	layer.alert("123123");
                    }else {
                        layer.alert('修改失败！hhhhhhhhhh');
                    }
                    setTimeout(function(){
//                    	layer.alert("123123");
                        layer.closeAll();
                        //刷新网页
                        //xxxxx
                        table.reload('testReload');
                    },1000)
                }
            }); 
        }
        ,btn2: function(){
          layer.closeAll();
        }
        //,zIndex: layer.zIndex //重点1
        ,success: function(layero, index){
          //layer.setTop(layero); //重点2
      	//找到它的子窗口的body
          var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
          //为子窗口元素赋值
          //时间判定
           
          if(data.g_promt_date_start!="" && data.g_promt_date_stop!=""){
              var time1 = (data.g_promt_date_start+" - "+data.g_promt_date_stop)
              }
          body.contents().find("#g_id").val(data.g_id);
          body.contents().find("#g_name").val(data.g_name);
          body.contents().find("#g_price").val(data.g_price);
          body.contents().find("#g_code").val(data.g_code);
          body.contents().find("#g_promt_price").val(data.g_promt_price);
          body.contents().find("#g_promt_date_start").val(time1);
//          body.contents().find("#g_promt_date_stop").val(data.g_promt_date_stop);
          body.contents().find("#g_promt_num_number").val(data.g_promt_num_number);
          body.contents().find("#g_discount").val(data.g_discount);
          body.contents().find("#g_promt_data").val(data.g_promt_data);
          body.contents().find("#g_promt_num").val(data.g_promt_num);
          body.contents().find("#g_stock").val(data.g_stock);
          body.contents().find("#g_stock_urgent").val(data.g_stock_urgent);
          body.contents().find("#g_plan").val(data.g_plan);
          body.contents().find("#g_sale").val(data.g_sale);
          body.contents().find("#mf_id").val(data.mf_id);
          body.contents().find("#sp_id").val(data.sp_id);
          console.log(data)
        }
      });
    
  }else if(layEvent === 'del'){
    layer.confirm('确认从商店中删除 “'+data.g_name+'” 这件商品吗？', function(index){
      //obj.del(); //删除对应行（tr）的DOM结构
      //layer.close(index);
      //向服务端发送删除指令
      console.log(data.g_id);
      $.ajax({
      	url:"deleteGoods.mdo",
      	type:"post",
      	headers:{
      		userid:userid,
      		token:"aaaa"
      	},
      	data:{
      		g_id:data.g_id
      	},
      	contentType:"application/x-www-form-urlencoded",
      	dataType:"json",
      	success:function(data){
      		console.log(data);
      		if(data.flag == true){
      			layer.close(index);
      			obj.del();
      			layer.msg('删除成功！');
      		}else{
      			layer.close(index);
      			layer.msg('删除失败！');
      		}
      	},
      	error:function(){
      		layer.msg('服务在加载中...');
      	}
      });
      
    });
  } else if(layEvent === 'edit'){
//    layer.msg('编辑管理员');
    layer.open({
        type: 2 //此处以iframe举例
        ,title: '编辑操作'
        ,area: ['590px', '460px']
        ,shade: 0
        ,maxmin: true
        /*,offset: [ //为了演示，随机坐标
          Math.random()*($(window).height()-300)
          ,Math.random()*($(window).width()-390)
        ] */
        ,content: './html/editGoods.html'
        ,btn: ['确认', '取消'] // 按钮
        ,yes: function(index, layero){
//	      	  layer.iframeAuto(index)
	      	  var body = layer.getChildFrame('body', index);
		      	 //表单提交验证
	    	  if(body.find("#demo1").click().val()=="true"){
	        	  console.log("修改商品关键校验成功");
	            // 编辑管理员
		      	  $.ajax({
		                url:'http://localhost:8080/SuperMarket/updateGoods.mdo',
		                type:'post',
		              	headers:{
		              		userid:userid,
		              		token:"aaaa"
		              	},
		                dataType:'json',
		                data:{
		                	g_id:body.find('#g_id').val(),
		                	g_name:body.find('#g_name').val(),
		                	g_price:body.find('#g_price').val(),
		                	g_code:body.find('#g_code').val(),
		                	g_promt_price:body.find('#g_promt_price').val(),
		                	g_promt_date_start:body.find('#g_promt_date_start').val(),
		                	/*g_promt_date_stop:body.find('#g_promt_date_stop').val(),*/
		                	g_promt_num_number:body.find('#g_promt_num_number').val(),
		                	g_discount:body.find('#g_discount').val(),
		                	g_promt_data:body.find('#g_promt_data').val(),
		                	g_promt_num:body.find('#g_promt_num').val(),
		                	g_stock:body.find('#g_stock').val(),
		                	g_stock_urgent:body.find('#g_stock_urgent').val(),
		                	g_plan:body.find('#g_plan').val(),
		                	g_sale:body.find('#g_sale').val(),
		                	mf_id:body.find('#mf_id').val(),
		                	sp_id:body.find('#sp_id').val()
		                },
		                success:function(data){
		                	console.log(data);
		                    if (data.flag == true) {
		                        layer.msg('修改成功！');
		                    }else {
		                        layer.msg('修改失败！');
		                    }
		                    setTimeout(function () {
		                        layer.closeAll();
		//                        var x={reload:function(){
		//                		    //执行重载
		//                		    table.reload('testReload');
		//                		    }}
		
		                        table.reload('testReload');
		                        }, 1000);
		                }
		            }); 
	      	  }
        }
	  	,headers:{
	  		userid:userid,
	  		token:"aaaa"
	  	}
        ,btn2: function(){
          layer.closeAll();
        }
        //,zIndex: layer.zIndex //重点1
        ,success: function(layero, index){
          //layer.setTop(layero); //重点2
      	//找到它的子窗口的body
          var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
          
          //时间判定
          var time1="";
          if(data.g_promt_date_start!="" && data.g_promt_date_stop!="" && data.g_promt_date_start!=undefined && data.g_promt_date_stop!=undefined){
              var time1 = (data.g_promt_date_start+" - "+data.g_promt_date_stop)
              }
          //为子窗口元素赋值
          body.contents().find("#g_id").val(data.g_id);
          body.contents().find("#g_name").val(data.g_name);
          body.contents().find("#g_price").val(data.g_price);
          body.contents().find("#g_code").val(data.g_code);
          body.contents().find("#g_promt_price").val(data.g_promt_price);
          body.contents().find("#g_promt_date_start").val(time1);
          /*body.contents().find("#g_promt_date_stop").val(data.g_promt_date_stop);*/
          body.contents().find("#g_promt_num_number").val(data.g_promt_num_number);
          body.contents().find("#g_discount").val(data.g_discount);
          body.contents().find("#g_promt_data").val(data.g_promt_data);
          body.contents().find("#g_promt_num").val(data.g_promt_num);
          body.contents().find("#g_stock").val(data.g_stock);
          body.contents().find("#g_stock_urgent").val(data.g_stock_urgent);
          body.contents().find("#g_plan").val(data.g_plan);
          body.contents().find("#g_sale").val(data.g_sale);
          body.contents().find("#mf_id").val(data.mf_id);
          body.contents().find("#sp_id").val(data.sp_id);
          console.log(data)
        }
      });
    
  }
});



});