package com.mbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.mbs.dao.CartDao;
import com.mbs.dao.OrderDao;
import com.mbs.dao.ProductDao;
import com.mbs.pojo.CartItem;
import com.mbs.pojo.Receivinggoods;

import net.sf.json.JSONObject;

import com.mbs.db.DBHelper;
import com.mbs.dto.GoodsMsg;
import com.mbs.dto.IDColorSizeOf;
	
public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Receivinggoods> selectAddress(String usersId) {
		Connection connection = DBHelper.getConnection();
		String sql = "select * from receivinggoods where usersId="+usersId;
		List<Receivinggoods> list = new ArrayList<Receivinggoods>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Receivinggoods recemsg = new Receivinggoods();
				recemsg.setIsDefault(rs.getInt("isDefault"));
				recemsg.setReceAddressCity(rs.getString("receAddressCity"));
				recemsg.setReceAddressCountry(rs.getString("receAddressCountry"));
				recemsg.setReceAddressDetaile(rs.getString("receAddressDetaile"));
				recemsg.setReceAddressProv(rs.getString("receAddressProv"));
				recemsg.setReceId(rs.getString("receId"));
				recemsg.setReceName(rs.getString("receName"));
				recemsg.setRecePhone(rs.getString("recePhone"));
				recemsg.setUsersId(rs.getString("usersId"));
				list.add(recemsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return list;
	}
	private static int receId = 0;
	@Override
	public void addAddress(String receMsg) {
		JSONObject object = JSONObject.fromObject(receMsg);
		Receivinggoods receivinggoods = (Receivinggoods) JSONObject.toBean(object,Receivinggoods.class);
		Connection connection = DBHelper.getConnection();
		String sql = "insert into receivinggoods value(?,?,?,?,?,?,?,?,?)";
		String sql1 = "select * from receivinggoods ";
		boolean isdefault = false;
		try {
			PreparedStatement ps = connection.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			receId++;
			while(rs.next()) {
				if (rs.getInt("isDefault")==1) {
					isdefault =true;
				}
				receId++;
			}
			ps = connection.prepareStatement(sql);
			ps.setString(1, receId+"");
			ps.setString(2, receivinggoods.getReceName());
			ps.setString(3, receivinggoods.getRecePhone());
			ps.setString(4, receivinggoods.getReceAddressProv());
			ps.setString(5, receivinggoods.getReceAddressCity());
			ps.setString(6, receivinggoods.getReceAddressCountry());
			ps.setString(7, receivinggoods.getReceAddressDetaile());
			if (isdefault) {
				ps.setInt(8, 0);
			}else {
				ps.setInt(8, 1);
			}
			ps.setString(9, receivinggoods.getUsersId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
	}
	@Override
	public void deleteAddress(String receId) {
		Connection connection = DBHelper.getConnection();
		String sql = "delete from receivinggoods where receId="+receId;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
	}
	@Override
	public void changeDefault(String receId,String usersId) {
		Connection connection = DBHelper.getConnection();
		String sql = "update receivinggoods set isDefault=0 where usersId="+usersId;
		String sql1 = "update receivinggoods set isDefault=1 where receId="+receId;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.executeUpdate();
			ps = connection.prepareStatement(sql1);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
	}
	@Override
	public void updateAddress(String receMsg) {
		JSONObject object = JSONObject.fromObject(receMsg);
		Receivinggoods receivinggoods = (Receivinggoods) JSONObject.toBean(object,Receivinggoods.class);
		Connection connection = DBHelper.getConnection();
		System.out.println(receivinggoods.getReceId());
		String sql = "update receivinggoods set receName=?,recePhone=?,receAddressProv=?,receAddressCity=?,receAddressDetaile=? where receId="+receivinggoods.getReceId();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, receivinggoods.getReceName());
			ps.setString(2, receivinggoods.getRecePhone());
			ps.setString(3, receivinggoods.getReceAddressProv());
			ps.setString(4, receivinggoods.getReceAddressCity());
			ps.setString(5, receivinggoods.getReceAddressDetaile());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
	
	}
	
	private static int ordersId = 0;
	private static int ordersItemId = 0;
	@Override
	public void submitOrder(String usersId) {
		String sql1 = "insert into orders value(?,?,?,?,?)";
		String sql2 = "insert into ordersitem value(?,?,?,?,?,?)";
		String sql3 = "select * from orders";
		String sql4 = "select * from ordersitem";
		CartDao cd = new CartDaoImpl();
		List<CartItem> list = cd.selectAllCartId(usersId);
		List<GoodsMsg> msglist = new ArrayList<GoodsMsg>();
		for (CartItem cart : list) {
			ProductDao pd = new ProductDaoimpl();
			GoodsMsg goodsmsg = new GoodsMsg();
			IDColorSizeOf goods = pd.LoadingfoGoodsID(cart.getGoodsId());
			goodsmsg.setCartItemId(cart.getCartItemId());
			goodsmsg.setGoodsName(goods.getGoodsName());
			goodsmsg.setGoodsId(cart.getGoodsId());
			goodsmsg.setGoodsNum(cart.getGoodsNum());
			goodsmsg.setPrice(goods.getPrice());
			goodsmsg.setShowImage(goods.getShowImage());
			goodsmsg.setColor(goods.getColour());
			goodsmsg.setSize(goods.getSizes());
			if (goodsmsg.getColor()==null) {
				goodsmsg.setColor("0");
			}
			if (goodsmsg.getSize()==null) {
				goodsmsg.setSize("0");
			}
			msglist.add(goodsmsg);
		}
		LocalDateTime time = LocalDateTime.now();
		Connection connection = DBHelper.getConnection();
		try {
			PreparedStatement ps1 = connection.prepareStatement(sql3);
			ResultSet rs = ps1.executeQuery();
			ordersId++;
			while(rs.next()){
				if (rs.getString("ordersId").equals(ordersId+"")) {
					ordersId++;
				}
			}
			PreparedStatement ps = connection.prepareStatement(sql1);
			double total = 0;
			ps.setString(1, ordersId+"");
			ps.setString(2, "");
			ps.setString(3, usersId);
			ps.setString(4, time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			for (GoodsMsg goodsMsg2 : msglist) {
				total += goodsMsg2.getGoodsNum()*goodsMsg2.getPrice();
			}
			ps.setDouble(5, total);
			ps.executeUpdate();
			ps = connection.prepareStatement(sql2);
			ps1 = connection.prepareStatement(sql4);
			for (GoodsMsg goodsMsg : msglist) {
				rs = ps1.executeQuery();
				ordersItemId++;
				while(rs.next()){
					if (rs.getString("ordersItemId").equals(ordersItemId+"")) {
						ordersItemId++;
					}
				}
				ps.setString(1, ordersItemId+"");
				ps.setInt(2, goodsMsg.getGoodsId());
				ps.setInt(3, goodsMsg.getGoodsNum());
				ps.setString(4, ordersId+"");
				ps.setString(5, goodsMsg.getColor());
				ps.setString(6, goodsMsg.getSize());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
	}

}
