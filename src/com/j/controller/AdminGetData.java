package com.j.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.j.pojo.Goods;
import com.j.pojo.Manufacturer;
import com.j.pojo.Supplier;
import com.j.pojo.Warehousing;
import com.j.service.GoodsGetDataService;
import com.j.service.ManufacturerService;
import com.j.service.SupplierService;
import com.j.service.WarehousingService;
import com.j.service.impl.GoodsGetDataServiceImpl;
import com.j.service.impl.ManufacturerServiceImpl;
import com.j.service.impl.SupplierServiceImpl;
import com.j.service.impl.WarehousingServiceImpl;


//@WebServlet("/AdminGetData")
public class AdminGetData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	GoodsGetDataService goodsGDS = new GoodsGetDataServiceImpl();
	WarehousingService warehousingService = new WarehousingServiceImpl();
	ManufacturerService manufacturerService= new ManufacturerServiceImpl();
	SupplierService supplierServiceImpl = new SupplierServiceImpl();
	
    public AdminGetData() {
//    	
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	String userid = request.getParameter("userid");
		System.out.println("请求AdminGetData成功");
//		String userid = request.getHeader("userid");
//		System.out.println("1231231::"+userid);
//    	if(userid==""||userid==null) {
//			Map<String, Object> map = new HashMap<String, Object>();
//			System.out.println("userid为空");
//			map.put("code", 0);
//			map.put("data", "");
//			map.put("count",0);
//			response.getWriter().write(JSON.toJSONString(map));
//    	}else {
		
		//获取URI并进行截取方法名进行方法请求
			String requestURI = request.getRequestURI();
			System.out.println("地址截取前："+requestURI);
			String method = requestURI.substring(13, requestURI.length()-4);
			System.out.println("地址截取后："+method);
			
			//搜索单选选项条件值
//			String check = request.getParameter("check");
//			System.out.println("单选check值："+check);
			
			try {
				Method declaredMethod = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
				declaredMethod.invoke(this,request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
//    	}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
//	获取分页
	private void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/javascript;charset=UTF-8");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		System.out.println("页数请求："+page);
		System.out.println("条数请求："+limit);
		Map<String, Object> map = goodsGDS.queryPageGoods(Integer.parseInt(page), Integer.parseInt(limit));
		response.setCharacterEncoding("UTF-8");
		response.setContentType("json/html;charsetUTF-8");
		response.getWriter().write(JSON.toJSONString(map));
	}
//	 添加新商品
	private void addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/* int g_id = Integer.parseInt(request.getParameter("g_id")); */
		String g_name = request.getParameter("g_name");
		double g_price = Integer.parseInt(request.getParameter("g_price"));
		int g_code = Integer.parseInt(request.getParameter("g_code"));
		System.out.println("111:"+request.getParameter("g_promt_price"));
		double g_promt_price =0;
		if(request.getParameter("g_promt_price")!="") {
		g_promt_price = Integer.parseInt(request.getParameter("g_promt_price"));
		}
		
		
//		时间
		String time = request.getParameter("g_promt_date_start");
		System.out.println("获取的时间："+time);
		String g_promt_date_start = "";
		String g_promt_date_stop ="";
		//时间不为空则进行时间的截取
		if(!time.equals("")) {
//			System.out.println(time.equals(""));
//			System.out.println("------------");
			g_promt_date_start = time.substring(0, 16);
			g_promt_date_stop = time.substring(19, time.length());
			System.out.println("截取开始时间："+g_promt_date_start);
			System.out.println("截取结束时间："+g_promt_date_stop);
			}
		
//		String g_promt_date_start = request.getParameter("g_promt_date_start");
//		String g_promt_date_stop = request.getParameter("g_promt_date_stop");
		int g_promt_num_number =0;
		if(request.getParameter("g_promt_price")!="") {
			g_promt_num_number = Integer.parseInt(request.getParameter("g_promt_num_number"));
		}
		int g_discount =0;
		if(request.getParameter("g_promt_price")!="") {
			g_discount = Integer.parseInt(request.getParameter("g_discount"));
		}
		int g_promt_data =0;
		if(request.getParameter("g_promt_price")!="") {
			g_promt_data = Integer.parseInt(request.getParameter("g_promt_data"));
		}
		int g_promt_num =0;
		if(request.getParameter("g_promt_price")!="") {
			g_promt_num = Integer.parseInt(request.getParameter("g_promt_num"));
		}
		int g_stock =0;
		if(request.getParameter("g_promt_price")!="") {
			g_stock = Integer.parseInt(request.getParameter("g_stock"));
		}
		int g_stock_urgent =0;
		if(request.getParameter("g_promt_price")!="") {
			g_stock_urgent = Integer.parseInt(request.getParameter("g_stock_urgent"));
		}
		int g_plan =0;
		if(request.getParameter("g_promt_price")!="") {
			g_plan = Integer.parseInt(request.getParameter("g_plan"));
		}
		int g_sale =0;
		if(request.getParameter("g_promt_price")!="") {
			g_sale = Integer.parseInt(request.getParameter("g_sale"));
		}
		
		//生产厂商
		int mf_id = Integer.parseInt(request.getParameter("mf_name"));
//		String mf_name = request.getParameter("mf_name");
//		String mf_add = request.getParameter("mf_add");
//		String mf_tel = request.getParameter("mf_tel");
		//供应商
		int sp_id = Integer.parseInt(request.getParameter("sp_name"));
//		String sp_name = request.getParameter("sp_name");
//		String sp_add = request.getParameter("sp_add");
//		String sp_tel = request.getParameter("sp_tel");
		
		//返回值判断
		Map<String, Object> map = new HashMap<String, Object>();
		//商品判断
		Map<String, Object> queryByCode = goodsGDS.queryByCode(g_code);
		
		//条形码判断商品是否存在
//		System.out.println(queryByCode.get("flag"));
//		System.out.println(queryByCode.get("flag").equals("空"));
		if(queryByCode.get("flag").equals("空")) {
			//供应商判断
//			Supplier supplier = new Supplier(sp_id, sp_name, sp_add, sp_tel);
//			Map<String, Object> insertSupplier = supplierServiceImpl.insertSupplier(supplier);
			//生产厂商判断
//			Manufacturer manufacturer = new Manufacturer(mf_id, mf_name, mf_add, mf_tel);
//			Map<String, Object> insertManufacturer = manufacturerService.insertManufacturer(manufacturer);
			//商品判断
			Goods goods = new Goods(g_name, g_price, g_code, g_promt_price, g_promt_date_start, g_promt_date_stop, g_promt_num_number, g_discount, g_promt_data, g_promt_num, g_stock, g_stock_urgent, g_plan, g_sale, mf_id, sp_id);
			Map<String, Object> insertGoods = goodsGDS.insertGoods(goods);
			//添加进货单
			Warehousing warehousing = new Warehousing(0, g_name, g_stock, g_price, (g_stock*g_price));
			Map<String, Object> insertWarehousing = warehousingService.insertWarehousing(warehousing);
			
			if(insertGoods.get("flag").equals("true")&&insertGoods.get("flag").equals("false")) {
				map = insertGoods;
//			}else if(insertSupplier.get("flag").equals("true") && insertManufacturer.get("flag").equals("true") && insertGoods.get("flag").equals("true")) {
			}else if( insertGoods.get("flag").equals("true")) {
				map.put("flag","true");
			}else {
				map.put("flag","false");
			}
		}else {
			map.put("flag", "该商品已存在，请查找仔细查找！");
		}
		
		
		
		
		
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("json/html;charsetUTF-8");
		response.getWriter().write(JSON.toJSONString(map));
	}
	
	
//	修改商品
	private void updateGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int g_id = Integer.parseInt(request.getParameter("g_id"));
		String g_name = request.getParameter("g_name");
		double g_price = Integer.parseInt(request.getParameter("g_price"));
		int g_code = Integer.parseInt(request.getParameter("g_code"));
		double g_promt_price = Integer.parseInt(request.getParameter("g_promt_price"));
		
//		时间
		String time = request.getParameter("g_promt_date_start");
		String g_promt_date_start="";
		String g_promt_date_stop="";
		System.out.println("修改商品的时间设定："+time);
		System.out.println("");
		if(time!=null&&time!="") {
			g_promt_date_start = time.substring(0, 16);
			g_promt_date_stop = time.substring(19, time.length());
		}
		/*
		 * String g_promt_date_start = request.getParameter("g_promt_date_start");
		 * String g_promt_date_stop = request.getParameter("g_promt_date_stop");
		 */
		
		System.out.println("g_promt_date_start:"+g_promt_date_start);
		System.out.println("g_promt_date_stop:"+g_promt_date_stop);
		
		
		int g_promt_num_number = Integer.parseInt(request.getParameter("g_promt_num_number"));
		int g_discount = Integer.parseInt(request.getParameter("g_discount"));
		int g_promt_data = Integer.parseInt(request.getParameter("g_promt_data"));
		int g_promt_num = Integer.parseInt(request.getParameter("g_promt_num"));
		int g_stock = Integer.parseInt(request.getParameter("g_stock"));
		int g_stockTianJia=0;
		//是否为添加商品数量方法判断
		System.out.println("是否为添加商品数量方法判断："+request.getParameter("g_stockTianJia"));
		if(request.getParameter("g_stockTianJia")!=null) {
			g_stockTianJia = Integer.parseInt(request.getParameter("g_stockTianJia"));
		}
		int g_stock_urgent = Integer.parseInt(request.getParameter("g_stock_urgent"));
		int g_plan = Integer.parseInt(request.getParameter("g_plan"));
		int g_sale = Integer.parseInt(request.getParameter("g_sale"));
		int mf_id = Integer.parseInt(request.getParameter("mf_id"));
		int sp_id = Integer.parseInt(request.getParameter("sp_id"));
		
		System.out.println("商品总量="+g_stock+"+"+g_stockTianJia+"="+(g_stock+g_stockTianJia));
		System.out.println("商品总价格="+g_price+"*"+g_stockTianJia+"="+(g_price*g_stockTianJia));
		
		Goods goods = new Goods(g_id, g_name, g_price, g_code, g_promt_price, g_promt_date_start, g_promt_date_stop, g_promt_num_number, g_discount, g_promt_data, g_promt_num, (g_stock+g_stockTianJia), g_stock_urgent, g_plan, g_sale, mf_id, sp_id);
		Map<String,Object> map = new HashMap<String , Object>();
		if(g_stockTianJia>0) {
			Warehousing warehousing = new Warehousing(g_id, g_name, g_stockTianJia, g_price, (g_price*g_stockTianJia));
			if((goodsGDS.updateGoods(goods).get("flag").equals(true))&&(warehousingService.insertWarehousing(warehousing).get("flag").equals(true))) {
				map.put("flag", true);
			}else {
				map.put("flag", false);
			}
		}else {
			map=goodsGDS.updateGoods(goods);
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("json/html;charsetUTF-8");
		response.getWriter().write(JSON.toJSONString(map));
	}
	
//	删除商品
	private void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String g_id = request.getParameter("g_id");
		String g_idList = request.getParameter("g_idList");
		Map<String, Object> map =null;
		//判断是否为批量删除
		if(g_idList!=null) {
			//批量删除，（（现未使用）将获取的ID以 "   ,   " 为界限分割获取值）
			System.out.println("未处理前批量删除ID："+g_idList);
			String substring = g_idList.substring(0,g_idList.length()-1);
//			将获取的ID以 "   ,   " 为界限分割获取值
//			String[] split = substring.split(",");
//			for(String a:split) {
//				System.out.println(a);
//			}
			System.out.println("已处理前批量删除ID："+substring);
			map = goodsGDS.deleteGoods(substring);
		}else {
			//单条数据删除
			map = goodsGDS.deleteGoods(g_id);
		}
		/* Map<String, Object> map = goodsGDS.deleteGoods(Integer.parseInt(g_id)); */
	    
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("flag", false);
		response.getWriter().write(JSON.toJSONString(map));
	}
	
