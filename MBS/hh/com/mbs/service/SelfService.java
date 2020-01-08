package com.mbs.service;


import java.util.List;

import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Goods;
import com.mbs.pojo.Receivinggoods;

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

	//根据用户ID与商品ID删除用户收藏的商品并返回剩余收藏
	public List<Goods> deleteCollectByGoodsIdAndReturnGoodsList(String usersId , int goodsId);
	
	//根据用户ID与商品ID添加收藏返回 success 为添加成功 , fail添加失败,exit表示该商品已被收藏 
	public String addCollect(String usersId,int goodsId);
	
	//根据用户Id,商品名称在收藏商品查询相关商品
	public List<Goods> queryCollectGoodsByUsersId(String usersId,String goodsName);
	
	//根据账号ID修改账号和用户信息
	public boolean updateUsersAndAccountByAccountId(UsersInfo usersInfo);
	
	//根据用户Id查询该用户所有录入的收货地址
	public List<Receivinggoods> queryReceAddress(String usersId);
	
	//根据用户Id增加用户的收货地址
	public int insertReceAddressByUsersId(Receivinggoods rece);
	
	//根据收货信息ID删除该收获地址
	public int deleteReceAddressByUsersIdAndReceId(String receId);
	
	//根据用户Id与收货信息ID修改该收获地址
	public int updateReceAddressByUsersIdAndReceId(Receivinggoods rece);
	
	//xx 根据收货地址Id修改为默认地址 beforeReceId为用户更改前的默认地址 afterReceId为更改后的地址 true表示都修改成功 , false表示为修改失败 xx失效
	//根据用户Id将该用户所有地址都设为不默认 并将receId设为默认地址
	public boolean setDefaultAddressByUsersIdAndReceId(String usersId,String receId);
}
