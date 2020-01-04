package com.mbs.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.dao.CartDao;
import com.mbs.dao.impl.CartDaoImpl;

@WebServlet("/minuscart")
public class MinusCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartDao cd = new CartDaoImpl();
		int goodsId = Integer.parseInt(req.getParameter("goodsid"));
		int goodsNum = Integer.parseInt(req.getParameter("goodsnum"));
		cd.minusCart("1", goodsId, goodsNum);
	}

}
