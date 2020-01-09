package com.mbs.dao;

import java.sql.Connection;

import com.mbs.pojo.Account;
import com.mbs.pojo.Users;

/**
 * 用户信息表
 * @author Administrator
 *
 */
public interface UsersDao {
	//插入注册用户，为了完善用户信息
	public void insertUsers(String usersId,Connection conn) throws Exception;
}
