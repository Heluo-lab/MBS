package com.mbs.dao;

import java.util.List;

import com.mbs.pojo.Receivinggoods;

public interface OrderDao {
	//查询所有地址根据usersId
	public List<Receivinggoods> selectAddress(String usersId);
	//增加地址
	public void addAddress(String receMsg);
}
