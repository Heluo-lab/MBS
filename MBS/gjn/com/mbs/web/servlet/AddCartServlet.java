package com.mbs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.dao.ProductDao;
import com.mbs.dao.impl.ProductDaoimpl;
import com.mbs.dto.IDColorSizeOf;

import net.sf.json.JSONObject;

public class AddCartServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		req.getParameter("id");
		ProductDao pd = new ProductDaoimpl();
		IDColorSizeOf msg = pd.LoadingfoGoodsID(Integer.parseInt(req.getParameter("goodsid")));
		out.print(JSONObject.fromObject(msg));
	}

}
