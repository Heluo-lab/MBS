package com.mbs.dto;

import java.util.ArrayList;
import java.util.List;

import com.mbs.pojo.Receivinggoods;
/**
 * 订单详细信息
 * @author 何虎
 *
 */
public class OrdersDTO {
	//订单UUId 主键
	private String ordersId;
	//收货信息
	private Receivinggoods rece = new Receivinggoods();
	//订单所属账户
	private UsersInfo usersInfo = new UsersInfo();
	//下单时间
	private String ordersTime;
	//订单总金额
	private double ordersTotalMoney;
	//订单状态  //1未付款/2已付款/3已发货/4已完成
	private int ordersStatus;
	//订单编号
	private String ordersNum;
	//订单所有订单项
	private List<OrdersItemDTO> itemsList = new ArrayList<>();
	
	public OrdersDTO() {
	}

	public String getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(String ordersId) {
		this.ordersId = ordersId;
	}

	public Receivinggoods getRece() {
		return rece;
	}

	public void setRece(Receivinggoods rece) {
		this.rece = rece;
	}

	public UsersInfo getUsersInfo() {
		return usersInfo;
	}

	public void setUsersInfo(UsersInfo usersInfo) {
		this.usersInfo = usersInfo;
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

	public String getOrdersNum() {
		return ordersNum;
	}

	public void setOrdersNum(String ordersNum) {
		this.ordersNum = ordersNum;
	}

	public List<OrdersItemDTO> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<OrdersItemDTO> itemsList) {
		this.itemsList = itemsList;
	}

	@Override
	public String toString() {
		return "OrdersDTO [ordersId=" + ordersId + ", rece=" + rece + ", usersInfo=" + usersInfo + ", ordersTime="
				+ ordersTime + ", ordersTotalMoney=" + ordersTotalMoney + ", ordersStatus=" + ordersStatus
				+ ", ordersNum=" + ordersNum + ", itemsList=" + itemsList + "]";
	}

	
}
