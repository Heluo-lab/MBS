package com.mbs.web.servlet;

import java.io.IOException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.util.MailUtils;

/**
 * 随机产生邮箱验证
 * @author Administrator
 *
 */

@WebServlet("/emailCode")
public class EmailCodeBtnServlet extends HttpServlet{
	private String[] str = {"1","2","3","4","5","6","7","8","9","0"};
	private Random r = new Random();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//生成随机的验证码的内容
		String emailMsg="";
		for (int i = 0; i < 4; i++) {
			String c =str[r.nextInt(str.length)];
			emailMsg+=c;
		}
		//获取传过来的邮箱值
		String email =req.getParameter("email");
		if (!"".equals(emailMsg)) {
			//将验证码的内容存入session中，用来对比客户填的验证码
			req.getSession().setAttribute("emailMsg", emailMsg.toString());
			//设置邮箱主题
			String subject="code";
			//将验证码发送给客户邮箱
//			try {
//				MailUtils.sendMail(email,subject,emailMsg);
//			} catch (MessagingException e) {
//				e.printStackTrace();
//			}
			//生成的验证码json
			resp.setCharacterEncoding("UTF-8");
			//告诉前台传的是json
			resp.setHeader("Content-Type", "application/json;charset=utf-8");
			resp.getWriter().print(emailMsg);
			System.out.println(emailMsg);
		}
	}
}
