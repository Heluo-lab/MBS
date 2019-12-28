package com.mbs.web.servlet.ljq;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.service.ljq.AccountService;
import com.mbs.service.ljq.impl.AccountServiceImpl;

import net.sf.json.JSONObject;

/**
 * 查询注册用户邮箱
 * @author Administrator
 *
 */

@WebServlet("/accountEmail")
public class SelectRegisterAccountEmailServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountService service =new AccountServiceImpl();
		//拿到请求里的邮箱
		String email =req.getParameter("registerid");
		email =URLDecoder.decode(email, "UTF-8");
		//从数据库查询注册邮箱
		boolean flag =service.queryAccountEmail(email);
		//告诉前台传的是json
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Type", "application/json;charset=utf-8");
		resp.getWriter().print(flag);
	}
}
