package com.mbs.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CORS
 */
@WebFilter("/*")
public class CORS implements Filter {

    /**
     * Default constructor. 
     */
    public CORS() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse Hresponse = (HttpServletResponse) response;
		Hresponse.setHeader("Access-Control-Allow-Origin", "*");
		Hresponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		Hresponse.setHeader("Access-Control-Allow-Credentials", "true");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
