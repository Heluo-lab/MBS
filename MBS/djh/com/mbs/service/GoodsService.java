package com.mbs.service;

import java.util.List;
import java.util.Map;

import com.mbs.pojo.Goods;

public interface GoodsService {


	//通过商品类型和商品页面展示数查询总页数
	public int selectMaxPage(int typeid, int pageSize);
	//通过商品类型和商品页面展示数商品信息集合
	public List<Goods> selectAllStudent(int typeid, int pageSize, int pageNo);
	//获取推荐商品集合
	public List<Goods> selectReconmmendGoods();
	//通过tyid得到商品数
	public int getTypeCount(int tyid);
	//通过字符串模糊查询商品信息
	public List<Object> findProductByWord(String word);
	//通过商品名查询商品
	public List<Goods> selectGoodsByName(String goodsName, int pageSize, int pageNo);
	//通过商品名查询商品数量
	public int getGoodsCount(String goodsName);
	//通过商品名和商品页面展示数查询总页数
	public int selectMaxPageByname(String goodsName, int pageSize);
	//多条件查询
	public List<Goods> selectAllStudent(int tyid, Map<String, String> param, int pageSize, int pageNo);
	//模糊搜索多条件查询
	public List<Goods> selectGoodsByName(String goodsName, Map<String, String> param, int pageSize, int pageNo);
}
