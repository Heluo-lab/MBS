package com.mbs.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.map.StaticBucketMap;

import com.mbs.dao.CartDao;
import com.mbs.db.DBHelper;
import com.mbs.pojo.CartItem;

public class CartDaoImpl implements CartDao{

	@Override
	public List<CartItem> selectAllCartId(String usersId){
		Connection connection = DBHelper.getConnection();
		String sql = "select * from cart where usersId= "+usersId;
		List<CartItem> list = new ArrayList<CartItem>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String cartId = rs.getString("cartId");
				String sql1 = "select * from cartItem where cartId= "+cartId;
				PreparedStatement ps1 = connection.prepareStatement(sql1);
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					CartItem ci = new CartItem();
					ci.setCartId(cartId);
					ci.setCartItemId(rs1.getString("cartItemId"));
					ci.setGoodsId(rs1.getInt("goodsId"));
					ci.setGoodsNum(rs1.getInt("goodsNum"));
					list.add(ci);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return list;
	}

	private static int cartId = 0;
	private static int cartItemId = 0;
	
	
	@Override
	public void addCartItem(String usersId, int goodsId ,int goodsNum) {
		Connection connection = DBHelper.getConnection();
		String sql1 = "insert into cart (cartId,usersId) value (?,?) ";
		String sql2 = "select * from cart where usersId="+usersId;
		String sql3 = "insert into cartItem (cartItemId,goodsId,goodsNum,cartId) value (?,?,?,?)";
		String sqlci = "select * from cartItem where cartId=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			rs.next();
			//该用户是否有购物车
			if (rs.getRow()==0) {
				//插入购物车
				ps = connection.prepareStatement(sql1);
				cartId++;
				ps.setString(1, cartId+"");
				ps.setString(2, usersId+"");
				ps.executeUpdate();
				//插入购物车项
				ps = connection.prepareStatement(sql3);
				cartItemId++;
				ps.setString(1, cartItemId+"");
				ps.setInt(2, goodsId);
				ps.setInt(3, goodsNum);
				ps.setString(4, cartId+"");
				ps.executeUpdate();
				
			}else {
				//查询cartId
				PreparedStatement ps1 = connection.prepareStatement(sql2);
				rs = ps.executeQuery();
				rs.next();
				int cid = Integer.parseInt(rs.getString("cartId"));
				ps1 = connection.prepareStatement(sqlci);
				ps1.setString(1,cid+"");
				ResultSet rsci = ps1.executeQuery();
				while(rsci.next()) {
					int comparecartItemId = Integer.parseInt(rsci.getString("cartItemId"));
					System.out.println(comparecartItemId);
					cartItemId++;
				}
				cartItemId++;
				//查询购物车中是否已经有了商品
				String sql5 = "select * from cartItem where goodsId="+goodsId+" and cartId="+cid;
				ps1 = connection.prepareStatement(sql5);
				rs = ps1.executeQuery();
				rs.next();
				if (rs.getRow()==0) {
					ps1 = connection.prepareStatement(sql3);
					ps1.setString(1, cartItemId+"");
					ps1.setInt(2, goodsId);
					ps1.setInt(3, goodsNum);
					ps1.setString(4, cid+"");
					ps1.executeUpdate();
				}else {
					String sql4 = "update cartItem set goodsNum=? where cartId="+cid+" and goodsId="+goodsId;
					ps1 = connection.prepareStatement(sql4);
					ps1.setInt(1, goodsNum);
					ps1.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
	}


	@Override
	public void deleteCart(String usersId, int goodsId) {
		Connection connection = DBHelper.getConnection();
		int cid = 0;
		String sql1 = "delete from cartItem where cartId=? and goodsId="+goodsId;
		String sql2 = "select * from cart where usersId="+usersId;
		try {
			//查询cartId
			PreparedStatement ps = connection.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			rs.next();
			cid = Integer.parseInt(rs.getString("cartId"));
			//删除cartItem
			ps = connection.prepareStatement(sql1);
			ps.setString(1, cid+"");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
	}


	@Override
	public void minusCart(String usersId, int goodsId, int goodsNum) {
		Connection connection = DBHelper.getConnection();
		String sql = "update cart set goodsNum="+goodsNum+"where cartId = ? and goodsId = "+goodsId;
		String sql1 = "select * from cart where usersId ="+usersId;
		try {
			//查cartId
			PreparedStatement ps = connection.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int cartId = Integer.parseInt(rs.getString("cartId"));
			ps = connection.prepareStatement(sql);
			ps.setString(1, cartId+"");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
	}

}
