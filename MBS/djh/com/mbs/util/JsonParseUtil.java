package com.mbs.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonParseUtil {

	//将一个对象对转成json形式的字符串
	public static String GetJson(Object o) {
		JSONObject json = JSONObject.fromObject(o);
		return json.toString();
	}
	//将一个集合转换成json形式的字符串
	public static String GetJson(List<?> list) {
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}
}
