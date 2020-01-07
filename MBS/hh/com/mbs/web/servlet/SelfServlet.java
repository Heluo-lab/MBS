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
		String goodsId = request.getParameter("id");
//		String goodsId = "100";
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
}
