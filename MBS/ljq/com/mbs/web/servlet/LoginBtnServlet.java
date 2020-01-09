package com.mbs.web.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.pojo.Account;
import com.mbs.service.AccountService;
import com.mbs.service.impl.AccountServiceImpl;

import net.sf.json.JSONObject;

/**
 * 登录按钮
 * @author Administrator
 *
 */

@WebServlet("/loginBtn")
public class LoginBtnServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountService service =new AccountServiceImpl();
		//获取传过来的值
		//获取记住密码
		String checkedpwd =req.getParameter("checkedpwd");
		//自动登录
		String checkedauto =req.getParameter("checkedauto");
		//登录邮箱
		String loginid =req.getParameter("loginid");
		loginid =URLDecoder.decode(loginid, "UTF-8");
		//登录密码
		String loginpwd =req.getParameter("loginpwd");
		loginpwd =URLDecoder.decode(loginpwd, "UTF-8");
		//检验是否存在
		Account account =service.login(loginid , loginpwd);
		//如果用户为null
		if (account==null) {
			//告诉前台传的是json
			resp.setCharacterEncoding("UTF-8");
			resp.setHeader("Content-Type", "application/text;charset=utf-8");
			String loginMsg ="error";
			resp.getWriter().print(loginMsg);
		}else {
			//该用户存在
			//将该用户存在session里,方便获取该用户名字
			req.getSession().setAttribute("account", account);
			//存一个标识到session中，用来标识记住密码还是自动登录,还是都没有勾选
			String loginsymbol="";
			//判断是否勾选了自动登录
			if ("true".equals(checkedauto)) {
				//存loginid到cookie
				Cookie cookie_loginid =new Cookie("cookie_loginid", loginid);
				cookie_loginid.setMaxAge(10*60);
				//存loginpwd到cookie
				Cookie cookie_loginpwd =new Cookie("cookie_loginpwd", loginpwd);
				cookie_loginpwd.setMaxAge(10*60);
				
				resp.addCookie(cookie_loginid);
				resp.addCookie(cookie_loginpwd);
				//存一个标识到session中，用来标识记住密码还是自动登录
				loginsymbol ="autologin";
				req.getSession().setAttribute("loginsymbol", loginsymbol);
			}
			//判断是否勾选了记住密码,且没有勾选自动登录
			if ("false".equals(checkedauto) && "true".equals(checkedpwd)) {
//				//存loginid到cookie
//				Cookie cookie_loginid =new Cookie("cookie_loginid", loginid);
//				cookie_loginid.setMaxAge(10*60);
//				//存loginpwd到cookie
//				Cookie cookie_loginpwd =new Cookie("cookie_loginpwd", loginpwd);
//				cookie_loginpwd.setMaxAge(10*60);
//				
//				resp.addCookie(cookie_loginid);
//				resp.addCookie(cookie_loginpwd);
				
				//存一个标识到session中，用来标识记住密码还是自动登录
				loginsymbol ="rempwd";
				req.getSession().setAttribute("loginsymbol", loginsymbol);
			}
			//记住密码，自动登录都没有勾选
			if ("false".equals(checkedauto) && "false".equals(checkedpwd)) {
				//存一个标识到session中，用来标识记住密码还是自动登录
				loginsymbol ="";
				req.getSession().setAttribute("loginsymbol", loginsymbol);
			}
			//告诉前台传的是json
			resp.setCharacterEncoding("UTF-8");
			resp.setHeader("Content-Type", "application/json;charset=utf-8");
			JSONObject jo =JSONObject.fromObject(account);
			resp.getWriter().print(URLDecoder.decode(jo.toString()));
		}
	}
}
