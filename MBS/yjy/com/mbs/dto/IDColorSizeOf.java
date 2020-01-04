package com.mbs.dto;

import java.util.List;

public class IDColorSizeOf{
//	商品ID
	private int id;
//	商品名字
	private String goodsName;
//	商品价格
	private Double price;
//	商品图片 
	private String ShowImage;
//	商品颜色尺寸
	private String goodsCode;
//	商品颜色
	private String colour;
//	商品尺寸
	private String sizes;
//	商品数量
	private int repositoryCount;
//	颜色尺寸集合
	private List<DataMapping> ColourSizesList;
//	商品介绍图
	private String goodsInfoImage;
//	商品状态
	private int goodStatus;
//	商品热度
	private int goodsHot;
//	商品编号
	private String goodsid;
//	商品橱窗图
	private String colorimage;
//	颜色编码 
	private String colorCode;

	public IDColorSizeOf() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public int getRepositoryCount() {
		return repositoryCount;
	}

	public void setRepositoryCount(int repositoryCount) {
		this.repositoryCount = repositoryCount;
	}

	public List<DataMapping> getColourSizesList() {
		return ColourSizesList;
	}

	public void setColourSizesList(List<DataMapping> colourSizesList) {
		ColourSizesList = colourSizesList;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getShowImage() {
		return ShowImage;
	}

	public void setShowImage(String showImage) {
		ShowImage = showImage;
	}

	public String getGoodsInfoImage() {
		return goodsInfoImage;
	}

	public void setGoodsInfoImage(String goodsInfoImage) {
		this.goodsInfoImage = goodsInfoImage;
	}

	public int getGoodStatus() {
		return goodStatus;
	}

	public void setGoodStatus(int goodStatus) {
		this.goodStatus = goodStatus;
	}

	public int getGoodsHot() {
		return goodsHot;
	}

	public void setGoodsHot(int goodsHot) {
		this.goodsHot = goodsHot;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getColorimage() {
		return colorimage;
	}

	public void setColorimage(String colorimage) {
		this.colorimage = colorimage;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	
}
