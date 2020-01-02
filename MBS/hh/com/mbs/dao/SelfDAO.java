package com.mbs.dao;

import java.sql.SQLException;

import com.mbs.dto.UsersInfo;
/**
 * 个人信息DAO层
 * @author heluo
 *
 */
public interface SelfDAO {
	
	//根据用户ID查询用户
	public UsersInfo querySingleUser(String usersId) throws SQLException;
}
