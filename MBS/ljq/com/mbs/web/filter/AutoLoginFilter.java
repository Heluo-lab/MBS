package com.mbs.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.pojo.Account;
import com.mbs.service.AccountService;
import com.mbs.service.impl.AccountServiceImpl;

/**
 * 自动登录
 * @author Administrator
 *
 */
@WebFilter("/*")
public class AutoLoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//强转成httpservletrequest
		HttpServletRequest req =(HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//从session获取用户
		Account account =(Account)req.getSession().getAttribute("account");
		String uri = req.getRequestURI();
		//是自动登录
		if("/MBS/login.jsp".equals(uri) && account != null) {
			//从session获取自动登录的标识
			String loginsymbol =req.getSession().getAttribute("loginsymbol").toString();
			if ("autologin".equals(loginsymbol)) {
				resp.sendRedirect("index");
			}
		}
//		//记住密码
//		if ("/MBS/login.jsp".equals(uri) && account != null && "rempwd".equals(loginsymbol)) {
//			
//		}
		
		//未登录
		if (account == null) {
			String cookie_loginid =null;
			String cookie_loginpwd =null;
			//获取携带用户名和密码cookie
			Cookie[] cookies =req.getCookies();
			if (cookies !=null) {
				for (Cookie cookie : cookies) {
					//获得想要的coookie
					if ("cookie_loginid".equals(cookie.getName())) {
						cookie_loginid =cookie.getValue();
					}
					if ("cookie_loginpwd".equals(cookie.getName())) {
						cookie_loginpwd =cookie.getValue();
					}
				}
			}
			//cookie里面存有该用户
			if (cookie_loginid!=null && cookie_loginpwd!=null) {
				//去数据库查询
				AccountService service =new AccountServiceImpl();
				//检验是否存在
				Account acc =service.login(cookie_loginid, cookie_loginpwd);
				//该用户存在
				if (acc !=null) {
					//完成自动登录
					req.getSession().setAttribute("account", account);
				}
			}
		}
		//放行
		chain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
