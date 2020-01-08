package com.mbs.dao;


import java.sql.Connection;

import com.mbs.pojo.Account;

public interface AccountDao {
	//查询用户昵称
	public boolean selectAccountName(String name,Connection conn) throws Exception;
	//查询用户邮箱
	public boolean selectAccountEmail(String email,Connection conn) throws Exception;
	//插入注册用户
	public boolean insertAccount(Account account,Connection conn) throws Exception;
	//查询用户(无密码登录)
	public Account selectAccount(String email,Connection conn) throws Exception;
	//修改用户密码，临时密码处
	public void updateAccount(Account account,Connection conn) throws Exception;
	//查询用户(登录)
	public Account login(String email,String pwd,Connection conn) throws Exception;
}

