package com.mbs.service;

import java.sql.Connection;

import com.mbs.pojo.Account;

public interface AccountService {
	//查询用户昵称
	public boolean queryAccountName(String name);
	//查询用户邮箱
	public boolean queryAccountEmail(String email);
	//插入用户
	public boolean insertAccount(Account account);
	//查询用户,无密码登录
	public Account queryAccount(String email);
	//修改用户密码，临时密码处
	public void updateAccount(Account account);
	//登录
	public Account login(String email,String pwd);
}
