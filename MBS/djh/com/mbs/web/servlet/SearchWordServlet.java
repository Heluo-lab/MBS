package com.mbs.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.service.GoodsService;
import com.mbs.service.impl.GoodsServiceImpl;
import com.mbs.util.JsonParseUtil;

/**
 * Servlet implementation class SearchWordServlet
 */
@WebServlet("/searchWord")
public class SearchWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchWordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得关键字
		String word = request.getParameter("word");
		
		//查询该关键字的所有商品
		GoodsService service = new GoodsServiceImpl();
		List<Object> productList = null;
		
		productList = service.findProductByWord(word);
		
		//使用json的转换工具将对象或集合转成json格式的字符串
		/*JSONArray fromObject = JSONArray.fromObject(productList);
		String string = fromObject.toString();
		System.out.println(string);*/
		
		String json = JsonParseUtil.GetJson(productList);
		
		if(json==null) {
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(json);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
