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
import com.mbs.dto.UsersInfo;
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
					flag = false;
					break;
				}
				flag = true;
			}
			if (flag) {
				hotgoods.add(goodsmsglist.get(n));
			}
			if (hotgoods.size()==5) {
				break;
			}
		}
		out.print(JSONArray.fromObject(hotgoods));
	}

}
