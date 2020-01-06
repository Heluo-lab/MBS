package com.mbs.web.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Account;
import com.mbs.pojo.Goods;
import com.mbs.service.SelfService;
import com.mbs.service.impl.SelfServiceImpl;

import net.sf.json.JSONArray;
/**
 * 封装对个人信息请求的处理的方法 等待SelfServletDispatcher的调用
 * @author heluo
 *	power后缀目录表示只有在登录后才能访问
 */
@WebServlet("*.power")
public class SelfServlet extends SelfServletDispatcher{

	private static final long serialVersionUID = 6367079502427622830L;
		
	/**
	 * 根据用户ID查询用户所有信息
	 */
	public void querySingleUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		Account acc = new Account();
		acc.setAccountId("2");
		session.setAttribute("account",acc);
		Account account = (Account)session.getAttribute("account");
		String accountId = account.getAccountId();
		SelfService service = new SelfServiceImpl();
		UsersInfo users = service.querySingleUser(accountId);
		session.setAttribute("usersInfo", users);
		request.getRequestDispatcher("self_center.jsp").forward(request, response);
	}
	/**
	 * 根据用户ID查询该用户所有收藏商品
	 */
	public void queryCollectGoodsByUsersId(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		UsersInfo userInfo  = (UsersInfo)session.getAttribute("usersInfo");
		SelfService service = new SelfServiceImpl();
		List<Goods> goodsList = service.queryCollectGoodsByUsersId(userInfo.getAccountId());
		request.setAttribute("goodsList", goodsList);
		request.getRequestDispatcher("self_mycollect.jsp").forward(request, response);
	}
	
	/**
	 * 根据商品ID从收藏表删除该收藏的商品
	 */
	public void deleteCollectByGoodsId(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SelfService service = new SelfServiceImpl();
		String id = request.getParameter("id");
		Account acc =(Account)request.getSession().getAttribute("account");
		String usersId = acc.getAccountId();
		List<Goods> goodsList = service.deleteCollectByGoodsIdAndReturnGoodsList(usersId, Integer.parseInt(id));
		response.setCharacterEncoding("UTF-8");
		JSONArray array = JSONArray.fromObject(goodsList);
		response.getWriter().print(array.toString());
	}
	
	/**
	 * 根据用户ID与商品ID添加收藏
	 * 返回 success 为添加成功 , fail添加失败,exit表示该商品已被收藏 
s	 */
	public void addCollect(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SelfService service = new SelfServiceImpl();
		Account acc =(Account)request.getSession().getAttribute("account");
		String usersId = acc.getAccountId();
//		String goodsId = request.getParameter("goodsId");
		String goodsId = "100";
		String result = service.addCollect(usersId, Integer.parseInt(goodsId));
		response.getWriter().print(result);
	}
	
	//根据用户ID和商品名称查询收藏中的商品
	public void queryCollectGoodsByUsersIdAndGoodsName(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SelfService service = new SelfServiceImpl();
		Account acc =(Account)request.getSession().getAttribute("account");
		String usersId = acc.getAccountId();
		String goodsName = request.getParameter("goodsName");
		List<Goods> goodsList = service.queryCollectGoodsByUsersId(usersId, goodsName);
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("goodsName", goodsName);
		request.getRequestDispatcher("self_mycollect.jsp").forward(request, response);;
	}
//	//根据用户ID更新用户信息
//	public void updateUsersInfoByUsersId(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
//		SmartUpload su = new SmartUpload();
//		su.initialize(this.getServletConfig(), request, response);
//		try {
//			su.upload();
//		} catch (SmartUploadException e) {
//			e.printStackTrace();
//		}
//		String usersBirth = su.getRequest().getParameter("usersBirth");
//		String usersName = su.getRequest().getParameter("usersName");
//		//usersName = DecoderToUTF8.toUTF8(usersName);
//		String prov = su.getRequest().getParameter("prov");
//		//prov = DecoderToUTF8.toUTF8(prov);
//		String city = su.getRequest().getParameter("city");
//		//city = DecoderToUTF8.toUTF8(city);
//		String country = su.getRequest().getParameter("country");
//		//country = DecoderToUTF8.toUTF8(country);
//		String usersSex = su.getRequest().getParameter("usersSex");
//		//usersSex = DecoderToUTF8.toUTF8(usersSex);
//		Files files = su.getFiles();
//		int count = files.getCount();
//		String path = null;
//		for(int i = 0 ; i < count ; i++){
//			File f = files.getFile(i);
//			String fileName = DecoderToUTF8.toUTF8(f.getFileName());
//			path = "img/headPic/"+fileName;
//			try {
//				f.saveAs("/img/headPic/"+fileName, SmartUpload.SAVE_AUTO);
//			} catch (SmartUploadException e) {
//				e.printStackTrace();
//				//用户没替换默认头像,向数据库存入默认头像或空
//			}
//		}
//		System.out.println(usersBirth+"==="+usersName+prov+"==="+city+"==="+country+"==="+path);
//	}
}
