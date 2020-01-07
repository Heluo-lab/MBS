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

import net.sf.json.JSONObject;

@WebServlet("/cancelchange")
public class CancelChangeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderDao od = new OrderDaoImpl();
		List<Receivinggoods> list = od.selectAddress("1");
		Receivinggoods recegoods = new Receivinggoods();
		for (Receivinggoods receivinggoods : list) {
			if (receivinggoods.getIsDefault()==1) {
				recegoods = receivinggoods;
			}
		}
		PrintWriter out = resp.getWriter();
		out.print(JSONObject.fromObject(recegoods));
	}

}
