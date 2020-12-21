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
		//��ȡURI
		String requestURI = request.getRequestURI();
		System.out.println("����ĵ�ַΪ��"+requestURI);
		
		response.setHeader("Access-Control-Allow-Oringin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTINOS,DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Header", "x-requested-with");
		response.setHeader("Access-Control-Allow-Credentials", "true");// �Ƿ�֧��cookie
		
		//��ȡ����ͷ���õ�userid
		String userid = request.getHeader("userid");
		System.out.println("+++++++++userid:"+userid);
		
		if (userid != null && userid != "") {// �ж��Ƿ���userid
			System.out.println("����ͨ��������userid��");
			//��������
			filter.doFilter(req, res);
			
		} else {
			System.out.println("�������أ�userid������");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charsetUTF-8");
			//����responseText�����Դ����жϽ���������ת
			response.getWriter().print("Header has no value");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
