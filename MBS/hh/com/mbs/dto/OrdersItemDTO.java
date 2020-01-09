package com.mbs.dto;

import com.mbs.pojo.Goods;

/**
 * 订单项DTO对象 存储订单项详细信息
 * @author heluo
 *
 */
public class OrdersItemDTO {
	//订单项Id
	private String ordersItemId;
	//订单项商品信息
	private Goods goods;
	//商品个数
	private String goodsNum;
	//所属订单Id
	private String ordersId;
	//商品颜色
	private String color;
	//商品尺寸
	private String size;
	
	
	public OrdersItemDTO() {
	}
	
	public String getOrdersItemId() {
		return ordersItemId;
	}
	public void setOrdersItemId(String ordersItemId) {
		this.ordersItemId = ordersItemId;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(String ordersId) {
		this.ordersId = ordersId;
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

	@Override
	public String toString() {
		return "OrdersItemDTO [ordersItemId=" + ordersItemId + ", goods=" + goods + ", goodsNum=" + goodsNum
				+ ", ordersId=" + ordersId + ", color=" + color + ", size=" + size + "]";
	}
	
}
