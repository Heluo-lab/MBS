package com.mbs.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mbs.pojo.Account;

/**
 * 权限管理  在用户登录时访问
 * @author heluo
 *
 */
public class PowerFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest Hrequest = (HttpServletRequest)request;
		HttpServletResponse Hresponse = (HttpServletResponse)response;
		HttpSession session = Hrequest.getSession();
		Account acc = new Account();
		acc.setAccountId("2");
		session.setAttribute("account",acc);
		Account account = (Account)session.getAttribute("account");
		if(account!=null){
			chain.doFilter(Hrequest, Hresponse);
		}else{
			Hresponse.sendRedirect("login.jsp");
			return;
		}
	}

	@Override
	public void destroy() {
		
	}
	
}
