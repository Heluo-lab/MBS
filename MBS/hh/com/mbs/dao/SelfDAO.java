package com.mbs.dao;

import java.sql.SQLException;
import java.util.List;

import com.mbs.dto.UsersInfo;
/**
 * 个人信息DAO层
 * @author heluo
 *
 */
import com.mbs.pojo.Goods;
import com.mbs.pojo.Orders;
import com.mbs.pojo.Ordersitem;
import com.mbs.pojo.Receivinggoods;
public interface SelfDAO {
	
	//根据用户ID查询用户
	public UsersInfo querySingleUser(String usersId) throws SQLException;
	
	//根据用户ID查询用户收藏商品
	public List<Goods> queryCollectGoodsByUsersId(String usersId) throws SQLException;
	
	//根据用户ID与商品ID删除用户收藏的商品
	public int deleteCollectByGoodsId(String usersId , int goodsId) throws SQLException;
	
	//根据用户ID与商品ID查询是否有收藏记录
	public boolean queryCollect(String usersId,int goodsId) throws SQLException;
	
	//根据用户ID与商品ID添加收藏
	public int addCollect(String usersId,int goodsId) throws SQLException;
	
	//根据用户Id,商品名称在收藏商品查询相关商品
	public List<Goods> queryCollectGoodsByUsersId(String usersId,String goodsName) throws SQLException;
	
	//修改用户信息
	public int updateUsersByUsersId(UsersInfo usersInfo) throws SQLException;
	
	//根据用户ID修改账号表信息(key表示要修改的信息 accountName ,accoutPass,accountEmail) value表示要修改的值
	public int updateAccountByUsersId(String key,String value,String accountId) throws SQLException;
	
	//根据用户Id查询该用户所有录入的收货地址
	public List<Receivinggoods> queryReceAddress(String usersId)throws SQLException;
	
	//根据收货Id查询该收货地址
	public Receivinggoods querySingleReceAddressByReceId(String receId) throws SQLException;
	
	//根据用户Id增加用户的收货地址
	public int insertReceAddressByUsersId(Receivinggoods rece) throws SQLException;
	
	//根据收货信息ID删除该收获地址
	public int deleteReceAddressByUsersIdAndReceId(String receId) throws SQLException;
	
	//根据用户Id与收货信息ID修改该收获地址
	public int updateReceAddressByUsersIdAndReceId(Receivinggoods rece) throws SQLException;
	
	//根据收货信息ID将此收货信息取消默认地址
	public int removeDefaultAddressByUsersIdAndReceId(String receId) throws SQLException;
	
	//根据收货信息ID将此收货信息设置为默认地址
	public int setDefaultAddressByUsersIdAndReceId(String receId) throws SQLException;
	
	//根据用户Id查询该用户所有订单
	public List<Orders> queryAllOrdersByUsersId(String usersId) throws SQLException;
	
	//根据订单号查询所有订单项
	public List<Ordersitem> queryAllOrdersItemByOrdersId(String ordersId) throws SQLException;
	
	//根据商品Id查询商品名字 图片信息
	public Goods queryGoodsById(int id) throws SQLException;
	
}
