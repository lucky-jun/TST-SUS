package com.j.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.j.pojo.Manufacturer;
import com.j.service.ManufacturerService;
import com.j.service.impl.ManufacturerServiceImpl;

//@WebServlet("/MFGetData")
public class MFGetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManufacturerService mfService = new ManufacturerServiceImpl();
       
    public MFGetData() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("请求MFGetData成功");
			String requestURI = request.getRequestURI();
			System.out.println(requestURI);
			String method = requestURI.substring(18, requestURI.length()-5);
			System.out.println(method);
			try {
				Method declaredMethod = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
				declaredMethod.invoke(this,request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	//查询全部信息——下拉框赋值
	private void selectGetData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("json/html;charsetUTF-8");
		List<Manufacturer> list = mfService.queryAllMF();
//		System.out.println(list);
		List<String> list2 = new ArrayList<String>();
		for(Manufacturer li:list) {
//			System.out.println(li.getM_name());
			list2.add(li.getM_name());
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("data", list);
		map.put("code", 0);
		map.put("msg", "");
//		System.out.println("list.size():"+list.size());
		map.put("count", list.size());
//		System.out.println(list2);
		response.getWriter().write(JSON.toJSONString(map));
	}

}
