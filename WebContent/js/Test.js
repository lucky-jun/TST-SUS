layui.use(['form', 'layedit', 'laydate','layer'], function () {
	
	console.log("222");
	  var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;
	  
	var g_name = false;
	var g_price = false;
	var g_code = false;
	var g_stock = false;
	  //自定义验证规则
	  form.verify({
		  g_name: function(value){
	 	   console.log("value:"+value);
	 	   if(value.length < 2){
	 		   console.log("g_name_n");
	 		   return 'g_name';
	 	   }else{
	 		   console.log("g_name_y");
	 		  g_name = true;
	 	   }
	    }
		  ,g_price: function(value){
			  console.log("value:"+value);
			  if(value.length < 2){
				  console.log("g_price_n");
				  return 'g_price';
			  }else{
		 		   console.log("g_price_y");
		 		  g_price = true;
		 	   }
		  }
		  ,g_code: function(value){
			  console.log("value:"+value);
			  if(value.length < 2){
				  console.log("g_code_n");
				  return 'g_code';
			  }else{
				  console.log("g_code_y");
				  g_code = true;
			  }
		  }
		  ,g_stock: function(value){
			  console.log("value:"+value);
			  if(value.length < 2){
				  console.log("g_stock_n");
				  return 'g_stock';
			  }else{
				  console.log("g_stock_y");
				  g_stock = true;
			  }
		  }
		  ,mf_id: function(value){
			  console.log("value:"+value);
			  if(value.length < 2){
				  console.log("g_stock_n");
				  return 'g_stock';
			  }else{
				  console.log("g_stock_y");
				  g_stock = true;
			  }
		  }
		  ,sp_id: function(value){
			  console.log("value:"+value);
			  if(value.length < 2){
				  console.log("g_stock_n");
				  return 'g_stock';
			  }else{
				  console.log("g_stock_y");
				  g_stock = true;
			  }
		  }
		  });
	 
	  //监听提交
	  window.che =function (){
		  console.log("33");
		 form.on('submit(demo1)', function(data){
		  console.log("g_name1:"+g_name);
		  console.log("g_price:"+g_price);
		  console.log("g_code:"+g_code);
		  console.log("g_stock:"+g_stock);
		  console.log(g_name && g_price && g_code && g_stock)
		  console.log("value修改前:"+this.value)
		  this.value=(g_name && g_price && g_code && g_stock);
		  console.log("value修改后:"+this.value)
	    return (g_name && g_price && g_code && g_stock);
	  });}
 });