package com.mbs.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/searchList")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodsService gs = new GoodsServiceImpl();
		TypeService ts = new TypeServiceImpl();
		String goodsName = request.getParameter("name");
		// 顶级分类集合
		List<Type> TopTypeList = ts.getGoodsTopType();
		// 通过goodsName得到商品数
		int goodsCount = gs.getGoodsCount(goodsName);
		// 获取页面商品数
		String size = request.getParameter("pageSize");
		int pageSize = 100;

		if (size == null) {
			// 表示第一次进入页面
			pageSize = 100;
		} else {
			pageSize = Integer.parseInt(size);
		}

		// 准备一个集合
		Map<String, String> param = new HashMap<String, String>();
		// 获得提交过来的值
		String min = request.getParameter("min");
		if (min != null && !"".equals(min.trim())) {
			param.put("min", min);
		}
		String max = request.getParameter("max");
		if (max != null && !"".equals(max.trim())) {
			param.put("max", max);
		}
		// 按啥排序
		String order = request.getParameter("order");
		if (order != null && !"".equals(order.trim())) {
			param.put("order", order);
		}
		// 升序还是降序
		String sort = request.getParameter("sort");
		if (sort != null && !"".equals(sort.trim())) {
			param.put("sort", sort);
		}
		// 根据页面显示条数pageSize求出最大页码数
		int maxNo = gs.selectMaxPageByname(goodsName, pageSize);

		int pageNo = 1;

		String pageno = request.getParameter("pageNo");

		if (pageno == null) {
			// 表示这是第一次进入查询页面
			pageNo = 1;
		} else {
			// 表示这是第N次进入
			pageNo = Integer.parseInt(pageno);
			// 这是是获得页面后进行范围限制判断
			if (pageNo < 1) {
				pageNo = 1;
			}
			if (pageNo > maxNo) {
				pageNo = maxNo;
			}
		}

		// List<Goods> Goodslist = gs.selectGoodsByName(goodsName, pageSize, pageNo);
		List<Goods> Goodslist = gs.selectGoodsByName(goodsName, param, pageSize, pageNo);
		// 存储低级分类集合
		request.setAttribute("TypeList", TopTypeList);
		// 存储集合
		request.setAttribute("Goodslist", Goodslist);
		// 存储当前的页码
		request.setAttribute("pageNo", pageNo);
		// 存储页面显示条数
		request.setAttribute("pageSize", pageSize);
		// 存储最大的页码
		request.setAttribute("maxNo", maxNo);
		// 存储商品关键字name
		request.setAttribute("name", goodsName);
		// 此类型商品数
		request.setAttribute("goodsCount", goodsCount);
		// 存储排序方式
		request.setAttribute("order", order);
		request.setAttribute("sort", sort);
		// 存入最大价和最小价到请求
		request.setAttribute("min", min);
		request.setAttribute("max", max);

		request.getRequestDispatcher("/product_listByname.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
