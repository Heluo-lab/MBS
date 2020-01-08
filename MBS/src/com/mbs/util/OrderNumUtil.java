package com.mbs.util;

import java.util.Calendar;
import java.util.Random;

/**
 * 生成订单号
 * @author 何虎
 *
 */
public class OrderNumUtil {
	
	/**
	 * 生成订单编号 两位年份后两位 + 三位当前时间后三位毫秒数 + 两位订单金额后两位 + 随机生成三个数 共十位
	 * @param orderTatalMoney 订单金额
	 * @return 订单编号
	 */
	public static String getOrderNum(String orderTatalMoney){
		String orderNum = "";
		Calendar cal = Calendar.getInstance();
		//拼上年份后两位
		String yearStr = String.valueOf(cal.get(Calendar.YEAR)).substring(2);
		orderNum = orderNum + yearStr;
		long time = cal.getTime().getTime();
		//当前时间的毫秒数的后3位
		String timeStr = String.valueOf(time).substring(10);
		orderNum = orderNum + timeStr;
		//拼上订单总金额的后两位没有补零
		String orderTatalMoneyStr = orderTatalMoney.length()>2 ? orderTatalMoney.substring(orderTatalMoney.length()-2) : "0"+orderTatalMoney;
		orderNum = orderNum + orderTatalMoneyStr;
		//拼上三位随机数
		String ran = "";
		Random random = new Random();
		for(int i = 0 ; i< 3 ; i++){
			ran = ran + String.valueOf(random.nextInt(10));
		}
		orderNum = orderNum + ran;
		return orderNum;
	}
	public static void main(String[] args) {
		getOrderNum("566");
		getOrderNum("566");
		getOrderNum("566");
		getOrderNum("566");
	}
}
