package com.mbs.pojo;


public class Repository {

  private long id;
  private long gId;
  private String goodsId;
  private String colorCode;
  private String colorName;
  private String sizes;
  private long repositoryCount;


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


  public String getSizes() {
    return sizes;
  }

  public void setSizes(String sizes) {
    this.sizes = sizes;
  }


  public long getRepositoryCount() {
    return repositoryCount;
  }

  public void setRepositoryCount(long repositoryCount) {
    this.repositoryCount = repositoryCount;
  }

}
