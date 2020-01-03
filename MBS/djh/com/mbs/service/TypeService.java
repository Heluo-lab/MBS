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
	//获取十条男装的子分类
	public List<Type> getManlist();
	//获取十条女装的子分类
	public List<Type> getWomenlist();
	//获取十条内衣的子分类
	public List<Type> getUnderWearlist();
	//获取十条鞋包的子分类
	public List<Type> getShoesBaglist();
	
	
}
