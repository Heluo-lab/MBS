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
}
