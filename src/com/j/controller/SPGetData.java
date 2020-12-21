package com.j.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.j.service.ManufacturerService;
import com.j.service.SupplierService;
import com.j.service.impl.SupplierServiceImpl;


//@WebServlet("/SPGetData")
public class SPGetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SupplierService spService = new SupplierServiceImpl();
    public SPGetData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("请求SPGetData成功");
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
//	查询全部信息——下拉框赋值
	private void selectGetData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("json/html;charsetUTF-8");
		Map<String, Object> queryAll = spService.queryAll();
		response.getWriter().write(JSON.toJSONString(queryAll));
	}
	
	
}
