package com.mbs.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.dao.CartDao;
import com.mbs.dao.OrderDao;
import com.mbs.dao.ProductDao;
import com.mbs.dao.impl.CartDaoImpl;
import com.mbs.dao.impl.OrderDaoImpl;
import com.mbs.dao.impl.ProductDaoimpl;
import com.mbs.dto.GoodsMsg;
import com.mbs.dto.IDColorSizeOf;
import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Account;
import com.mbs.pojo.CartItem;
import com.mbs.pojo.Receivinggoods;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account info = (Account)req.getSession().getAttribute("account");
		String usersId = info.getAccountId();
		//获得地址信息
		OrderDao od = new OrderDaoImpl();
		List<Receivinggoods> recelist = od.selectAddress(usersId);
		boolean hasmsg = false;
		Receivinggoods recegoods = new Receivinggoods();
		for (Receivinggoods regoods : recelist) {
			if (regoods.getIsDefault()==1) {
				hasmsg = true;
				recegoods = regoods;
			}
		}
		//获得购物车商品
		double money = 0;
		CartDao cd = new CartDaoImpl();
		//usersid
		List<CartItem> list = cd.selectAllCartId(usersId);
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
			goodsmsg.setColor(cart.getColor());
			goodsmsg.setSize(cart.getSize());
			money = money + goodsmsg.getPrice()*goodsmsg.getGoodsNum();
			msglist.add(goodsmsg);
		}
		req.getSession().setAttribute("money", money);
		req.getSession().setAttribute("goodslist", msglist);
		req.getSession().setAttribute("usersId", usersId);
		String receName = recegoods.getReceName();
		String receAddressCity = recegoods.getReceAddressCity();
		String receAddressDetaile = recegoods.getReceAddressDetaile();
		String receAddressProv = recegoods.getReceAddressProv();
		String recePhone = recegoods.getRecePhone();
		req.setAttribute("receName", receName);
		req.setAttribute("receAddressCity", receAddressCity);
		req.setAttribute("receAddressProv", receAddressProv);
		req.setAttribute("receAddressDetaile", receAddressDetaile);
		req.setAttribute("recePhone", recePhone);
		req.getRequestDispatcher("order.jsp?hasmsg="+hasmsg).forward(req, resp);
	}

}
