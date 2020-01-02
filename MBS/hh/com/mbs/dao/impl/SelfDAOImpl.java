package com.mbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mbs.dao.SelfDAO;
import com.mbs.db.DBHelper;
import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Goods;
/**
 * 个人信息具体实现类
 * @author heluo
 *
 */
public class SelfDAOImpl implements SelfDAO{

	/**
	 * 根据用户ID查询用户所有信息
	 */
	@Override
	public UsersInfo querySingleUser(String usersId) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String sql = "select * from account a , users u where a.accountId = u.usersId and a.accountId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersId);
		ResultSet rs = pstmt.executeQuery();
		UsersInfo users = null;
		if(rs.next()){
			users = new UsersInfo();
			users.setAccountId(rs.getString("accountId"));
			users.setAccountName(rs.getString("accountName"));
			users.setAccountEmail(rs.getString("accountEmail"));
			users.setAccountPass(rs.getString("accountPass"));
			users.setAccountBirth(rs.getString("accountBirth"));
			users.setUsersSex(rs.getString("usersSex"));
			users.setUsersPhone(rs.getString("usersPhone"));
			users.setUsersBirth(rs.getString("usersBirth"));
			users.setUsersAddressProv(rs.getString("usersAddressProv"));
			users.setUsersAddressCity(rs.getString("usersAddressCity"));
			users.setUsersAddressCountry(rs.getString("usersAddressCountry"));
			users.setUsersPic(rs.getString("usersPic"));
		}
		DBHelper.release();
		return users;
	}

	@Override
	public List<Goods> queryCollectGoodsByUsersId(String usersId) throws SQLException {
		List<Goods> goodsList = new ArrayList<>();
		Connection conn = DBHelper.getConnection();
		String sql = "select id,goodsName,showImage,price  from goods where id in (select goodsId from collect where usersId = 2)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			
		}
		return null;
	}


}
