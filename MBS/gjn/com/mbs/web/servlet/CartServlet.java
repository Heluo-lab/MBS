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
import com.mbs.dto.DataMapping;
import com.mbs.dto.GoodsMsg;
import com.mbs.dto.IDColorSizeOf;
import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Account;
import com.mbs.pojo.CartItem;
import com.mbs.pojo.Goods;

import net.sf.json.JSONArray;

/**
 * 访问购物车页面
 * 通过usersid判断
 * @author 高嘉楠
 *
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account info = (Account)req.getSession().getAttribute("account");
		String usersId = null;
		if (info==null) {
			resp.sendRedirect("login.jsp");
			return;
		}else {
			usersId = info.getAccountId();
		}
		System.out.println("cart");
		CartDao cd = new CartDaoImpl();
		List<CartItem> list = cd.selectAllCartId(usersId);
		List<GoodsMsg> msglist = new ArrayList<GoodsMsg>();
		for (CartItem cart : list) {
			ProductDao pd = new ProductDaoimpl();
			GoodsMsg goodsmsg = new GoodsMsg();
			IDColorSizeOf goods = pd.LoadingfoGoodsID(cart.getGoodsId());
			goodsmsg.setCartItemId(cart.getCartItemId());
			goodsmsg.setGoodsName(goods.getGoodsName());
			goodsmsg.setGoodsId(cart.getGoodsId());
			goodsmsg.setGoodsNum(cart.getGoodsNum());
			goodsmsg.setPrice(goods.getPrice());
			goodsmsg.setShowImage(goods.getShowImage());
			System.out.println(cart.getColor());
			goodsmsg.setColor(cart.getColor());
			goodsmsg.setSize(cart.getSize());
			msglist.add(goodsmsg);
		}
		req.getSession().setAttribute("goodslist", msglist);
		resp.sendRedirect("cart.jsp");
	}

}
