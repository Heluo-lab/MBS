package com.mbs.pojo;


import java.io.Serializable;

public class Cart implements Serializable{

	private static final long serialVersionUID = -2068786214160331373L;
	
	private String cartId;
	private String usersId;
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getUserId() {
		return usersId;
	}
	public void setUserId(String usersId) {
		this.usersId = usersId;
	}
}
