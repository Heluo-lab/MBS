package com.mbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mbs.dao.GoodsDao;
import com.mbs.pojo.Goods;

public class GoodsDaoImpl implements GoodsDao {

	// 返回type类型的最大页数
	public int selectMaxPage(int tyid, int pageSize, Connection conn) throws Exception {
		String sql = "select count(*) from goods where tyid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, tyid);
		ResultSet rs = ps.executeQuery();
		int total = 0;
		if (rs.next()) {
			total = rs.getInt("count(*)");
		}
		return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
	}

	// 查分页的集合对象(不带条件查询)
	public List<Goods> selectAllGoods(int tyid, int pageNo, int pageSize, Connection conn) throws SQLException {
		String sql = "select * from goods where tyId=? limit ?,?";
		List<Goods> list = new ArrayList<Goods>();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, tyid);
		ps.setInt(2, (pageNo - 1) * pageSize);
		ps.setInt(3, pageSize);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Goods goods = new Goods();
			goods.setId(rs.getInt("id"));
			goods.setTyId(rs.getInt("tyId"));
			goods.setGoodsName(rs.getString("goodsName"));
			goods.setShowImage(rs.getString("showImage"));
			goods.setPrice(rs.getDouble("price"));
			goods.setGoodsHot(rs.getInt("goodsHot"));
			list.add(goods);
		}
		return list;
	}

	//查询此类型商品条数
	public int getTypeCount(int tyid, Connection conn) throws SQLException {
		String sql = "select count(*) from goods where tyid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, tyid);
		ResultSet rs = ps.executeQuery();
		int total = 0;
		if (rs.next()) {
			total = rs.getInt("count(*)");
		}
		return total;
	}

}
