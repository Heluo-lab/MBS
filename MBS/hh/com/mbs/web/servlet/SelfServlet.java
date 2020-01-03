package com.mbs.web.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Account;
import com.mbs.pojo.Goods;
import com.mbs.service.SelfService;
import com.mbs.service.impl.SelfServiceImpl;
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
		String id = request.getParameter("id");
		System.out.println(id);
		SelfService service = new SelfServiceImpl();
//		request.getRequestDispatcher("self_mycollect.jsp").forward(request, response);
	}
}
