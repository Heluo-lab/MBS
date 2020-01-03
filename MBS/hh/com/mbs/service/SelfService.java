package com.mbs.service;


import java.util.List;

import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Goods;

/**
 * 个人信息具体业务
 * @author heluo
 *
 */
public interface SelfService {
	
	//根据用户ID查询用户
	public UsersInfo querySingleUser(String usersId);
	
	//根据用户ID查询用户收藏商品
	public List<Goods> queryCollectGoodsByUsersId(String usersId);

}
