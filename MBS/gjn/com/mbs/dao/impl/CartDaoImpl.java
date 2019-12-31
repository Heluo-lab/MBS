package com.mbs.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		}
		return list;
	}

}
