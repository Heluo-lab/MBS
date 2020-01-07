package com.mbs.dto;

import java.io.Serializable;
import java.util.List;

public class ColorNameAndImgAndCode implements Serializable{
//	颜色名字
	private String ColorName;
//	颜色图片
	private String ColorImg;
//	颜色编码
	private String ColorCode;
	
	public String getColorName() {
		return ColorName;
	}
	public void setColorName(String colorName) {
		ColorName = colorName;
	}
	public String getColorImg() {
		return ColorImg;
	}
	public void setColorImg(String colorImg) {
		ColorImg = colorImg;
	}
	public String getColorCode() {
		return ColorCode;
	}
	public void setColorCode(String colorCode) {
		ColorCode = colorCode;
	}

}
