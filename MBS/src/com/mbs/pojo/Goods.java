package com.mbs.pojo;

import java.io.Serializable;

public class Goods implements Serializable{
	private int id;
	private String goodsid;
	private String goodsName;
	private int tyid;
	private int typeld;
	private String showlmage;
	private double price;
	private String goodsinfolmage;
	private String goodsCode;
	private int goodsHot;
	private int isShow;
	private int goodStatus;
	private String createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getTyid() {
		return tyid;
	}
	public void setTyid(int tyid) {
		this.tyid = tyid;
	}
	public int getTypeld() {
		return typeld;
	}
	public void setTypeld(int typeld) {
		this.typeld = typeld;
	}
	public String getShowlmage() {
		return showlmage;
	}
	public void setShowlmage(String showlmage) {
		this.showlmage = showlmage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGoodsinfolmage() {
		return goodsinfolmage;
	}
	public void setGoodsinfolmage(String goodsinfolmage) {
		this.goodsinfolmage = goodsinfolmage;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public int getGoodsHot() {
		return goodsHot;
	}
	public void setGoodsHot(int goodsHot) {
		this.goodsHot = goodsHot;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	public int getGoodStatus() {
		return goodStatus;
	}
	public void setGoodStatus(int goodStatus) {
		this.goodStatus = goodStatus;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
