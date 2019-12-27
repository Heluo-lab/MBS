package com.mbs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mbs.dto.DataMapping;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 对数据进行解析
 * @author 何虎
 *
 */
public class StringParse {
	
	/**
	 * 尺寸解析
	 * 根据传入的字符串解析成对应格式的字符串 以 , 分割
	 * @param sizeStr 尺寸字符串
	 * @return 以 , 分割的字符串 如果没有则返回 "" 空串
	 */
	public static String getSize(String sizeStr){
		String regex = "<b>([^<]*)</b>";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sizeStr);
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			sb.append(m.group(1));
			sb.append(",");
		}
		return sb.length()!=0 ? sb.substring(0,sb.length()-1) : "";
	}
	
	/**
	 * 图片地址解析
	 * 根据传入的图片地址集合，颜色代码，图片大小返回符合条件的字符串
	 * @param uriList 图片地址集合
	 * @param colorCode 颜色代码
	 * @param picSize 图片大小   (small , large  ,huge)
	 * @return 以 @l@ 分割的字符串 如果没有符合条件的则返回   "" 空串 
	 */
	public static String getURLs(List<String> uriList,String colorCode,String picSize){
		StringBuffer sb = new StringBuffer();
		for (String uri : uriList) {
			if(uri.contains(colorCode) && uri.contains(picSize)){
				sb.append(uri);
				sb.append("@l@");
			}
		}
		return sb.length()!=0 ? sb.substring(0,sb.length()-3) : "";
	}
	
	/**
	 * 根据传入的集合生成指定格式的字符串
	 * @param list 传入的对象集合
	 * @return  集合不为空
	 * 	{color:[{colorName:黑色, colorCode:GBK, sizes:M,S,L,S},{colorName:分红, colorCode:DDDD, sizes:M,JJL,S}]}
	 * 			集合为空
	 * 	{color:[]}
	 */
	public static String getColorDataJSON(List<DataMapping> list){
		StringBuffer sb = new StringBuffer("{color:[");
		for (DataMapping data : list) {
			sb.append(data);
			sb.append(",");
		}
		if(list.size() != 0){
			sb.setCharAt(sb.length()-1, ']');
		}else{
			sb.append("]");
		}
		sb.append("}");
		return sb.toString();
	}
	
	/**
	 * 根据传入JSON型的字符串解析数据存入集合中
	 * @param colorDataJSON 含有数据的JOSN字符串
	 * @return 返回List<DataMapping> 集合
	 */
	public static List<DataMapping> getColorDataObj(String colorDataJSON){
		List<DataMapping> dataList = new ArrayList<>();
		JSONObject total = JSONObject.fromObject(colorDataJSON);
		JSONArray arr = JSONArray.fromObject(total.get("color"));
		for (Object object : arr) {
			JSONObject single = JSONObject.fromObject(object);
			dataList.add(new DataMapping(single.getString("colorName"),single.getString("colorCode"),single.getString("sizes")));
		}
		return dataList;
	}
	
	public static void main(String[] args) {
		List<DataMapping> data = new ArrayList<>();
		data.add(new DataMapping("黑色","GBK","M,S,L,S"));
		data.add(new DataMapping("白色","UTF","SP01,SP02"));
		data.add(new DataMapping("枣红","GB32","001,002"));
		data.add(new DataMapping("分红","DDDD","M,JJL,S"));
		String colorData = getColorDataJSON(data);
		System.out.println(colorData);
		List<DataMapping> colorDataObj = getColorDataObj(colorData);
		for (DataMapping dataMapping : colorDataObj) {
			System.out.println(dataMapping.getColorName()+"==="+dataMapping.getColorCode()+"==="+dataMapping.getSizes());
		}
	}
}
