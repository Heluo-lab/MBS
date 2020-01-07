package com.mbs.dao;


import java.util.List;

import com.mbs.pojo.Cart;
import com.mbs.pojo.CartItem;

public interface CartDao {
	//根据用户id查所有购物车
	public List<CartItem> selectAllCartId(String usersId);
	//传入usersId,商品id添加购物车
	public void addCartItem(String usersId,int goodsId, int goodsNum,String color,String size);
	//传入usersId,商品id删除选中购物车中的商品
	public void deleteCart(String usersId,int goodsId,String color,String size);
	//传usersId,商品id减少购物车的数量
	public void minusCart(String usersId,int goodsId, int goodsNum,String color,String size);
	//删除用户所有购物车
	public void deleteCart(String usersId);
	//通过goodsHot获得goodsId
	public int selectGoodsId(int goodsHot);
}
