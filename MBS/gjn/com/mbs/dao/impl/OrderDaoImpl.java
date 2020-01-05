package com.mbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mbs.dao.OrderDao;
import com.mbs.pojo.Receivinggoods;

import net.sf.json.JSONObject;

import com.mbs.db.DBHelper;
import com.mbs.dto.GoodsMsg;

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
		receId++;
		JSONObject object = JSONObject.fromObject(receMsg);
		Receivinggoods receivinggoods = (Receivinggoods) JSONObject.toBean(object,Receivinggoods.class);
		Connection connection = DBHelper.getConnection();
		String sql = "insert into receivinggoods value(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, receId+"");
			ps.setString(2, receivinggoods.getReceName());
			ps.setString(3, receivinggoods.getRecePhone());
			ps.setString(4, receivinggoods.getReceAddressProv());
			ps.setString(5, receivinggoods.getReceAddressCity());
			ps.setString(6, receivinggoods.getReceAddressCountry());
			ps.setString(7, receivinggoods.getReceAddressDetaile());
			ps.setInt(8, 1);
			ps.setString(9, receivinggoods.getUsersId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
	}

}
