package com.mbs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.dao.OrderDao;
import com.mbs.dao.impl.OrderDaoImpl;
import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Account;
import com.mbs.pojo.Receivinggoods;

import net.sf.json.JSONObject;

@WebServlet("/addreceivinggoods")
public class AddReceivingGoodsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account info = (Account)req.getSession().getAttribute("account");
		String usersId = null;
		if (info==null) {
			resp.sendRedirect("login.jsp");
			return;
		}else {
			usersId = info.getAccountId();
		}
		OrderDao od = new OrderDaoImpl();
		String receMsg = req.getParameter("receivinggoods");
		JSONObject object = JSONObject.fromObject(receMsg);
		Receivinggoods receivinggoods = (Receivinggoods)JSONObject.toBean(object,Receivinggoods.class);
		receivinggoods.setUsersId(usersId);
		od.addAddress(JSONObject.fromObject(receivinggoods).toString(),usersId);
		PrintWriter out = resp.getWriter();
		out.print(JSONObject.fromObject(receivinggoods).toString());
	}

}
