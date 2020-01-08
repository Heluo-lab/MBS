package com.mbs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.dao.ProductDao;
import com.mbs.dao.impl.ProductDaoimpl;
import com.mbs.dto.DataMapping;
import com.mbs.pojo.Color;

import net.sf.json.JSONObject;
@WebServlet("/getsize")
public class GetSizeServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out =  resp.getWriter();
		int goodsid =Integer.parseInt(req.getParameter("goodsid"));
		String colorCode = req.getParameter("colorcode");
		ProductDao dao = new ProductDaoimpl();
		dao.IdToColor(goodsid);
		
		List<DataMapping> colorCodelist = dao.IdToColor(goodsid).getColorCode();
//		for (DataMapping dataMapping : colorCodelist) {
//			System.out.println(dataMapping);
//		}
		//颜色集合
		List<Color> colorlist = dao.ColorCodeAndGoodsIdOfColorNameAndColorImg(goodsid);
//		尺码集合
		String colorsize = colorCodelist.get(0).getSizes();
		for (DataMapping color : colorCodelist) {
			if(colorCode.equals(color.getColorCode())) {
				colorsize=color.getSizes();
			}
		}
		out.print(colorsize);
	}
	
}
