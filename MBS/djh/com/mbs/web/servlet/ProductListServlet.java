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

@WebServlet("/product_list")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodsService gs = new GoodsServiceImpl();
		TypeService ts = new TypeServiceImpl();
		int tyid = Integer.parseInt(request.getParameter("tyid"));
		//顶级分类集合
		List<Type> TopTypeList = ts.getGoodsTopType();
		System.out.print(TopTypeList);
		String size = request.getParameter("pageSize");
		int pageSize = 50;
		
		if (size == null) {
			// 表示第一次进入页面
			pageSize = 30;
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
		
		// 根据页面显示条数pageSize求出最大页码数
		int maxNo = gs.selectMaxPage(tyid, pageSize);

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

		List<Goods> Goodslist = gs.selectAllStudent(tyid ,pageSize, pageNo);
		
		//存储低级分类集合
		request.setAttribute("TypeList", TopTypeList);
		// 存储集合
		request.setAttribute("Goodslist", Goodslist);
		// 存储当前的页码
		request.setAttribute("pageNo", pageNo);
		// 存储页面显示条数
		request.setAttribute("pageSize", pageSize);
		// 存储最大的页码
		request.setAttribute("maxNo", maxNo);
		// 存入最大价和最小价到请求
		request.setAttribute("min", min);
		request.setAttribute("max", max);

		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
