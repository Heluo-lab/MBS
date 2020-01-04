package com.mbs.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.mbs.dao.TypeDao;
import com.mbs.dao.impl.TypeDaoImpl;
import com.mbs.db.DBHelper;
import com.mbs.pojo.Type;
import com.mbs.service.TypeService;

public class TypeServiceImpl implements TypeService{
	//创建dao层对象
	TypeDao dao = new TypeDaoImpl();
	
	//业务方法
	
	//获取商品顶级分类
	public List<Type> getGoodsTopType() {
		Connection conn = DBHelper.getConnection();
		ArrayList<Type> list = null;
		try {
			 list = (ArrayList<Type>) dao.getTypeByParentId(0, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return list;
	}

	//获取女装推荐商品分类(女装id=15)
	public List<Type> getGoodsRecommendType() {
		Connection conn = DBHelper.getConnection();
		List<Type> list = null;
		try {
			 list = dao.getTypeByParentIdAndName(15, "热销推荐", conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return list;
	}

	//通过父类id返回子类类型集合
	public List<Type> getSonType(int parentId) {
		Connection conn = DBHelper.getConnection();
		ArrayList<Type> list = null;
		try {
			 list = (ArrayList<Type>) dao.getTypeByParentId(parentId, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return list;
	}

	//获取六条男装的子分类
	public List<Type> getManlist() {
		Connection conn = DBHelper.getConnection();
		ArrayList<Type> list = null;
		try {
			 list = (ArrayList<Type>) dao.getTypeByParentIdTen(1,6, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return list;
	}

	//获取十条女装的子分类
	public List<Type> getWomenlist() {
		Connection conn = DBHelper.getConnection();
		ArrayList<Type> list = null;
		try {
			 list = (ArrayList<Type>) dao.getTypeByParentIdTen(15,10, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return list;
	}

	//获取十条内衣的子分类
	public List<Type> getUnderWearlist() {
		Connection conn = DBHelper.getConnection();
		ArrayList<Type> list = null;
		try {
			 list = (ArrayList<Type>) dao.getTypeByParentIdTen(54,10, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return list;
	}

	//获取鞋包的子分类
	public List<Type> getShoesBaglist() {
		Connection conn = DBHelper.getConnection();
		ArrayList<Type> list = null;
		try {
			 list = (ArrayList<Type>) dao.getTypeByParentIdAndName(122, "女包", conn);
			 List<Type> list2 = dao.getTypeByParentIdAndName(125, "鞋包", conn);
			 list.addAll(list2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.release();
		}
		return list;
	}
		
	
}
