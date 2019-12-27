package com.mbs.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mbs.util.StringParse;

public class Test {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
//		System.out.println(new String("姊﹁姯鑾庝紭闆呰交濂㈣矇瀛愭瘺瑁呴グ鏂楃缇婃瘺澶ц。".getBytes("gbk"),"utf-8"));
//		String sizeStr = "<b>SP01</b>|<b>SP02</b>|<b>SP03</b>|<b>SP04</b>|<b>SP05</b>|<b>SP06</b>";
//		String regex = "<b>([^<]*)</b>";
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(sizeStr);
//		while(m.find()){
//			System.out.println(m.group(1));
//		}
		String coder = "CL01";
		String[] uris = {
				"http://vp1.mbsimg.com/ProductImg/97/1902/small/970155595-CL01-01-S.jpg",
				"http://vp1.mbsimg.com/ProductImg/97/1902/small/970155595-CL01-02-S.jpg",
				"http://vp1.mbsimg.com/ProductImg/97/1902/small/970155595-CL01-03-S.jpg",
				"http://vp1.mbsimg.com/ProductImg/97/1902/large/970155595-CL01-01-L.jpg",
				"http://vp1.mbsimg.com/ProductImg/97/1902/huge/970155595-CL01-01-H.jpg",
				"http://vp1.mbsimg.com/ProductImg/97/1902/huge/970155595-CL01-02-H.jpg",
				"http://vp1.mbsimg.com/ProductImg/97/1902/huge/970155595-CL01-03-H.jpg",
				"http://vp1.mbsimg.com/ProductImg/97/1902/small/970155595-CL02-01-S.jpg"
		};
//		List<String> list = Arrays.asList(uris);
//		System.out.println(list.size());
//		String urLs = getURLs(list, "CL01", "huge");
//		System.out.println(urLs);
//		for (String uri : uris) {
//			if(uri.contains(coder)&&uri.contains("huge")){
//				System.out.println(uri);
//			}
//		}
		String size = StringParse.getSize("");
		System.out.println(size.length());
	}
	
}
