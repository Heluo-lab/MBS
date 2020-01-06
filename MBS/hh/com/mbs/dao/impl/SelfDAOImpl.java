package com.mbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

	/**
	 * 根据用户Id查询该用户所有收藏的商品
	 */
	@Override
	public List<Goods> queryCollectGoodsByUsersId(String usersId) throws SQLException {
		List<Goods> goodsList = new ArrayList<>();
		Connection conn = DBHelper.getConnection();
		String sql = "select id,goodsName,showImage,price  from goods where id in (select goodsId from collect where usersId = ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Goods goods = new Goods();
			goods.setId(rs.getInt("id"));
			goods.setGoodsName(rs.getString("goodsName"));
			goods.setShowImage(rs.getString("showImage"));
			goods.setPrice(rs.getInt("price"));
			goodsList.add(goods);
		}
		DBHelper.release();
		return goodsList;
	}
	
	//根据用户ID与商品IDs删除用户收藏的商品
	public int deleteCollectByGoodsId(String usersId, int goodsId) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String sql = "delete from collect where goodsId = ? and usersId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, goodsId);
		pstmt.setString(2, usersId);
		int rows = pstmt.executeUpdate();
		DBHelper.release();
		return rows;
	}

	//根据用户ID与商品ID添加收藏
	@Override
	public int addCollect(String usersId, int goodsId) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String sql = "insert into collect value(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, UUID.randomUUID().toString());
		pstmt.setInt(2, goodsId);
		pstmt.setString(3, usersId);
		int rows = pstmt.executeUpdate();
		DBHelper.release();
		return rows;
	}
	
	//根据用户ID与商品ID查询是否有收藏记录 true 表示有记录 ，false表示无记录
	@Override
	public boolean queryCollect(String usersId, int goodsId) throws SQLException {
		boolean flag = false;
		Connection conn = DBHelper.getConnection();
		String sql = "select * from collect where goodsId = ? and  usersId= ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, goodsId);
		pstmt.setString(2, usersId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			flag = true;
		}
		DBHelper.release();
		return flag;
	}
	//根据用户Id,商品名称在收藏商品查询相关商品
	@Override
	public List<Goods> queryCollectGoodsByUsersId(String usersId, String goodsName) throws SQLException {
		List<Goods> goodsList = new ArrayList<>();
		Connection conn = DBHelper.getConnection();
		String sql ="select id,goodsName,showImage,price from goods where id in (select goodsId from collect where usersId = ?) and goodsName like ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,usersId);
		pstmt.setString(2, "%"+goodsName+"%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Goods goods = new Goods();
			goods.setId(rs.getInt("id"));
			goods.setGoodsName(rs.getString("goodsName"));
			goods.setShowImage(rs.getString("showImage"));
			goods.setPrice(rs.getInt("price"));
			goodsList.add(goods);
		}
		DBHelper.release();
		return goodsList;
	}

	//修改用户信息
	@Override
	public int updateUsersInfo(UsersInfo usersInfo) throws SQLException {
		return 0;
	}


}
