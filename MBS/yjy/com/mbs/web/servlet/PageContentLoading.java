package com.mbs.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.dao.ProductDao;
import com.mbs.dao.impl.ProductDaoimpl;

/**
 * Servlet implementation class Test
 */
@WebServlet("/pageConetentLoading")
public class PageContentLoading extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageContentLoading() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDaoimpl dao = new ProductDaoimpl();
		
		
		String imgUrl =  dao.LoadingfoGoodsID(4).getGoodsInfoImage();
		String[] imgUrls =  imgUrl.split("@l@");
		
//		for (int i = 0; i < imgUrls.length; i++) {
//			System.out.println(imgUrls[i]);
//		}
		
		request.setAttribute("goods", dao.LoadingfoGoodsID(4));
		
		request.setAttribute("imgurl", imgUrls);
		
		request.setAttribute("instock", dao.GidColorSizeOfRepositoryCount(4, "052", "32"));
		
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
