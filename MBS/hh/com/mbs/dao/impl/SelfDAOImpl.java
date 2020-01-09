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
import com.mbs.pojo.Orders;
import com.mbs.pojo.Ordersitem;
import com.mbs.pojo.Receivinggoods;
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

	//修改用户表信息
	@Override
	public int updateUsersByUsersId(UsersInfo usersInfo) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String sql = "update users set usersSex = ? ,usersPhone = ? , usersBirth = ? ,usersAddressProv = ? ,usersAddressCity = ? ,usersAddressCountry = ? , usersPic = ? where usersId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersInfo.getUsersSex());
		pstmt.setString(2, usersInfo.getUsersPhone());
		pstmt.setString(3, usersInfo.getUsersBirth());
		pstmt.setString(4, usersInfo.getUsersAddressProv());
		pstmt.setString(5, usersInfo.getUsersAddressCity());
		pstmt.setString(6, usersInfo.getUsersAddressCountry());
		pstmt.setString(7, usersInfo.getUsersPic());
		pstmt.setString(8, usersInfo.getAccountId());
		int rows = pstmt.executeUpdate();
		DBHelper.release();
		return rows;
	}
	
	//根据用户ID修改账号表信息(key表示要修改的信息 accountName ,accoutPass,accountEmail) value表示要修改的值
	@Override
	public int updateAccountByUsersId(String key,String value,String accountId) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String sql = "update account set "+key+" = ? where accountId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, value);
		pstmt.setString(2, accountId);
		int rows = pstmt.executeUpdate();
		DBHelper.release();
		return rows;
	}
	//根据用户Id查询该用户所有录入的收货地址
	@Override
	public List<Receivinggoods> queryReceAddress(String usersId) throws SQLException {
		List<Receivinggoods> receList = new ArrayList<>();
		Connection conn = DBHelper.getConnection();
		String sql = "select * from receivinggoods where usersId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Receivinggoods rece = new Receivinggoods();
			rece.setReceId(rs.getString("receId"));
			rece.setReceName(rs.getString("receName"));
			rece.setRecePhone(rs.getString("recePhone"));
			rece.setReceAddressProv(rs.getString("receAddressProv"));
			rece.setReceAddressCity(rs.getString("receAddressCity"));
			rece.setReceAddressCountry(rs.getString("receAddressCountry"));
			rece.setReceAddressDetaile(rs.getString("receAddressDetaile"));
			rece.setIsDefault(rs.getLong("isDefault"));
			rece.setUsersId(rs.getString("usersId"));
			receList.add(rece);
		}
		DBHelper.release();
		return receList;
	}
	
	//根据收货Id查询该收货地址
	public Receivinggoods querySingleReceAddressByReceId(String receId) throws SQLException{
		Receivinggoods rece = null;
		Connection conn = DBHelper.getConnection();
		String sql = "select * from receivinggoods where receId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, receId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			rece = new Receivinggoods();
			rece.setReceId(rs.getString("receId"));
			rece.setReceName(rs.getString("receName"));
			rece.setRecePhone(rs.getString("recePhone"));
			rece.setReceAddressProv(rs.getString("receAddressProv"));
			rece.setReceAddressCity(rs.getString("receAddressCity"));
			rece.setReceAddressCountry(rs.getString("receAddressCountry"));
			rece.setReceAddressDetaile(rs.getString("receAddressDetaile"));
			rece.setIsDefault(rs.getLong("isDefault"));
			rece.setUsersId(rs.getString("usersId"));
		}
		DBHelper.release();
		return rece;
	}

	//根据用户Id增加用户的收货地址
	@Override
	public int insertReceAddressByUsersId(Receivinggoods rece) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String sql = "insert into receivinggoods value(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rece.getReceId());
		pstmt.setString(2, rece.getReceName());
		pstmt.setString(3, rece.getRecePhone());
		pstmt.setString(4, rece.getReceAddressProv());
		pstmt.setString(5, rece.getReceAddressCity());
		pstmt.setString(6, rece.getReceAddressCountry());
		pstmt.setString(7, rece.getReceAddressDetaile());
		pstmt.setLong(8, rece.getIsDefault());
		pstmt.setString(9, rece.getUsersId());
		int rows = pstmt.executeUpdate();
		DBHelper.release();
		return rows;
	}

	//根据收货信息ID删除该收获地址
	@Override
	public int deleteReceAddressByUsersIdAndReceId(String receId) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String sql = "delete from receivinggoods where receId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, receId);
		int rows = pstmt.executeUpdate();
		DBHelper.release();
		return rows;
	}

	//根据用户Id与收货信息ID修改该收获地址
	@Override
	public int updateReceAddressByUsersIdAndReceId(Receivinggoods rece) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String sql = "update receivinggoods set receName = ?, recePhone = ? , receAddressProv = ?, receAddressCity = ?, receAddressCountry = ?, receAddressDetaile = ? where receId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rece.getReceName());
		pstmt.setString(2, rece.getRecePhone());
		pstmt.setString(3, rece.getReceAddressProv());
		pstmt.setString(4, rece.getReceAddressCity());
		pstmt.setString(5, rece.getReceAddressCountry());
		pstmt.setString(6, rece.getReceAddressDetaile());
		pstmt.setString(7, rece.getReceId());
		int rows = pstmt.executeUpdate();
		DBHelper.release();
		return rows;
	}

	//xx根据用户Id与收货信息ID将此收货信息取消默认地址xx 失效
	//根据用户Id将该用户所有地址都设为不默认
	@Override
	public int removeDefaultAddressByUsersIdAndReceId(String usersId) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String sql = "update receivinggoods set isDefault = 0 where usersId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersId);
		int rows = pstmt.executeUpdate();
		DBHelper.release();
		return rows;
	}

	//根据用户Id与收货信息ID将此收货信息设置为默认地址
	@Override
	public int setDefaultAddressByUsersIdAndReceId(String receId) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String sql = "update receivinggoods set isDefault = 1 where receId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, receId);
		int rows = pstmt.executeUpdate();
		DBHelper.release();
		return rows;
	}

	@Override
	public List<Orders> queryAllOrdersByUsersId(String usersId) throws SQLException {
		List<Orders> ordersList = new ArrayList<>();
		Connection conn = DBHelper.getConnection();
		String sql = "select * from orders where usersId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, usersId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Orders orders = new Orders();
			orders.setOrdersId(rs.getString("ordersId"));
			orders.setReceivingGoodsId(rs.getString("receivingGoodsId"));
			orders.setUsersId(rs.getString("usersId"));
			orders.setOrdersTime(rs.getString("ordersTime"));
			orders.setOrdersTotalMoney(rs.getDouble("ordersTotalMoney"));
			orders.setOrdersStatus(rs.getInt("ordersStatus"));
			orders.setOrdersNum(rs.getString("ordersNum"));
			ordersList.add(orders);
		}
		DBHelper.release();
		return ordersList;
	}

	@Override
	public List<Ordersitem> queryAllOrdersItemByOrdersId(String ordersId) throws SQLException {
		List<Ordersitem> ordersItemList = new ArrayList<>();
		Connection conn = DBHelper.getConnection();
		String sql = "select * from ordersItem where ordersId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ordersId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Ordersitem ordersItem = new Ordersitem();
			ordersItem.setOrdersItemId(rs.getString("ordersItemId"));
			ordersItem.setGoodsId(rs.getLong("goodsId"));
			ordersItem.setGoodsNum(rs.getLong("goodsNum"));
			ordersItem.setOrdersId(rs.getString("ordersId"));
			ordersItem.setColor(rs.getString("color"));
			ordersItem.setSize(rs.getString("size"));
			ordersItemList.add(ordersItem);
		}
		DBHelper.release();
		return ordersItemList;
	}

	@Override
	public Goods queryGoodsById(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String sql ="select goodsName,showImage,price from goods where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		Goods goods = null;
		if(rs.next()){
			goods = new Goods();
			goods.setId(id);
			goods.setGoodsName(rs.getString("goodsName"));
			goods.setShowImage(rs.getString("showImage"));
			goods.setPrice(rs.getDouble("price"));
		}
		return goods;
	}


}
