package com.mbs.dao.ljq;

import java.sql.Connection;

public interface AccountDao {
	//查询用户昵称
	public boolean selectAccountName(String name,Connection conn) throws Exception;
	//查询用户邮箱
	public boolean selectAccountEail(String email,Connection conn) throws Exception;
	
}
