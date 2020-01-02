package com.mbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mbs.dao.ProductDao;
import com.mbs.db.DBHelper;
import com.mbs.dto.IDColorSizeOf;
import com.mbs.pojo.Goods;
import com.mbs.pojo.Repository;
import com.mbs.util.StringParse;

import net.sf.json.JSONObject;

public class ProductDaoimpl implements ProductDao{
	public IDColorSizeOf LoadingfoGoodsID(int id) {
//		建立连接
		Connection conn = DBHelper.getConnection();
//		POJO类存用来储内容
//		颜色 尺寸 拆分解析类
		IDColorSizeOf idcolorsizeof = null;
//		sql语句
		String sql = "select*from goods where id=?";
//		发送sql
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				idcolorsizeof = new IDColorSizeOf();
//				商品名字 直接拿
				idcolorsizeof.setGoodsName(rs.getString("goodsName"));
//				商品价格  直接拿
				idcolorsizeof.setPrice(rs.getDouble("price"));
//				商品图片  直接拿
				idcolorsizeof.setShowImage(rs.getString("ShowImage"));
//				商品颜色和他的尺寸 要拆开处理
				idcolorsizeof.setGoodsCode(rs.getString("goodsCode"));
				idcolorsizeof.setColourSizesList(StringParse.getColorDataObj(rs.getString("goodsCode")));
//				商品介绍图 直接拿
				idcolorsizeof.setGoodsInfoImage(rs.getString("goodsInfoImage"));
//				商品状态  直接拿
				idcolorsizeof.setGoodStatus(rs.getInt("goodStatus"));
//				商品热度 直接拿
				idcolorsizeof.setGoodsHot(rs.getInt("goodsHot"));
				
//				JSONObject.fromObject(idcolorsizeof);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idcolorsizeof;
	}

	@Override
	public Repository GidColorSizeOfRepositoryCount(int Gid, String ColorCode, String sizes) {
//		建立连接
		Connection conn = DBHelper.getConnection();
//		POJO类存用来储内容
//		颜色 尺寸 拆分解析类
		Repository repository = null;
//		sql语句
		String sql = "select repositoryCount from repository where Gid=? and ColorCode=? and sizes=?";
//		商品数量 从repositoryCount表拿
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,Gid);
			ps.setString(2, ColorCode);
			ps.setString(3, sizes);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				repository = new Repository();
				repository.setRepositoryCount(rs.getLong("repositoryCount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return repository;
	}
}
