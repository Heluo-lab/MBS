package com.mbs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.dao.ProductDao;
import com.mbs.dao.impl.ProductDaoimpl;
import com.mbs.dto.IDColorSizeOf;
@WebServlet("/imgreload")
public class ImgReload extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out =  resp.getWriter();
		int goodsid =Integer.parseInt(req.getParameter("goodsid"));
		String colorCode = req.getParameter("colorcode");
		ProductDao dao = new ProductDaoimpl();
		String idcs = dao.IdColorOfImg(goodsid, colorCode).getColorimage();
		out.print(idcs);
	}
	
}
