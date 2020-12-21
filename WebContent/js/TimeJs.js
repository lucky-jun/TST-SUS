layui.use(['laydate','layer'], function(){
  var laydate = layui.laydate;
/*  var data = new Date();
  alert(data);
alert('new Date()');*/
//执行一个laydate实例
  laydate.render({
  elem: '#g_promt_date_start', //指定元素
  /* value: 'new Date()', */
  isInitValue: false, 
  format: 'yyyy-MM-dd HH:mm',
  /*min: 'new Date()' ,//设定最小日期为当前日期*/
  min: 'new Date()' ,//设定最小日期为当前日期
  max: 90, //设置当前日期后最大可选择天数
  theme: '#ABDCFF',//主题显示
  range: true,
  trigger: 'click',//呼出事件改成click
  type: 'datetime', //选择时间
  });
/*  laydate.render({
	  elem: '#g_promt_date_stop', //指定元素
	   value: 'new Date()', 
	  isInitValue: false, 
	  format: 'yyyy-MM-dd',
	  min: data+1 ,//设定最小日期为当前日期
	  max: 90, //设置当前日期后最大可选择天数
	  theme: '#ABDCFF',//主题显示
	  type: 'datetime', //选择时间
  });*/
})

 