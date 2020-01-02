package com.mbs.dao;

import java.sql.Connection;
import java.util.List;

import com.mbs.pojo.Type;

public interface TypeDao {
	
	
	public List<Type> getTypeByParentId(int ParentId,Connection conn) throws Exception;
	public List<Type> getTypeByParentIdAndName(int ParentId, String name, Connection conn) throws Exception;
}
