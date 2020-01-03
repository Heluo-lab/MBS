package com.mbs.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.pojo.Goods;
import com.mbs.pojo.Type;
import com.mbs.service.GoodsService;
import com.mbs.service.TypeService;
import com.mbs.service.impl.GoodsServiceImpl;
import com.mbs.service.impl.TypeServiceImpl;

//加载首页之前请求数据
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//准备数据
		TypeService typeService = new TypeServiceImpl(); 
		GoodsService goodsService = new GoodsServiceImpl();
		//准备商品顶级分类的集合
		List<Type> goodsTopTypeList = typeService.getGoodsTopType();
		//准备男装子集分类六条
		List<Type> manList = typeService.getManlist();
		//准备女装子集分类十条
		List<Type> womanList = typeService.getWomenlist();
		//准备内衣子集分类十条
		List<Type> underwearList = typeService.getUnderWearlist();
		//准备鞋包子集分类
		List<Type> shoesBagList = typeService.getShoesBaglist();
		//准备女装的热销推荐商品分类集合
		List<Type> goodsRecommendTypeList = typeService.getGoodsRecommendType();
		//装备热销商品
		List<Goods> goodsList=goodsService.selectReconmmendGoods();
		
		request.setAttribute("goodsTopTypeList", goodsTopTypeList);
		request.setAttribute("manList", manList);
		request.setAttribute("womanList", womanList);
		request.setAttribute("underwearList", underwearList);
		request.setAttribute("shoesBagList", shoesBagList);
		request.setAttribute("goodsRecommendTypeList",goodsRecommendTypeList);
		request.setAttribute("goodsList",goodsList);
		
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
