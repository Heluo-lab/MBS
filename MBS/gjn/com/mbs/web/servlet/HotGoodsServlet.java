package com.mbs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.pojo.Goods;

import net.sf.json.JSONObject;

public class HotGoodsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Goods goods = new Goods();
		PrintWriter out = resp.getWriter();
		goods.setId(1);
		goods.setGoodsName("蒙蒂埃莫羊绒手感时尚字母logo提花翻边针织羊毛帽");
		goods.setPrice(79);
		goods.setShowImage("http://images6.monteamor.com/ProductImg/3/1804/middle/068218403-075-01-M.jpg");
		out.print(JSONObject.fromObject(goods));
	}

}
