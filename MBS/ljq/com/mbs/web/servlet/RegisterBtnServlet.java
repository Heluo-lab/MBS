package com.mbs.web.servlet;


import java.io.IOException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.pojo.Account;
import com.mbs.service.AccountService;
import com.mbs.service.impl.AccountServiceImpl;

/**
 * 注册按钮
 * @author Administrator
 *
 */

@WebServlet("/registerBtn")
public class RegisterBtnServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取传过来的值
		//注册昵称
		String registername =req.getParameter("registername");
		registername=URLDecoder.decode(registername, "UTF-8");
		//注册邮箱
		String registerid =req.getParameter("registerid");
		registerid=URLDecoder.decode(registerid, "UTF-8");
		//注册密码
		String registerpwd =req.getParameter("registerpwd");
		registerpwd=URLDecoder.decode(registerpwd, "UTF-8");
		//注册验证码
		String registercode =req.getParameter("registercode");
		registercode=URLDecoder.decode(registercode, "UTF-8");
		//注册时间
		String registerbirth =req.getParameter("registerbirth");
		registerbirth=URLDecoder.decode(registerbirth, "UTF-8");
//		Date date =new Date();
//		//年
//		int year =date.getYear()+1900;
//		//月
//		int m =date.getMonth()+1;
//		String month =m<10 ? "0"+m : ""+m;
//		//日
//		int d =date.getDate();
//		String day =d<10 ? "0"+d : ""+d;
//		//注册时间
//		String registerbirth =year+"/"+month+"/"+day;
		//获取session里面的验证码
		String servercode =req.getSession().getAttribute("emailMsg").toString();
		//判断验证码是否正确
		if (servercode.equals(registercode)) {
			AccountService service =new AccountServiceImpl();
			Account account =new Account();
			account.setAccountId(UUID.randomUUID().toString());
			account.setAccountName(registername);
			account.setAccountEmail(registerid);
			account.setAccountPass(registerpwd);
			account.setAccountBirth(registerbirth);
			boolean flag =service.insertAccount(account);
//			if (flag) {
//				//注册成功,重定向到登录页面
//				resp.sendRedirect("login.jsp?registeremail"+registerid);
//			}else {
//				//注册失败
//				req.getSession().setAttribute("msg", "注册失败，请重新注册!");
//				//跳转到注册页面
//				req.getRequestDispatcher("/register.jsp").forward(req, resp);
//			}
			//告诉前台传的是json
			resp.setCharacterEncoding("UTF-8");
			resp.setHeader("Content-Type", "application/json;charset=utf-8");
			resp.getWriter().print(flag);
		}else {
//			//传验证码错误
//			req.getSession().setAttribute("msg", "动态验证码错误！");
//			//跳转到注册页面
//			req.getRequestDispatcher("/register.jsp").forward(req, resp);
			//告诉前台传的是json
			resp.setCharacterEncoding("UTF-8");
			resp.setHeader("Content-Type", "application/json;charset=utf-8");
			String code ="code";
			resp.getWriter().print(code);
		}
	}
}

