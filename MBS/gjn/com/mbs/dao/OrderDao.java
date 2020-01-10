package com.mbs.dao;

import java.util.List;

import com.mbs.pojo.Receivinggoods;

public interface OrderDao {
	//查询所有地址根据usersId
	public List<Receivinggoods> selectAddress(String usersId);
	//增加地址
	public void addAddress(String receMsg,String usersId);
	//删除地址
	public void deleteAddress(String receId);
	//改变默认
	public void changeDefault(String receId,String usersId);
	//更新地址
	public void updateAddress(String receMsg);
	//提交订单GoodsMsg
	public void submitOrder(String usersId);
}
