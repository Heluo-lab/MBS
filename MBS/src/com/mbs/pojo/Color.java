package com.mbs.pojo;


public class Color {

  private long id;
  private long gId;
  private String goodsId;
  private String colorCode;
  private String colorName;
  private String colorImage;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getGId() {
    return gId;
  }

  public void setGId(long gId) {
    this.gId = gId;
  }


  public String getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(String goodsId) {
    this.goodsId = goodsId;
  }


  public String getColorCode() {
    return colorCode;
  }

  public void setColorCode(String colorCode) {
    this.colorCode = colorCode;
  }


  public String getColorName() {
    return colorName;
  }

  public void setColorName(String colorName) {
    this.colorName = colorName;
  }


  public String getColorImage() {
    return colorImage;
  }

  public void setColorImage(String colorImage) {
    this.colorImage = colorImage;
  }

}
