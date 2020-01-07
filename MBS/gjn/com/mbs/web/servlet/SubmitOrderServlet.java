package com.mbs.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.dao.CartDao;
import com.mbs.dao.OrderDao;
import com.mbs.dao.impl.CartDaoImpl;
import com.mbs.dao.impl.OrderDaoImpl;

@WebServlet("/submitoreder")
public class SubmitOrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartDao cd = new CartDaoImpl();
		OrderDao od = new OrderDaoImpl();
		od.submitOrder("1");
		cd.deleteCart("1");
		resp.sendRedirect("submitorder.jsp");
	}

}
