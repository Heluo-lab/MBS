package com.mbs.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;

/**
 * 验证码图片
 * @author Administrator
 *
 */
@WebServlet("/codeImage")
public class CodeImageServlet extends HttpServlet{

	private String[] str = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",
			"S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
	
	private Random r = new Random();
	//定义验证码图片的大小
	private final int WIDTH = 193;
	private final int HEIGHT = 40;
	public CodeImageServlet() {
		super();
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//生成验证码
		ServletOutputStream sos =resp.getOutputStream();
		//生成随机的验证码
		StringBuffer show =new StringBuffer();
		StringBuffer code =new StringBuffer();
		for (int i = 0; i < 6; i++) {
			String c =str[r.nextInt(str.length)];
			show.append(c+" ");
			code.append(c);
		}
		//将验证码的内容存入session中，后续点击下一步时从session中取出
		//与客户提交的数据进行对比
		req.getSession().setAttribute("codeImg", code.toString());
		System.out.println(code.toString());
		
		//生成一张bufferimage
		BufferedImage bi =new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		//获得这张图片的画笔
		Graphics g =bi.getGraphics();
		//设置黑色
		g.setColor(Color.black);
		//画边框
		g.drawRect(0, 0, WIDTH, HEIGHT);
		//设置灰色
		g.setColor(Color.gray);
		//填充矩形
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//设置白色
		g.setColor(Color.white);
		//设置字体大小
		g.setFont(new Font("宋体",Font.BOLD,30));
		//写字
		g.drawString(show.toString(), 5, 30);
		//画4条干扰线
		g.drawLine(10, 10, 180, 10);
		g.drawLine(10, 20, 180, 20);
		g.drawLine(10, 5, 180, 25);
		g.drawLine(10, 20, 180, 5);
		//画400个干扰点
		for (int i = 0; i < 300; i++) {
			int x = r.nextInt(WIDTH);
			int y = r.nextInt(HEIGHT);
			g.drawLine(x,y,x,y);
		}
		
		ImageIO.write(bi, "jpg", sos);
		sos.flush();
		sos.close();
	}
}
