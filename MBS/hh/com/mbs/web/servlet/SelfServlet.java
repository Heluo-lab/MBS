package com.mbs.web.servlet;


import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mbs.dto.OrdersDTO;
import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Account;
import com.mbs.pojo.Goods;
import com.mbs.pojo.Receivinggoods;
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
		
//	/**
//	 * 根据用户ID查询用户所有信息
//	 */
//	public void querySingleUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
////		HttpSession session = request.getSession();
////		Account acc = new Account();
////		acc.setAccountId("2");
////		session.setAttribute("account",acc);
////		Account account = (Account)session.getAttribute("account");
////		String accountId = account.getAccountId();
////		SelfService service = new SelfServiceImpl();
////		UsersInfo users = service.querySingleUser(accountId);
////		session.setAttribute("usersInfo", users);
////		request.getRequestDispatcher("self_center.jsp").forward(request, response);
//	}
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
		String id = request.getParameter("id");
		//String goodsId = "100";
		String result = service.addCollect(usersId, Integer.parseInt(id));
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
	
	//根据用户Id查询该用户所有录入的收货地址
	public void queryReceAddress(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SelfService service = new SelfServiceImpl();
		Account acc =(Account)request.getSession().getAttribute("account");
		String usersId = acc.getAccountId();
		List<Receivinggoods> receList = service.queryReceAddress(usersId);
		request.setAttribute("receList", receList);
		request.getRequestDispatcher("self_address.jsp").forward(request, response);
	}
	
	//根据用户Id增加用户的收货地址并返回新的所有地址信息
	public void insertReceAddressByUsersId(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SelfService service = new SelfServiceImpl();
		Receivinggoods rece = new Receivinggoods();
		Account acc =(Account)request.getSession().getAttribute("account");
		String usersId = acc.getAccountId();
		String receName = request.getParameter("receName");
		String recePhone = request.getParameter("recePhone");
		String receAddressProv = request.getParameter("receAddressProv");
		String receAddressCity = request.getParameter("receAddressCity");
		String receAddressCountry = request.getParameter("receAddressCountry");
		String receAddressDetaile = request.getParameter("receAddressDetaile");
		rece.setReceId(UUID.randomUUID().toString());
		rece.setReceName(receName);
		rece.setRecePhone(recePhone);
		rece.setReceAddressProv(receAddressProv);
		rece.setReceAddressCity(receAddressCity);
		rece.setReceAddressCountry(receAddressCountry);
		rece.setReceAddressDetaile(receAddressDetaile);
		rece.setUsersId(usersId);
		service.insertReceAddressByUsersId(rece);
		List<Receivinggoods> receList = service.queryReceAddress(usersId);
		response.setCharacterEncoding("UTF-8");
		JSONArray array = JSONArray.fromObject(receList);
		response.getWriter().print(array.toString());
	}
	
	//根据收货信息ID删除该收获地址并返回收藏地址集
	public void deleteReceAddressByUsersIdAndReceId(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SelfService service = new SelfServiceImpl();
		String receId = request.getParameter("receId");
		service.deleteReceAddressByUsersIdAndReceId(receId);
		Account acc =(Account)request.getSession().getAttribute("account");
		String usersId = acc.getAccountId();
		List<Receivinggoods> receList = service.queryReceAddress(usersId);
		response.setCharacterEncoding("UTF-8");
		JSONArray array = JSONArray.fromObject(receList);
		response.getWriter().print(array.toString());
	}
	
	//根据用户Id与收货信息ID修改该收获地址
	public void updateReceAddressByUsersIdAndReceId(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SelfService service = new SelfServiceImpl();
		Receivinggoods rece = new Receivinggoods();
		Account acc =(Account)request.getSession().getAttribute("account");
		String usersId = acc.getAccountId();
		String receId = request.getParameter("receId");
		String receName = request.getParameter("receName");
		String recePhone = request.getParameter("recePhone");
		String receAddressProv = request.getParameter("receAddressProv");
		String receAddressCity = request.getParameter("receAddressCity");
		String receAddressCountry = request.getParameter("receAddressCountry");
		String receAddressDetaile = request.getParameter("receAddressDetaile");
		rece.setReceId(receId);
		rece.setReceName(receName);
		rece.setRecePhone(recePhone);
		rece.setReceAddressProv(receAddressProv);
		rece.setReceAddressCity(receAddressCity);
		rece.setReceAddressCountry(receAddressCountry);
		rece.setReceAddressDetaile(receAddressDetaile);
		rece.setUsersId(usersId);
		service.updateReceAddressByUsersIdAndReceId(rece);
		List<Receivinggoods> receList = service.queryReceAddress(usersId);
		response.setCharacterEncoding("UTF-8");
		JSONArray array = JSONArray.fromObject(receList);
		response.getWriter().print(array.toString());
	}
	
	// xx 根据收货地址Id修改为默认地址 beforeReceId为用户更改前的默认地址 afterReceId为更改后的地址 true表示都修改成功 , false表示为修改失败 xx 失效
	//根据用户Id将该用户所有地址都设为不默认 并将receId设为默认地址  true表示都修改成功 , false表示为修改失败 
	public void setDefaultAddressByUsersIdAndReceId(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SelfService service = new SelfServiceImpl();
		Account acc =(Account)request.getSession().getAttribute("account");
		String usersId = acc.getAccountId();
		String receId = request.getParameter("receId");
		boolean flag = service.setDefaultAddressByUsersIdAndReceId(usersId, receId);
		response.getWriter().print(flag);
	}
	
	//根据用户Id查询得到全部订单信息
	public void queryAllOrdersByUsersId(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SelfService service = new SelfServiceImpl();
		Account acc =(Account)request.getSession().getAttribute("account");
		String usersId = acc.getAccountId();
		List<OrdersDTO> ordersDTOList = service.queryAllOrdersByUsersId(usersId);
		System.out.println(ordersDTOList);
		request.setAttribute("ordersDTOList", ordersDTOList);
		request.getRequestDispatcher("self_order.jsp").forward(request, response);
	}
}
