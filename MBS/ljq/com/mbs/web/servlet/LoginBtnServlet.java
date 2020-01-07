package com.mbs.web.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		//登录类别
		//String loginsort =req.getParameter("loginsort");
		//普通登录
		//if ("ordinary".equals(loginsort)) {
			//登录邮箱
			String loginid =req.getParameter("loginid");
			loginid =URLDecoder.decode(loginid, "UTF-8");
			//登录密码
			String loginpwd =req.getParameter("loginpwd");
			loginpwd =URLDecoder.decode(loginpwd, "UTF-8");
			//检验是否存在
			Account account =service.queryAccount(loginid);
			//如果用户为null
			if (account==null) {
				//告诉前台传的是json
				resp.setCharacterEncoding("UTF-8");
				resp.setHeader("Content-Type", "application/text;charset=utf-8");
				String loginMsg ="error";
				resp.getWriter().print(loginMsg);
			}else {
				//该用户存在，判断密码是否正确
				//获取该用户的密码
				String pwd =account.getAccountPass();
				//密码正确
				if (pwd.equals(loginpwd)) {
					//将该用户存在session里,方便获取该用户名字
					req.getSession().setAttribute("account", account);
					//告诉前台传的是json
					resp.setCharacterEncoding("UTF-8");
					resp.setHeader("Content-Type", "application/json;charset=utf-8");
					JSONObject jo =JSONObject.fromObject(account);
					resp.getWriter().print(URLDecoder.decode(jo.toString()));
				}
				//密码不正确
				else {
					//告诉前台传的是json
					resp.setCharacterEncoding("UTF-8");
					resp.setHeader("Content-Type", "application/text;charset=utf-8");
					String loginMsg ="error";
					resp.getWriter().print(loginMsg);
				}
			}
	//	}
		/*
		 * //无密码登录 else if ("other".equals(loginsort)) { //登录邮箱 String loginmob
		 * =req.getParameter("loginmob"); loginmob =URLDecoder.decode(loginmob,
		 * "UTF-8"); //登录口令 String logincode =req.getParameter("logincode"); logincode
		 * =URLDecoder.decode(logincode, "UTF-8"); //获取session存的验证码 String servercode
		 * =req.getSession().getAttribute("emailMsg").toString(); //判断验证码是否正确 if
		 * (servercode.equals(logincode)) { //检验该用户是否存在 Account account
		 * =service.queryAccount(loginmob); //用户不存在 if (account==null) { //告诉前台传的是json
		 * resp.setCharacterEncoding("UTF-8"); resp.setHeader("Content-Type",
		 * "application/json;charset=utf-8"); String loginMsg ="error";
		 * resp.getWriter().print(loginMsg); }else { //将该用户存入session中
		 * req.getSession().setAttribute("account", account.toString()); //告诉前台传的是json
		 * resp.setCharacterEncoding("UTF-8"); resp.setHeader("Content-Type",
		 * "application/json;charset=utf-8"); JSONObject jo
		 * =JSONObject.fromObject(account);
		 * resp.getWriter().print(URLDecoder.decode(jo.toString())); } }else { //验证码错误
		 * //告诉前台传的是json resp.setCharacterEncoding("UTF-8");
		 * resp.setHeader("Content-Type", "application/json;charset=utf-8"); String code
		 * ="code"; resp.getWriter().print(code); } }
		 */
	}
}
