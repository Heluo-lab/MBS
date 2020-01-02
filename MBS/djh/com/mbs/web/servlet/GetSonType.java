package com.mbs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbs.pojo.Type;
import com.mbs.service.TypeService;
import com.mbs.service.impl.TypeServiceImpl;
import com.mbs.util.JsonParseUtil;
/**
 * 
 * @author 段积鸿
 *这是一个通过id,返回其子类的json数据的接口
 */
@WebServlet("/sontype")
public class GetSonType extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetSonType() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TypeService typeservice = new TypeServiceImpl();
		int parentId = Integer.parseInt(request.getParameter("id"));
		List<Type> sonTypeList = typeservice.getSonType(parentId);
		response.setContentType("application/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		System.out.println(JsonParseUtil.GetJson(sonTypeList));
		writer.print(JsonParseUtil.GetJson(sonTypeList));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
