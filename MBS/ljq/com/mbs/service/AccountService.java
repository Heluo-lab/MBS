package com.mbs.service;

import com.mbs.pojo.Account;

public interface AccountService {
	//查询用户昵称
	public boolean queryAccountName(String name);
	//查询用户邮箱
	public boolean queryAccountEmail(String email);
	//插入注册用户
	public boolean insertAccount(Account account);
	//查询用户
	public Account queryAccount(String email);
}
