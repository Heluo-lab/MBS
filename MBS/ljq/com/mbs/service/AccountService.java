package com.mbs.service;

public interface AccountService {
	//查询用户昵称
	public boolean queryAccountName(String name);
	//查询用户邮箱
	public boolean queryAccountEmail(String email);
}
