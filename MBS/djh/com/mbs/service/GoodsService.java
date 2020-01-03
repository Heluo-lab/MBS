package com.mbs.service;

import java.util.List;

import com.mbs.pojo.Goods;

public interface GoodsService {


	//通过商品类型和商品页面展示数查询总页数
	public int selectMaxPage(int typeid, int pageSize);
	//通过商品类型和商品页面展示数商品信息集合
	public List<Goods> selectAllStudent(int typeid, int pageSize, int pageNo);
	//获取推荐商品集合
	public List<Goods> selectReconmmendGoods();
}
