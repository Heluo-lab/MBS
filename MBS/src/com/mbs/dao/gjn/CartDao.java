package com.mbs.dao.gjn;


import java.util.List;

import com.mbs.pojo.Cart;
import com.mbs.pojo.CartItem;

public interface CartDao {
	//根据用户id查所有购物车
	public List<CartItem> selectAllCartId(String usersId);
}
