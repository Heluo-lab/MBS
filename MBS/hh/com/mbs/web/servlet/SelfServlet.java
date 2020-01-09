package com.mbs.web.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mbs.dao.CartDao;
import com.mbs.dao.ProductDao;
import com.mbs.dao.impl.CartDaoImpl;
import com.mbs.dao.impl.ProductDaoimpl;
import com.mbs.dto.GoodsMsg;
import com.mbs.dto.IDColorSizeOf;
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
		SelfServlet.getCart(request);
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
		SelfServlet.getCart(request);
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
		SelfServlet.getCart(request);
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
		SelfServlet.getCart(request);
		SelfService service = new SelfServiceImpl();
		Account acc =(Account)request.getSession().getAttribute("account");
		String usersId = acc.getAccountId();
		List<OrdersDTO> ordersDTOList = service.queryAllOrdersByUsersId(usersId);
		request.setAttribute("ordersDTOList", ordersDTOList);
		request.getRequestDispatcher("self_order.jsp").forward(request, response);
	}
	
	//根据用户Id与条件查询得到订单信息
	public void queryOrdersByCondition(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SelfServlet.getCart(request);
		SelfService service = new SelfServiceImpl();
		Account acc =(Account)request.getSession().getAttribute("account");
		String usersId = acc.getAccountId();
		String ordersTime = request.getParameter("ordersTime");
		String ordersStatus = request.getParameter("ordersStatus");
		String ordersNum = request.getParameter("ordersNum");
		System.out.println(ordersTime+"==="+ordersStatus+"==="+ordersNum);
		List<OrdersDTO> ordersDTOList = service.queryOrdersByCondition(usersId, Integer.parseInt(ordersTime), Integer.parseInt(ordersStatus), ordersNum);
		request.setAttribute("ordersTime", ordersTime);
		request.setAttribute("ordersStatus", ordersStatus);
		request.setAttribute("ordersNum", ordersNum);
		request.setAttribute("ordersDTOList", ordersDTOList);
		request.getRequestDispatcher("self_order.jsp").forward(request, response);
	}
	
	//购物车
	public static void getCart(HttpServletRequest request){
		CartDao cd = new CartDaoImpl();
		//获得购物车，usersId从session
		Account info = (Account)request.getSession().getAttribute("account");
		boolean hasGoods = false;
		if (info!=null) {
			String usersId = info.getAccountId();
			List<GoodsMsg> goodsMsgList = cd.selectGoodsMsg(usersId);
			//查看购物车有无商品
			int size = goodsMsgList.size();
			if (size==0) {
				hasGoods = false;
			}else {
				hasGoods = true;
			}
			//获得总价格
			double total = 0;
			for (GoodsMsg goodsMsg : goodsMsgList) {
				total +=goodsMsg.getGoodsNum()*goodsMsg.getPrice();
			}
			request.setAttribute("goodsMsg", goodsMsgList);
			request.setAttribute("hasGoods", hasGoods);
			request.setAttribute("total", total);
			request.setAttribute("size", size);
		}
	}
	
	//推荐商品servlet
	public void selfCenter(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		SelfServlet.getCart(request);
		//通过随机数获得900以上的商品热度
		PrintWriter out = response.getWriter();
		Random r = new Random();
		int hot = r.nextInt(100)+900;
		List<Integer> hotlist = new ArrayList<Integer>();
		for (int i = 0; i < 15; i++) {
			hotlist.add(hot);
			hot = r.nextInt(100)+900;
			for (Integer integer : hotlist) {
				if (integer == hot) {
					hot = r.nextInt(100)+900;
				}
			}
		}
		//通过商品热度获得对应的商品id
		ProductDao pd = new ProductDaoimpl();
		CartDao cd = new CartDaoImpl();
		List<Integer> goodsIdlist = new ArrayList<Integer>();
		for (Integer goodsHot : hotlist) {
			goodsIdlist.add(cd.selectGoodsId(goodsHot));
		}
		//通过商品id获得商品详情
		List<GoodsMsg> goodsmsglist = new ArrayList<GoodsMsg>();
		for (Integer goodsId : goodsIdlist) {
			GoodsMsg goodsmsg = new GoodsMsg();
			IDColorSizeOf goods = pd.LoadingfoGoodsID(goodsId);
			goodsmsg.setGoodsName(goods.getGoodsName());
			goodsmsg.setGoodsId(goodsId);
			goodsmsg.setPrice(goods.getPrice());
			goodsmsg.setShowImage(goods.getShowImage());
			goodsmsg.setColor(goods.getColour());
			goodsmsg.setSize(goods.getSizes());
			goodsmsglist.add(goodsmsg);
		}
		List<GoodsMsg> hotgoods = new ArrayList<GoodsMsg>();
		boolean flag = true;
		while(true) {
			int n = r.nextInt(5);
			for (GoodsMsg goodsMsg : hotgoods) {
				flag = false;
				if (goodsMsg.getGoodsId()==goodsmsglist.get(n).getGoodsId()) {
					flag = false;
					break;
				}
				flag = true;
			}
			if (flag) {
				hotgoods.add(goodsmsglist.get(n));
			}
			if (hotgoods.size()==4) {
				break;
			}
		}
		request.setAttribute("hotgoods", hotgoods);
		request.getRequestDispatcher("self_center.jsp").forward(request, response);
	}
	
	//推荐商品Ajax
	public void selfCenterAjax(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//通过随机数获得900以上的商品热度
		PrintWriter out = response.getWriter();
		Random r = new Random();
		int hot = r.nextInt(100)+900;
		List<Integer> hotlist = new ArrayList<Integer>();
		for (int i = 0; i < 15; i++) {
			hotlist.add(hot);
			hot = r.nextInt(100)+900;
			for (Integer integer : hotlist) {
				if (integer == hot) {
					hot = r.nextInt(100)+900;
				}
			}
		}
		//通过商品热度获得对应的商品id
		ProductDao pd = new ProductDaoimpl();
		CartDao cd = new CartDaoImpl();
		List<Integer> goodsIdlist = new ArrayList<Integer>();
		for (Integer goodsHot : hotlist) {
			goodsIdlist.add(cd.selectGoodsId(goodsHot));
		}
		//通过商品id获得商品详情
		List<GoodsMsg> goodsmsglist = new ArrayList<GoodsMsg>();
		for (Integer goodsId : goodsIdlist) {
			GoodsMsg goodsmsg = new GoodsMsg();
			IDColorSizeOf goods = pd.LoadingfoGoodsID(goodsId);
			goodsmsg.setGoodsName(goods.getGoodsName());
			goodsmsg.setGoodsId(goodsId);
			goodsmsg.setPrice(goods.getPrice());
			goodsmsg.setShowImage(goods.getShowImage());
			goodsmsg.setColor(goods.getColour());
			goodsmsg.setSize(goods.getSizes());
			goodsmsglist.add(goodsmsg);
		}
		List<GoodsMsg> hotgoods = new ArrayList<GoodsMsg>();
		boolean flag = true;
		while(true) {
			int n = r.nextInt(5);
			for (GoodsMsg goodsMsg : hotgoods) {
				flag = false;
				if (goodsMsg.getGoodsId()==goodsmsglist.get(n).getGoodsId()) {
					flag = false;
					break;
				}
				flag = true;
			}
			if (flag) {
				hotgoods.add(goodsmsglist.get(n));
			}
			if (hotgoods.size()==4) {
				break;
			}
		}
		response.getWriter().print(JSONArray.fromObject(hotgoods));
	}
	
}
