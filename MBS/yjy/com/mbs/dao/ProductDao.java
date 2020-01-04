package com.mbs.dao;

import com.mbs.dto.IDColorSizeOf;
import com.mbs.pojo.Repository;

public interface ProductDao {
//	根据商品ID加载内容
	public IDColorSizeOf LoadingfoGoodsID(int id);
//	根据商品id颜色尺码查询库存
	public Repository GidColorSizeOfRepositoryCount(int Gid,String ColorCode,String sizes);
//	根据颜色 ID 加载 对应图片
	public IDColorSizeOf IdColorOfImg(int Gid,String colorCode);
}
