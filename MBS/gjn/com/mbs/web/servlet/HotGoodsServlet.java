package com.mbs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.pojo.Goods;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/hotgoods")
public class HotGoodsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Goods goods = new Goods();
		List<Goods> list = new ArrayList<Goods>();
		PrintWriter out = resp.getWriter();
		goods.setId(1);
		goods.setGoodsName("蒙蒂埃莫羊绒手感时尚字母logo提花翻边针织羊毛帽");
		goods.setPrice(79);
		goods.setShowImage("http://images6.monteamor.com/ProductImg/3/1804/middle/068218403-075-01-M.jpg");
		list.add(goods);
		Goods goods1 = new Goods();
		goods1.setId(2);
		goods1.setGoodsName("蒙蒂埃莫意式经典舒适微弹混纺百搭常规版男士休闲长裤");
		goods1.setPrice(198);
		goods1.setShowImage("http://images6.monteamor.com/ProductImg/3/1902/middle/065019103-009-01-M.jpg");  
		list.add(goods1);
		out.print(JSONArray.fromObject(list));
	}

}
