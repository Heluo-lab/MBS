package com.mbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mbs.db.DBHelper;
import com.mbs.pojo.Goods;

public interface GoodsDao {

	//通过商品类型和商品页面展示数查询总页数
	public int selectMaxPage(int typeid, int pageSize,Connection conn) throws Exception;
	
	//通过商品tyid和pageNo和pageSize查询商品信息集合
	public List<Goods> selectAllGoods(int tyid, int pageNo,int pageSize,Connection conn) throws SQLException;
	
	//查询此类型商品条数
	public int getTypeCount(int tyid, Connection conn) throws SQLException;
	
	//模糊查询商品
	public List<Object> findProductByWord(String word, Connection conn) throws SQLException ;
	//模糊查询商品
	public List<Goods> findProductByName(String word, int pageSize, int pageNo, Connection conn) throws SQLException ;
	//模糊查询商品得到商品数量
	public int getGoodsCount(String goodsName, Connection conn)throws SQLException;
	//通过商品名和商品页面展示数查询总页数
	public int selectMaxPageByName(String goodsName, int pageSize, Connection conn) throws SQLException;
	//多条件查询
	public List<Goods> selectAllGoods(int tyid, Map<String, String> map,int pageNo,  int pageSize, Connection conn) throws SQLException;

}
