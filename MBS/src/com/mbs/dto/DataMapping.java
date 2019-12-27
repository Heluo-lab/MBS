package com.mbs.dto;
/**
 * 颜色,颜色代码,尺寸对应关系DTO对象
 * @author 何虎
 * colorName 颜色  
 * colorCode 颜色代码
 * sizes 尺寸
 */
public class DataMapping {

	private String colorName;
	private String colorCode;
	private String sizes;
	
	public DataMapping() {
	}
	
	public DataMapping(String colorName, String colorCode, String sizes) {
		this.colorName = colorName;
		this.colorCode = colorCode;
		this.sizes = sizes;
	}
	
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public String getSizes() {
		return sizes;
	}
	public void setSizes(String sizes) {
		this.sizes = sizes;
	}
	
	@Override
	public String toString() {
		return "{colorName:\"" + colorName + "\", colorCode:\"" + colorCode + "\", sizes:\"" + sizes + "\"}";
	}
	
}
