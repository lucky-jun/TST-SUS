layui.use(['form', 'layedit', 'laydate','layer'], function(){
	var layer = layui.layer;
	var form = layui.form;
	var $ = layui.$;
	

	var g_nameC = false;
	var g_priceC = false;
	var g_codeC = false;
	var g_stockC = false;
	var g_numberC = false;
	var mf_nameC = false;
	var sp_nameC = false;
	var g_salesC = false;
	
//	console.log("66");
//		function LshowTip(spanID, msg) {
//		    var span = document.getElementById(spanID);
//		    span.innerHTML = msg;
//		}
//		function Lcheckg_name(obj) {
//		    var g_name = obj.value;
//		    var span = document.getElementById("span_g_name");
//
//		    if(g_name.length>0){
//		        span.innerHTML = "<font color='green'></font>"
//		        g_nameC = true;
//		    }else{
//		        span.innerHTML = "<font color='red'>未输入值</font>"
//		        g_nameC = false;
//		    }
//		}
//		function Lcheckg_price(obj) {
//			var g_price = obj.value;
//			var span = document.getElementById("span_g_price");
//			
//			if(g_price.length>0){
//				span.innerHTML = "<font color='green'></font>"
//					g_priceC = true;
//			}else{
//				span.innerHTML = "<font color='red'>未输入值</font>"
//					g_priceC = false;
//			}
//		}
//		function Lcheckg_code(obj) {
//			var g_code = obj.value;
//			var span = document.getElementById("span_g_code");
//			
//			if(g_code.length>0){
//				span.innerHTML = "<font color='green'></font>"
//					g_codeC = true;
//			}else{
//				span.innerHTML = "<font color='red'>未输入值</font>"
//					g_codeC = false;
//			}
//		}
//		function Lcheckg_stock(obj) {
//			var g_stock = obj.value;
//			var span = document.getElementById("span_g_stock");
//			
//			if(g_stock.length>0){
//				span.innerHTML = "<font color='green'></font>"
//					g_stockC = true;
//			}else{
//				span.innerHTML = "<font color='red'>未输入值</font>"
//					g_stockC = false;
//			}
//		}
//
//		function Lcheckflage() {
//			//调用另一个js中的nihao()方法
////			nihao();
////			console.log("++"+g_nameC);
////			console.log("++"+g_priceC);
////			console.log("++"+g_codeC);
////			console.log("++"+g_stockC);
////			console.log("--"+g_nameC && g_priceC && g_codeC && g_stockC);
//			console.log("11111111");
//			document.getElementById("submit").onclick=function(){ this.value=Lcheckflage();}
//			console.log("修改校验："+(g_nameC && g_priceC && g_codeC && g_stockC));
//		    return g_nameC && g_priceC && g_codeC && g_stockC;
//		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	var g_nameC = false;
//	var g_priceC = false;
//	var g_codeC = false;
//	var g_stockC = false;
//	var g_numberC = false;
//	var mf_nameC = false;
//	var sp_nameC = false;
//	var g_salesC = false;
//	
	var g_name = false;
	var g_price = false;
	var g_code = false;
	var g_number = false;
	var mf_name = false;
	var sp_name = false;
	var g_sales = false;

//	var gg_name=111;
	//自定义验证规则
	form.verify({
	  g_name: function(value){
//		 var g2_name=false;
		  console.log("aaaaaaaaa");
	    if(value.length < 1){
	    	g_name=false;
			console.log("g_name+++++++++++:"+g_name);
	    	return '商品价格未输入';
//	      return '商品名称至少1个';
	    }else{
	    	g_name=true
			console.log("g_name++:"+g_name);
	    }
		console.log("g_name++++++:"+g_name);
//		window.gg_name = g_name;
//		return 'as';
	  }
	  ,pass: [
	    /^[\S]{6,12}$/
	    ,'密码必须6到12位，且不能出现空格'
	  ]
	  ,g_price:function(value){
		    if(value.length < 1){
			      return '商品价格未输入';
			    }else{
			    	g_price=true
			    }
			  }
	  ,g_code:function(value){
		    if(value.length < 1){
			      return '商品条形码未输入';
			    }else{
			    	g_code=true
			    }
			  }
	  ,g_number:function(value){
		    if(value.length < 1){
			      return '商品数量未输入';
			    }else{
			    	g_number=true
			    }
			  }
	  ,mf_name:function(value){
		    if(value.length < 1){
			      return '商品生产厂商未选择';
			    }else{
			    	mf_name=true
			    }
			  }
	  ,sp_name:function(value){
		    if(value.length < 1){
			      return '商品供货商未选择';
			    }else{
			    	sp_name=true
			    }
			  }
	  ,g_sales:function(value){
		    if(value.length < 1){
			      return '商品是否允许销售未选择';
			    }else{
			    	g_sales=true
			    }
			  }
	});
	
/*	  //监听提交
	  window.che =function (){
		  console.log("4444444444444");
		 form.on('submit(demo1)', function(data){
		  console.log("x1:"+g_name);
		  console.log("x2:"+g_price);
		  console.log(g_name&&g_price)
	    return false;
	  });}*/
	
	var _formcheck =  {
			check2: function(){
//				console.log("g_name----------:"+_g_name.hah());
				console.log("1111111111");
				console.log("gg_name:"+gg_name);
//				console.log("g_name:"+g2_name);
				console.log("g_price:"+g_price);
				console.log("g_code:"+g_code);
				console.log("g_number:"+g_number);
				console.log("mf_name:"+mf_name);
				console.log("sp_name:"+sp_name);
				console.log("g_sales:"+g_sales);
				console.log("all:"+g_name && g_price && g_code && g_number && mf_name && sp_name && g_sales);
				
//		alert("表单校验的值："+g_name && g_price && g_code && g_number && mf_name && sp_name && g_sales);
		layer.alert("表单校验的值："+g_name && g_price && g_code && g_number && mf_name && sp_name && g_sales);
		return g_name && g_price && g_code && g_number && mf_name && sp_name && g_sales;
	}}
	window.formcheck = _formcheck;
})
//	var xxx = formcheck()
//	alert("1111111112222222222:"+xxx);