package com.mbs.pojo;


public class Orders {

  private String ordersId;
  private String receivingGoodsId;
  private String usersId;
  private String ordersTime;
  private double ordersTotalMoney;
  private String ordersStatus;


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


  public String getOrdersStatus() {
    return ordersStatus;
  }

  public void setOrdersStatus(String ordersStatus) {
    this.ordersStatus = ordersStatus;
  }

}
