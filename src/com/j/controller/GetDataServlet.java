package com.j.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

@WebServlet("/GetDataServlet.do")
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetDataServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("请求成功");
		String userid = request.getHeader("userid");
		System.out.println("1231231::"+userid);

		// 接下的是我们业务逻辑
		if(userid=="") {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("flag", "false");
			response.getWriter().write(JSON.toJSONString(map));
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("flag", "true");
			response.getWriter().write(JSON.toJSONString(map));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
