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

import com.mbs.dao.CartDao;
import com.mbs.dao.ProductDao;
import com.mbs.dao.impl.CartDaoImpl;
import com.mbs.dao.impl.ProductDaoimpl;
import com.mbs.dto.GoodsMsg;
import com.mbs.dto.IDColorSizeOf;
import com.mbs.pojo.CartItem;

import net.sf.json.JSONArray;


@WebServlet("/getcart")
public class GetCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartDao cd = new CartDaoImpl();
		double money = 0;
		List<CartItem> list = cd.selectAllCartId("1");
		List<GoodsMsg> msglist = new ArrayList<GoodsMsg>();
		for (CartItem cart : list) {
			ProductDao pd = new ProductDaoimpl();
			GoodsMsg goodsmsg = new GoodsMsg();
			IDColorSizeOf goods = pd.LoadingfoGoodsID(cart.getGoodsId());
			goodsmsg.setGoodsName(goods.getGoodsName());
			goodsmsg.setGoodsId(cart.getGoodsId());
			goodsmsg.setGoodsNum(cart.getGoodsNum());
			goodsmsg.setPrice(goods.getPrice());
			goodsmsg.setShowImage(goods.getShowImage());
			money = money + goodsmsg.getPrice()*goodsmsg.getGoodsNum();
			msglist.add(goodsmsg);
		}
		PrintWriter out = resp.getWriter();
		out.print(JSONArray.fromObject(msglist));
	}

}
