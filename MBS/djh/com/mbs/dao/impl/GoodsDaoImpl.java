package com.mbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mbs.dao.GoodsDao;
import com.mbs.pojo.Goods;

public class GoodsDaoImpl implements GoodsDao {

	// 返回type类型的最大页数
	public int selectMaxPage(int tyid, int pageSize, Connection conn) throws Exception {
		String sql = "select count(*) from goods where tyid=? and goodStatus = 1";
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
		String sql = "select * from goods where tyId=? and goodStatus = 1 limit ?,?";
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

	// 查询此类型商品条数
	public int getTypeCount(int tyid, Connection conn) throws SQLException {
		String sql = "select count(*) from goods where tyid=? and goodStatus = 1 ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, tyid);
		ResultSet rs = ps.executeQuery();
		int total = 0;
		if (rs.next()) {
			total = rs.getInt("count(*)");
		}
		return total;
	}

	// 模糊查询商品(固定条数)
	public List<Object> findProductByWord(String word, Connection conn) throws SQLException {
		List<Object> list = new ArrayList<Object>();
		String sql = "select goodsName from goods where goodStatus = 1 and goodsName like ? limit 0,8";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + word + "%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			list.add(rs.getString("goodsName"));
		}
		return list;
	}

	// 模糊查询商品
	@Override
	public List<Goods> findProductByName(String goodsName, int pageSize, int pageNo, Connection conn)
			throws SQLException {
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select * from goods where goodStatus = 1 and goodsName like ?  limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + goodsName + "%");
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

	@Override
	public int getGoodsCount(String goodsName, Connection conn) throws SQLException {
		String sql = "select count(*) from goods where goodStatus = 1 and goodsName like ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + goodsName + "%");
		ResultSet rs = ps.executeQuery();
		int total = 0;
		if (rs.next()) {
			total = rs.getInt("count(*)");
		}
		return total;
	}

	// 通过商品名和商品页面展示数查询总页数
	public int selectMaxPageByName(String goodsName, int pageSize, Connection conn) throws SQLException {
		String sql = "select count(*) from goods where goodStatus = 1 and goodsName like ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + goodsName + "%");
		ResultSet rs = ps.executeQuery();
		int total = 0;
		if (rs.next()) {
			total = rs.getInt("count(*)");
		}
		return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
	}

	// 多条件查询
	@Override
	public List<Goods> selectAllGoods(int tyid, Map<String, String> map,int pageNo,int pageSize, Connection conn) throws SQLException {
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select * from goods where tyId=? and goodStatus = 1";
		StringBuffer sb = new StringBuffer(sql);
		if (map != null) {
			String sort=map.get("sort");
			Set<Map.Entry<String, String>> line = map.entrySet();
			for (Map.Entry<String, String> entry : line) {
				
				if ("order".equals(entry.getKey())) {
					//order=hot;time;price;
					if("hot".equals(entry.getValue())) {
						sb.append(" order by goodsHot ");
						
							if("desc".equals(sort)) {
								sb.append(" desc");
							}
						
					}
					if("time".equals(entry.getValue())) {
						sb.append(" order by createTime ");
						
						if("desc".equals(sort)) {
							sb.append(" desc");
						}
					}
					if("price".equals(entry.getValue())) {
						sb.append(" order by price ");
						
						if("desc".equals(sort)) {
							sb.append(" desc");
						}
					}
				}
				
				if ("min".equals(entry.getKey())) {
					
				}
				if ("max".equals(entry.getKey())) {
					
				}
			}
		}
		sb.append(" limit ? , ?");
		// 根据条件构建sql语句
		sql = sb.toString();
		int index = 1;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(index, tyid);
		if (map != null) {
			Set<Map.Entry<String, String>> line = map.entrySet();
			for (Map.Entry<String, String> entry : line) {
				if ("min".equals(entry.getKey())) {
					ps.setString(++index, entry.getValue());
				}
				if ("max".equals(entry.getKey())) {
					ps.setString(++index, entry.getValue());
				}
			}

		}
		ps.setInt(++index, (pageNo - 1) * pageSize);
		ps.setInt(++index, pageSize);
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

	//模糊搜索多条件查询
	public List<Goods> selectGoodsByName(String goodsName, Map<String, String> map, int pageNo, int pageSize,
			Connection conn) throws SQLException {
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select * from goods where goodStatus = 1 and goodsName like ? ";
		StringBuffer sb = new StringBuffer(sql);
		if (map != null) {
			String sort=map.get("sort");
			System.out.println(sort);
			Set<Map.Entry<String, String>> line = map.entrySet();
			for (Map.Entry<String, String> entry : line) {
				
				if ("order".equals(entry.getKey())) {
					//order=hot;time;price;
					if("hot".equals(entry.getValue())) {
						sb.append(" order by goodsHot ");
						
							if("desc".equals(sort)) {
								sb.append(" desc");
							}
						
					}
					if("time".equals(entry.getValue())) {
						sb.append(" order by createTime ");
						
						if("desc".equals(sort)) {
							sb.append(" desc");
						}
					}
					if("price".equals(entry.getValue())) {
						sb.append(" order by price ");
						
						if("desc".equals(sort)) {
							sb.append(" desc");
						}
					}
				}
				
				if ("min".equals(entry.getKey())) {
					
				}
				if ("max".equals(entry.getKey())) {
					
				}
			}
		}
		sb.append(" limit ? , ?");
		// 根据条件构建sql语句
		sql = sb.toString();
		System.out.println(sql);
		int index = 1;
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + goodsName + "%");
		if (map != null) {
			Set<Map.Entry<String, String>> line = map.entrySet();
			for (Map.Entry<String, String> entry : line) {
				if ("min".equals(entry.getKey())) {
					ps.setString(++index, entry.getValue());
				}
				if ("max".equals(entry.getKey())) {
					ps.setString(++index, entry.getValue());
				}
			}

		}
		ps.setInt(++index, (pageNo - 1) * pageSize);
		ps.setInt(++index, pageSize);
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

}
