package com.mbs.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mbs.dao.GoodsDao;
import com.mbs.dao.impl.GoodsDaoImpl;
import com.mbs.db.DBHelper;
import com.mbs.pojo.Goods;
import com.mbs.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{

	//通过商品类型和商品页面展示数查询总页数
	public int selectMaxPage(int tyid, int pageSize) {
		Connection conn = DBHelper.getConnection();
		GoodsDao gdao = new GoodsDaoImpl();
		try {
			return gdao.selectMaxPage(tyid, pageSize, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return 0;
	}

	//通过商品类型和商品页面展示数商品信息集合
	public List<Goods> selectAllStudent(int tyid, int pageSize, int pageNo){
		Connection conn = DBHelper.getConnection();
		GoodsDao gdao = new GoodsDaoImpl();
		try {
			return gdao.selectAllGoods(tyid, pageNo, pageSize, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return null;
	}
	
	//获取推荐商品集合
	@Override
	public List<Goods> selectReconmmendGoods() {
		Connection conn = DBHelper.getConnection();
		GoodsDao gdao = new GoodsDaoImpl();
		try {
			return gdao.selectAllGoods(16, 1, 60, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.release();
		}
		return null;
	}

	//通过tyid得到商品数
	public int getTypeCount(int tyid) {
		Connection conn = DBHelper.getConnection();
		GoodsDao gdao = new GoodsDaoImpl();
		try {
			return gdao.getTypeCount(tyid,conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.release();
		}
		return 0;
	}

	//通过字符串模糊查询商品信息
	public List<Object> findProductByWord(String word) {
		Connection conn = DBHelper.getConnection();
		GoodsDao gdao = new GoodsDaoImpl();
		try {
			return gdao.findProductByWord(word,conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.release();
		}
		return null;
	}

	@Override
	//通过商品名查询商品
	public List<Goods> selectGoodsByName(String goodsName,int pageSize, int pageNo) {
		Connection conn = DBHelper.getConnection();
		GoodsDao gdao = new GoodsDaoImpl();
		try {
			return gdao.findProductByName(goodsName,pageSize, pageNo,conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.release();
		}
		return null;
	}

	//通过商品名查询商品数量
	@Override
	public int getGoodsCount(String goodsName) {
		Connection conn = DBHelper.getConnection();
		GoodsDao gdao = new GoodsDaoImpl();
		try {
			return gdao.getGoodsCount(goodsName,conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.release();
		}
		return 0;
	}

	//通过商品名和商品页面展示数查询总页数
	public int selectMaxPageByname(String goodsName, int pageSize) {
		Connection conn = DBHelper.getConnection();
		GoodsDao gdao = new GoodsDaoImpl();
		try {
			return gdao.selectMaxPageByName(goodsName, pageSize, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return 0;
	}

}
