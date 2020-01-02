package com.mbs.service;


import com.mbs.dto.UsersInfo;

/**
 * 个人信息具体业务
 * @author heluo
 *
 */
public interface SelfService {
	
	//根据用户ID查询用户
	public UsersInfo querySingleUser(String usersId);
	
}
