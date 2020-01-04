package com.mbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mbs.dao.TypeDao;
import com.mbs.db.DBHelper;
import com.mbs.pojo.Type;

public class TypeDaoImpl implements TypeDao {

	// 查询所有的子类类型，通过父类id
	public List<Type> getTypeByParentId(int ParentId, Connection conn) throws Exception {
		List<Type> list = new ArrayList<Type>();
		String sql = "select * from type where parentId=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ParentId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Type type = new Type();
				type.setId(rs.getInt("id"));
				type.setTypeName(rs.getString("typeName"));
				type.setParentId(rs.getInt("parentId"));
				type.setParentName(rs.getString("parentName"));
				list.add(type);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// 查询所有的子类类型，通过父类id(只拿十条)
	public List<Type> getTypeByParentIdTen(int ParentId, int count,Connection conn) throws Exception {
		List<Type> list = new ArrayList<Type>();
		String sql = "select * from type where parentId=? limit 0,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ParentId);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Type type = new Type();
				type.setId(rs.getInt("id"));
				type.setTypeName(rs.getString("typeName"));
				type.setParentId(rs.getInt("parentId"));
				type.setParentName(rs.getString("parentName"));
				list.add(type);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 查询所有的子类类型，通过父类id,name
	public List<Type> getTypeByParentIdAndName(int ParentId, String name, Connection conn) throws Exception {
		List<Type> list = new ArrayList<Type>();
		String sql = "select * from type where parentId=? and parentName = ? limit 0 ,10";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ParentId);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Type type = new Type();
				type.setId(rs.getInt("id"));
				type.setTypeName(rs.getString("typeName"));
				type.setParentId(rs.getInt("parentId"));
				type.setParentName(rs.getString("parentName"));
				list.add(type);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
