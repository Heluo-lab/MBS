package com.mbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mbs.db.DBHelper;
import com.mbs.pojo.Goods;

public interface GoodsDao {

	//通过商品类型和商品页面展示数查询总页数
	public int selectMaxPage(int typeid, int pageSize,Connection conn) throws Exception;
	
	//通过商品tyid和pageNo和pageSize查询商品信息集合
	public List<Goods> selectAllGoods(int tyid, int pageNo,int pageSize,Connection conn) throws SQLException;

}
