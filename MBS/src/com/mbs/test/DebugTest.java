package com.mbs.test;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
//import org.junit.Test;
import org.junit.Test;

import com.mbs.util.MailUtils;
public class DebugTest {
	public static Logger log = Logger.getLogger(DebugTest.class);
	
//	@Test
//	public void logTest(){
//		log.warn("here");
//	}
	
	public static void loggTest(){
		log.warn("out");
	}
	
	@Test
	public void sendEmail(){
		try {
			MailUtils.sendMail("2737049873@qq.com", "验证码", "5656");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
