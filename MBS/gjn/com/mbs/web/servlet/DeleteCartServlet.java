package com.mbs.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.dao.CartDao;
import com.mbs.dao.impl.CartDaoImpl;
import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Account;

@WebServlet("/deletecart")
public class DeleteCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account info = (Account)req.getSession().getAttribute("account");
		String usersId = info.getAccountId();
		int goodsId = Integer.parseInt(req.getParameter("goodsid"));
		CartDao cd = new CartDaoImpl();
		String color = req.getParameter("color");
		String size = req.getParameter("size");
		cd.deleteCart(usersId, goodsId,color,size);
	}

}
