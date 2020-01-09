package com.mbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mbs.dao.UsersDao;
import com.mbs.pojo.Users;

public class UsersDaoImpl implements UsersDao{
	//插入用户，用来完善个人信息
	@Override
	public void insertUsers(String usersId,String usersPic, Connection conn) throws Exception {
		String sql ="insert into users(usersId,usersPic) values(?,?)";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, usersId);
		ps.setString(2, usersPic);
		int result =ps.executeUpdate();
	}

}