//	下架商品
	private void updataSale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("*********");
//		int g_id = Integer.parseInt(request.getParameter("g_id"));
//		int g_sale = Integer.parseInt(request.getParameter("g_sale"));

		//判断是否为批量下架
		String g_idList = request.getParameter("g_idList");
		
		Map<String, Object> map =null;
		if(g_idList!=null) {
//			批量下架
			System.out.println("未处理前批量下架ID："+g_idList);
			String substring = g_idList.substring(0,g_idList.length()-1);
			System.out.println("已处理前批量下架ID："+substring);
			map = goodsGDS.updateSale(substring, 0);
			//返回下架标识：1上，0下
			map.put("value", 0);
		}else {
//			单条数据下架
			String g_id = request.getParameter("g_id");
			int g_sale = Integer.parseInt(request.getParameter("g_sale"));
			System.out.println("上下架g_id:"+g_id);
			System.out.println("上下架g_sale:"+g_sale);
			map = goodsGDS.updateSale(g_id, g_sale);
			//返回上下架标识：1上，0下
			map.put("value", g_sale);
		}
//		System.out.println("++++++:"+JSON.toJSONString(map));
//		System.out.println(map.get("flag"));
		response.setCharacterEncoding("UTF-8");
		response.setContentType("json/html;charsetUTF-8");
		response.getWriter().write(JSON.toJSONString(map));
	}
	
//	ID查询商品
	private void queryByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String managerID = request.getParameter("g_id");
		Map<String, Object> map = goodsGDS.queryByIDGoods(Integer.parseInt(managerID));
		System.out.println(JSON.toJSONString(map));
		response.setCharacterEncoding("UTF-8");
		response.setContentType("json/html;charsetUTF-8");
		response.getWriter().write(JSON.toJSONString(map));
	}
//	name查询商品
	private void queryByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String g_name = request.getParameter("g_name");
		Map<String, Object> map = goodsGDS.queryByNameGoods(g_name);
//		System.out.println(JSON.toJSONString(map));
		response.setCharacterEncoding("UTF-8");
		response.setContentType("json/html;charsetUTF-8");
		response.getWriter().write(JSON.toJSONString(map));
	}
}