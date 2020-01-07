package com.mbs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.dao.OrderDao;
import com.mbs.dao.impl.OrderDaoImpl;
import com.mbs.pojo.Receivinggoods;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/newaddress")
public class NewAddressServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderDao od = new OrderDaoImpl();
		String receMsg = req.getParameter("receivinggoods");
		JSONObject object = JSONObject.fromObject(receMsg);
		Receivinggoods receivinggoods = (Receivinggoods)JSONObject.toBean(object,Receivinggoods.class);
		//usersid
		receivinggoods.setUsersId("1");
		od.addAddress(JSONObject.fromObject(receivinggoods).toString());
		//usersid
		List<Receivinggoods> list = od.selectAddress("1");
		PrintWriter out = resp.getWriter();
		out.print(JSONArray.fromObject(list).toString());
	}


}
