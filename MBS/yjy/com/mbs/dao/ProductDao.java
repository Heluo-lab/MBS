package com.mbs.dao;

import java.util.List;

import com.mbs.dto.IDColorSizeOf;
import com.mbs.pojo.Repository;

public interface ProductDao {
//	根据商品ID加载内容
	public IDColorSizeOf LoadingfoGoodsID(int id);
//	根据商品id颜色尺码查询库存
	public Repository GidColorSizeOfRepositoryCount(int Gid,String ColorCode,String sizes);
//	根据商品id查询颜色表
	public IDColorSizeOf IdToColor(int Gid);
//	根据颜色 ID 加载 对应图片
	public IDColorSizeOf IdColorOfImg(int Gid,String colorCode);
//	根据ID 和 颜色编码查询商品颜色
	public IDColorSizeOf IdColoridOfColorNameandimg(int Gid,String colorCode);
//	根据id 查询颜色尺码集合
	public List<String> IdOfColorandsize(int id,String colorCode);
}
