package com.mbs.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.dao.ProductDao;
import com.mbs.dao.impl.ProductDaoimpl;
import com.mbs.dto.ColorNameAndImgAndCode;
import com.mbs.dto.DataMapping;
import com.mbs.pojo.Color;


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
//		得到从详情传入的id
		String str =  request.getParameter("id");
		int flag = Integer.parseInt(str);
//		得到颜色编码数组对象
		List<DataMapping> colorCodelist = dao.IdToColor(flag).getColorCode();
		for (DataMapping dataMapping : colorCodelist) {
			System.out.println(dataMapping);
		}
		String colorCode = colorCodelist.get(0).getColorCode();
		System.out.println("=========="+colorCode);
//		解析img长字段
		String imgUrl =  dao.LoadingfoGoodsID(flag).getGoodsInfoImage();
		String[]  imgUrls= null;
		if(imgUrl!=null) {
			imgUrls= imgUrl.split("@l@");
		}

//		解析颜色尺码对象字段
//		拿到对象
		
		
//		展示颜色名字和对应颜色图片
//		String colorimg = dao.IdColoridOfColorNameandimg(flag, colorCode).getColorimage();
//		String[] colorimgs = colorimg.split("@l@");
//		request.setAttribute("colorimg",colorimgs);
//		request.setAttribute("colorName", dao.IdColoridOfColorNameandimg(flag, colorCode).getColorName());
//		System.out.println(dao.IdColoridOfColorNameandimg(flag, colorCode).toString());
		
//		根据id和颜色编码 查询对应颜色图片
		String Shopwindow = dao.IdColorOfImg(flag,colorCode).getColorimage();
//		解析对应颜色图片长字段
		String[] colorImage = Shopwindow.split("@l@");
		
		request.setAttribute("goods", dao.LoadingfoGoodsID(flag));
		
		request.setAttribute("imgurl", imgUrls);
		
		request.setAttribute("instock", dao.GidColorSizeOfRepositoryCount(flag, colorCode, "32"));
		
		request.setAttribute("color", dao.IdColorOfImg(flag, colorCode));
		
		request.setAttribute("colorImage",colorImage);
//======================================================================
//		根据颜色编码和商品id查询颜色名和对应图片
		List<Color> Cnimgcodelist = null;
		//颜色集合
		List<Color> colorlist = dao.ColorCodeAndGoodsIdOfColorNameAndColorImg(flag);
		System.out.println("================="+colorlist.size());
		request.setAttribute("colorlist", colorlist);
//		尺码集合
		String colorsize = colorCodelist.get(0).getSizes();
		request.setAttribute("colorsize",colorsize);
		
//		String[] colorimgs = dao.ColorCodeAndGoodsIdOfColorNameAndColorImg(flag, colorCode).getColorImg().split("@l@");
//		String colorName =  dao.ColorCodeAndGoodsIdOfColorNameAndColorImg(flag, colorCode).getColorName();
//		request.setAttribute("colorimgs",colorimgs);
//		request.setAttribute("colorName", colorName);
		
		
		
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
