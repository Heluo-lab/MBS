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
	
}
