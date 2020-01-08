package com.mbs.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mbs.dao.AccountDao;
import com.mbs.pojo.Account;

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
	public boolean selectAccountEmail(String email, Connection conn) throws Exception {
		String sql ="select * from Account where accountEmail=?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs =ps.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}
	@Override
	public boolean insertAccount(Account account, Connection conn) throws Exception {
		String sql ="insert into Account values(?,?,?,?,?)";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, account.getAccountId());
		ps.setString(2, account.getAccountName());
		ps.setString(3, account.getAccountEmail());
		ps.setString(4, account.getAccountPass());
		ps.setString(5, account.getAccountBirth());
		int result =ps.executeUpdate();
		if (result>0) {
			return true;
		}
		return false;
	}
	
	//无密码登录登录，是否存在
	@Override
	public Account selectAccount(String email, Connection conn) throws Exception {
		String sql="select * from Account where accountEmail=?";
		Account account =null;
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs =ps.executeQuery();
		if (rs.next()) {
			account =new Account();
			account.setAccountId(rs.getString("accountId"));
			account.setAccountName(rs.getString("accountName"));
			account.setAccountEmail(rs.getString("accountEmail"));
			account.setAccountPass(rs.getString("accountPass"));
			account.setAccountBirth(rs.getString("accountBirth"));
		}
		return account;
	}
	//修改用户密码
	@Override
	public void updateAccount(Account account, Connection conn) throws Exception {
		String sql ="update account set accountPass=? where accountEmail=?";
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, account.getAccountPass());
		ps.setString(2, account.getAccountEmail());
		int result =ps.executeUpdate();
	}
	//登录
	@Override
	public Account login(String email, String pwd, Connection conn) throws Exception {
		String sql="select * from Account where accountEmail=? and accountPass=?";
		Account account =null;
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, pwd);
		ResultSet rs =ps.executeQuery();
		if (rs.next()) {
			account =new Account();
			account.setAccountId(rs.getString("accountId"));
			account.setAccountName(rs.getString("accountName"));
			account.setAccountEmail(rs.getString("accountEmail"));
			account.setAccountPass(rs.getString("accountPass"));
			account.setAccountBirth(rs.getString("accountBirth"));
		}
		return account;
	}

}
