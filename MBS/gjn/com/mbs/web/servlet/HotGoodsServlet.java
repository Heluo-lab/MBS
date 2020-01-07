package com.mbs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
import net.sf.json.JSONObject;

@WebServlet("/hotgoods")
public class HotGoodsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		GoodsMsg goods = new GoodsMsg();
//		List<GoodsMsg> list = new ArrayList<GoodsMsg>();
//		PrintWriter out = resp.getWriter();
//		goods.setGoodsId(1);
//		goods.setGoodsName("蒙蒂埃莫羊绒手感时尚字母logo提花翻边针织羊毛帽");
//		goods.setPrice(79);
//		goods.setShowImage("http://images6.monteamor.com/ProductImg/3/1804/middle/068218403-075-01-M.jpg");
//		goods.setSize("均码/F");  
//		goods.setColor("红色");  
//		list.add(goods);
//		GoodsMsg goods1 = new GoodsMsg();
//		goods1.setGoodsId(2);
//		goods1.setGoodsName("蒙蒂埃莫意式经典舒适微弹混纺百搭常规版男士休闲长裤");
//		goods1.setPrice(198);
//		goods1.setShowImage("http://images6.monteamor.com/ProductImg/3/1902/middle/065019103-009-01-M.jpg");  
//		goods1.setSize("34");  
//		goods1.setColor("黑色");  
//		list.add(goods1);
//		out.print(JSONArray.fromObject(list));
		//通过随机数获得900以上的商品热度
		PrintWriter out = resp.getWriter();
		Random r = new Random();
		int hot = r.nextInt(100)+900;
		List<Integer> hotlist = new ArrayList<Integer>();
		for (int i = 0; i < 15; i++) {
			hotlist.add(hot);
			hot = r.nextInt(100)+900;
			for (Integer integer : hotlist) {
				if (integer == hot) {
					hot = r.nextInt(100)+900;
				}
			}
		}
		//通过商品热度获得对应的商品id
		ProductDao pd = new ProductDaoimpl();
		CartDao cd = new CartDaoImpl();
		List<Integer> goodsIdlist = new ArrayList<Integer>();
		for (Integer goodsHot : hotlist) {
			goodsIdlist.add(cd.selectGoodsId(goodsHot));
		}
		//通过商品id获得商品详情
		List<GoodsMsg> goodsmsglist = new ArrayList<GoodsMsg>();
		for (Integer goodsId : goodsIdlist) {
			GoodsMsg goodsmsg = new GoodsMsg();
			IDColorSizeOf goods = pd.LoadingfoGoodsID(goodsId);
			goodsmsg.setGoodsName(goods.getGoodsName());
			goodsmsg.setGoodsId(goodsId);
			goodsmsg.setPrice(goods.getPrice());
			goodsmsg.setShowImage(goods.getShowImage());
			goodsmsg.setColor(goods.getColour());
			goodsmsg.setSize(goods.getSizes());
			goodsmsglist.add(goodsmsg);
		}
		List<GoodsMsg> hotgoods = new ArrayList<GoodsMsg>();
		boolean flag = true;
		while(true) {
			int n = r.nextInt(5);
			for (GoodsMsg goodsMsg : hotgoods) {
				flag = false;
				if (goodsMsg.getGoodsId()==goodsmsglist.get(n).getGoodsId()) {
					flag = true;
					break;
				}
			}
			if (true) {
				hotgoods.add(goodsmsglist.get(n));
			}
			if (hotgoods.size()==5) {
				break;
			}
		}
		out.print(JSONArray.fromObject(hotgoods));
	}

}
