package com.mbs.dto;

import java.io.Serializable;

public class GoodsMsg implements Serializable{
	private static final long serialVersionUID = -5067348018910916576L;
	
	private String cartItemId;
	private int goodsId;
	private int goodsNum;
	private String showImage;
	private String goodsName;
	private double price;
	private String color;
	private String size;
	
	public String getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}
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
	public String getShowImage() {
		return showImage;
	}
	public void setShowImage(String showImage) {
		this.showImage = showImage;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "GoodsMsg [goodsId=" + goodsId + ", goodsNum=" + goodsNum + ", showImage=" + showImage + ", goodsName="
				+ goodsName + ", price=" + price + "]";
	}
	
}
