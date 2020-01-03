package com.mbs.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 对请求SelfServlet的信息进行分发处理
 * @author heluo
 *
 */
public class SelfServletDispatcher extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String methodName = request.getParameter("method");
			Class clz = this.getClass();
			Method method = clz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			System.out.println(methodName);
			method.invoke(this, request,response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
