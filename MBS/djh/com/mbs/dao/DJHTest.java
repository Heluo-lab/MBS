package com.mbs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mbs.dao.impl.DBHelper;
import com.mbs.dao.impl.GoodsDaoImpl;
import com.mbs.pojo.Goods;

public class DJHTest {

	public static void main(String[] args) throws SQLException {
		System.out.println("This is djh is");
		Connection conn = DBHelper.getConnection();
		
		GoodsDao gdao = new GoodsDaoImpl();
		List<Goods> list = gdao.selectAllGoods(1, 1, 30, conn);
		for (Goods goods : list) {
			System.out.println(goods);
		}
	}

}
