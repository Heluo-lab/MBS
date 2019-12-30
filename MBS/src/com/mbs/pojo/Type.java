package com.mbs.pojo;


public class Type {

  private long id;
  private long typeId;
  private String typeName;
  private long parentId;
  private String parentName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getTypeId() {
    return typeId;
  }

  public void setTypeId(long typeId) {
    this.typeId = typeId;
  }


  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

}
