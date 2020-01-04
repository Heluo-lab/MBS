package com.mbs.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mbs.dao.ProductDao;
import com.mbs.dao.impl.ProductDaoimpl;
import com.mbs.db.DBHelper;
import com.mbs.dto.IDColorSizeOf;
import com.mbs.pojo.Repository;
import com.mbs.service.ProductService;
import com.mbs.util.StringParse;

public class ProductServiceimpl implements ProductService{
	private ProductDao dao = new ProductDaoimpl();
	
	public IDColorSizeOf LoadingfoGoodsID(int id) {
		IDColorSizeOf idcolorsizeof = dao.LoadingfoGoodsID(id);
		return idcolorsizeof;
	}

	public Repository GidColorSizeOfRepositoryCount(int Gid, String ColorCode, String sizes) {
		Repository repository = dao.GidColorSizeOfRepositoryCount(Gid, ColorCode, sizes);
		return repository;
	}
	public IDColorSizeOf IdColorOfImg(int Gid, String colorCode) {
		IDColorSizeOf idcolorsizeof = dao.IdColorOfImg(Gid, colorCode);
		return idcolorsizeof;
	}
	
}

