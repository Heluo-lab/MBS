package com.mbs.service;


import java.util.List;


import com.mbs.pojo.Type;

public interface TypeService{
	
	//获取商品顶级分类
	public List<Type> getGoodsTopType();
	//获取推荐商品分类
	public List<Type> getGoodsRecommendType();
	//获取子分类
	public List<Type> getSonType(int parentId);
	
}
