package com.mbs.pojo;


public class Ordersitem {
	
  private String ordersItemId;
  private long goodsId;
  private long goodsNum;
  private String ordersId;
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

public String getOrdersItemId() {
    return ordersItemId;
  }

  public void setOrdersItemId(String ordersItemId) {
    this.ordersItemId = ordersItemId;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public long getGoodsNum() {
    return goodsNum;
  }

  public void setGoodsNum(long goodsNum) {
    this.goodsNum = goodsNum;
  }


  public String getOrdersId() {
    return ordersId;
  }

  public void setOrdersId(String ordersId) {
    this.ordersId = ordersId;
  }

}
