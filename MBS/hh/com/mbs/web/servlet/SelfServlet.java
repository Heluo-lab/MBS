package com.mbs.web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Account;
import com.mbs.service.SelfService;
import com.mbs.service.impl.SelfServiceImpl;
/**
 * 封装对个人信息请求的处理的方法 等待SelfServletDispatcher的调用
 * @author heluo
 *
 */
@WebServlet("/self")
public class SelfServlet extends SelfServletDispatcher{

	private static final long serialVersionUID = 6367079502427622830L;
		
	public void querySingleUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		Account acc = new Account();
		acc.setAccountId("12324234234242342342423424324");
		session.setAttribute("account",acc);
		Account account = (Account)session.getAttribute("account");
		String accountId = account.getAccountId();
		SelfService service = new SelfServiceImpl();
		UsersInfo users = service.querySingleUser(accountId);
		session.setAttribute("usersInfo", users);
		request.getRequestDispatcher("self_center.jsp").forward(request, response);
	}
}
