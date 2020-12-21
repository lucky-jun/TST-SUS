package com.j.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebFilter("/MyFilter")*/
public class MyFilter implements Filter {

	public MyFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//获取URI
		String requestURI = request.getRequestURI();
		System.out.println("请求的地址为："+requestURI);
		
		response.setHeader("Access-Control-Allow-Oringin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTINOS,DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Header", "x-requested-with");
		response.setHeader("Access-Control-Allow-Credentials", "true");// 是否支持cookie
		
		//获取请求头设置的userid
		String userid = request.getHeader("userid");
		System.out.println("+++++++++userid:"+userid);
		
		if (userid != null && userid != "") {// 判断是否有userid
			System.out.println("请求通过，存在userid。");
			//放行链接
			filter.doFilter(req, res);
			
		} else {
			System.out.println("请求被拦截！userid不存在");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charsetUTF-8");
			//返回responseText，并以此做判断进行链接跳转
			response.getWriter().print("Header has no value");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
