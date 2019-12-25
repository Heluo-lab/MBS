package com.mbs.test;

import java.io.UnsupportedEncodingException;

public class Test {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(new String("姊﹁姯鑾庢椂灏氬唴琛ｆ棗鑸板簵".getBytes("gbk"),"utf-8"));
	}
}
