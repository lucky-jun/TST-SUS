package com.j.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.j.service.EmployeeService;
import com.j.service.impl.EmployeeServiceImpl;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService = new EmployeeServiceImpl();
       
    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");	

		Map<String,Object> map = new HashMap<String , Object>();
		System.out.println("µÇÂ¼µÄÓÃ»§Ãû£º"+username);
		System.out.println("µÇÂ¼µÄÃÜ    Âë£º"+password);
		if(username!=null) {
			Map<String, Object> queryPassword = employeeService.queryPassword(username, password);
//			System.out.println("µÇÂ¼ÅÐ¶Ïflag£º"+queryPassword.get("flag"));
//			System.out.println("µÇÂ¼ÅÐ¶Ïflag++++£º"+queryPassword.get("flag").equals(true));
			if(queryPassword.get("flag").equals(true)) {
				String sessionId = request.getSession().getId();
				map.put("userid", sessionId);
				map.put("id", queryPassword.get("id"));
				map.put("type", queryPassword.get("type"));
//				map.put("type", queryPassword.get("type"));
				response.getWriter().write(JSON.toJSONString(map));
			}else {
//				Map<String,Object> map = new HashMap<String , Object>();
				map.put("userid", 0);
				response.getWriter().write(JSON.toJSONString(map));
			}
		}else {
//			Map<String,Object> map = new HashMap<String , Object>();
			map.put("userid", 0);
			response.getWriter().write(JSON.toJSONString(map));
		}
	}

}
