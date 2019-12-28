package com.mbs.dao.ljq.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mbs.dao.ljq.AccountDao;

public class AccountDaoImpl implements AccountDao{
	//注册，失去焦点，查询是否存在，否false,存在true
	//查询用户昵称
	@Override
	public boolean selectAccountName(String name, Connection conn) throws Exception {
		String sql ="select * from Account where accountName=?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs =ps.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}
	//查询用户邮箱
	@Override
	public boolean selectAccountEail(String email, Connection conn) throws Exception {
		String sql ="select * from Account where accountMail=?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs =ps.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}

}
