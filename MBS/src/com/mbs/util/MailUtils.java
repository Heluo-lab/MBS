package com.mbs.util;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 邮箱发送功能具体实现
 * 调用sendMail方法即可发送邮箱给目标对象
 * @author 何虎
 *
 */
public class MailUtils {
	
	private static String sender = null;
	private static String code = null;
	private static Document config = null;
	
	static{
		//初始化邮箱发送者信息
		//解析email.xml中的配置数据
		SAXReader read = new SAXReader();
		InputStream is = MailUtils.class.getResourceAsStream("/email.xml");
		try {
			config = read.read(is);
			Element eleSender = (Element) config.selectSingleNode("/emails/email/sender");
			sender = eleSender.getTextTrim();
			Element eleCode = (Element) config.selectSingleNode("/emails/email/code");
			code = eleCode.getTextTrim();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param email 邮件发给谁
	 * @param subject 邮箱主题
	 * @param emailMsg 邮件的内容
	 * @throws AddressException 邮箱地址异常
	 * @throws MessagingException 信息异常
	 */
	public static void sendMail(String email, String subject, String emailMsg)
			throws AddressException, MessagingException {
		
		// 1.创建一个程序与邮件服务器会话对象 Session
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");//发邮件的协议
		props.setProperty("mail.host", "smtp.qq.com");//发送邮件的服务器地址
		props.setProperty("mail.smtp.auth", "true");// 指定验证为true

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, code);//发邮件的账号的验证
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(sender)); // 设置发送者

		message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者

		message.setSubject(subject);//邮件的主题

		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送
		Transport.send(message);
		
	}
}
