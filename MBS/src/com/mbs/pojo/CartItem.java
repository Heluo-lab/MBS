package com.mbs.pojo;


import java.io.Serializable;

public class CartItem implements Serializable{
	
	private static final long serialVersionUID = 4387028998615442954L;
	
	private String cartItemId;
	private int goodsId;
	private int goodsNum;
	private String CartId;
	private String color;
	private String size;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getCartId() {
		return CartId;
	}
	public void setCartId(String cartId) {
		CartId = cartId;
	}
	
}
