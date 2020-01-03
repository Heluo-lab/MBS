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
import com.mbs.dto.IDColorSizeOf;
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
		CartDao cd = new CartDaoImpl();
		List<CartItem> list = cd.selectAllCartId(req.getParameter("usersid"));
		List<IDColorSizeOf> goodslist = new ArrayList<IDColorSizeOf>();
		for (CartItem cart : list) {
			ProductDao pd = new ProductDaoimpl();
			IDColorSizeOf goods = pd.LoadingfoGoodsID(cart.getGoodsId());
			goodslist.add(goods);
		}
		req.getSession().setAttribute("goodslist", goodslist);
		resp.sendRedirect("cart.jsp");
	}

}
