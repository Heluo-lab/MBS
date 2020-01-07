package com.mbs.pojo;


public class Orders {

  private String ordersId;
  private String receivingGoodsId;
  private String usersId;
  private String ordersTime;
  private double ordersTotalMoney;
  private int ordersStatus;//1未付款/2已付款/3已发货/4已完成


  public String getOrdersId() {
    return ordersId;
  }

  public void setOrdersId(String ordersId) {
    this.ordersId = ordersId;
  }


  public String getReceivingGoodsId() {
    return receivingGoodsId;
  }

  public void setReceivingGoodsId(String receivingGoodsId) {
    this.receivingGoodsId = receivingGoodsId;
  }


  public String getUsersId() {
    return usersId;
  }

  public void setUsersId(String usersId) {
    this.usersId = usersId;
  }


  public String getOrdersTime() {
    return ordersTime;
  }

  public void setOrdersTime(String ordersTime) {
    this.ordersTime = ordersTime;
  }


  public double getOrdersTotalMoney() {
    return ordersTotalMoney;
  }

  public void setOrdersTotalMoney(double ordersTotalMoney) {
    this.ordersTotalMoney = ordersTotalMoney;
  }


  public int getOrdersStatus() {
    return ordersStatus;
  }

  public void setOrdersStatus(int ordersStatus) {
    this.ordersStatus = ordersStatus;
  }

}
