package com.mbs.web.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.service.AccountService;
import com.mbs.service.impl.AccountServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 查询注册用户昵称
 */
@WebServlet("/accountName")
public class SelectRegisterAccountNameServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountService service =new AccountServiceImpl();
		//获取传过来的注册昵称
		String name =req.getParameter("registername");
		name =URLDecoder.decode(name, "UTF-8");
		//从数据库查询注册昵称
		boolean flag =service.queryAccountName(name);
		//告诉前台传的是json
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Type", "application/json;charset=utf-8");
		resp.getWriter().print(flag);
	}
}
