package com.mbs.web.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.pojo.Account;
import com.mbs.service.AccountService;
import com.mbs.service.impl.AccountServiceImpl;
import com.mbs.util.MailUtils;

/**
 * 忘记密码的下一步
 * @author Administrator
 *
 */
@WebServlet("/next")
public class NextServlet extends HttpServlet{
	private String[] str = {"1","2","3","4","5","6","7","8","9","0"};
	private Random r = new Random();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email =req.getParameter("email");
		String code =req.getParameter("reset_code");
		//获取存入session的验证码
		String serverCode =req.getSession().getAttribute("codeImg").toString();
		//验证码正确
		if (serverCode.equalsIgnoreCase(code)) {
			//查询是否有该账号
			AccountService service =new AccountServiceImpl();
			Account account =service.queryAccount(email);
			//用户不存在
			if (account==null) {
				req.getSession().setAttribute("msg", "邮箱输入错误");
				//转到第一步界面
				resp.sendRedirect("forgetpwdstep1.jsp");
			}else {
				//用户存在
				//生成随机密码的内容
				String emailMsg="";
				for (int i = 0; i < 8; i++) {
					String c =str[r.nextInt(str.length)];
					emailMsg+=c;
				}
				//设置邮箱主题
				String subject="code";
				//发送临时密码到该邮箱
//				try {
//					MailUtils.sendMail(email,subject,emailMsg);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				System.out.println("next "+emailMsg);
				//并将该临时密码替换
				account.setAccountPass(emailMsg);
				//修改该用户密码
				service.updateAccount(account);
				//转到登录界面
				resp.sendRedirect("forgetpwdstep2.jsp");
			}
		}
		//验证码错误
		else {
			req.getSession().setAttribute("msg", "验证码不正确");
			//转到第一步界面
			resp.sendRedirect("forgetpwdstep1.jsp");
		}
	}
}
