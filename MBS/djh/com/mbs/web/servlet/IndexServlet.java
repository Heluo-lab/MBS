package com.mbs.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mbs.pojo.Type;
import com.mbs.service.TypeService;
import com.mbs.service.impl.TypeServiceImpl;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TypeService typeService = new TypeServiceImpl(); 
		//准备商品顶级分类的集合
		List<Type> goodsTopTypeList = typeService.getGoodsTopType();
		//准备女装的热销推荐商品分类集合
		List<Type> goodsRecommendTypeList = typeService.getGoodsRecommendType();
		request.setAttribute("goodsTopTypeList", goodsTopTypeList);
		request.setAttribute("goodsRecommendTypeList",goodsRecommendTypeList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
