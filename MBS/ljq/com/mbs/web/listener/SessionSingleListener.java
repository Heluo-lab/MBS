package com.mbs.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.mbs.pojo.Account;

/**
 * 单态登录
 * @author Administrator
 *
 */
@WebListener
public class SessionSingleListener implements HttpSessionAttributeListener{
	//key就是登录的账号，值是当前最新的session
	Map<String, HttpSession> map =new HashMap<String, HttpSession>();
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//存入session中的key
		String name =event.getName();
		//如果这个key是account，表示用户登录成功（有可能是同一个账号登录
		if ("account".equals(name)) {
			Account account =(Account)event.getValue();
			//如果是同一个账号，那么账号是一致的
			//如果不是同一个账号，那么账号不同
			String accountEmail =account.getAccountEmail();
			//表示之前登录过
			if (map.get(accountEmail)!=null) {
				//拿到老的session
				HttpSession oldSession =(HttpSession)map.get(accountEmail);
				//从老的session中获得原来登录的人
				Account oldaccount =(Account)oldSession.getAttribute("account");
				
				//从老的session中移除掉之前存进去的用户
				oldSession.removeAttribute("account");
				//向老的session中存入一个信息，目的是告诉用户被T下线
				oldSession.setAttribute("logoutMsg", "您的帐号已经在其他机器上登录，您被迫下线。");
			}
			//第一次用账号登录或者前面被移除
			map.put(accountEmail, event.getSession());
			System.out.println("帐号" + account.getAccountEmail()+ "登录。");
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name =event.getName();
		//注销
		if ("account".equals(name)) {
			Account account =(Account)event.getValue();
			//从map中消除session记录
			map.remove(account.getAccountEmail());
			System.out.println("帐号" + account.getAccountEmail() + "注销。");
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name =event.getName();
		//没有注销的情况下，用另一个账号登录
		if ("account".equals(name)) {
			//移除旧的登录信息
			Account oldaccount =(Account)event.getValue();
			map.remove(oldaccount.getAccountEmail());
			
			//新的登录信息
			Account account = (Account) event.getSession().getAttribute("account");
			//检查新登录的账号是否在别的机器上登陆过
			if (map.get(account.getAccountEmail()) != null) {
				//map中有记录，表明该账号在其他机器上登录过，将以前的登录失效
				HttpSession session = map.get(account.getAccountEmail());
				session.removeAttribute("account");
				session.setAttribute("logoutMsg", "您的帐号已经在其他机器上登录，您被迫下线。");
			}
			map.put(account.getAccountEmail(), event.getSession());
		}
	}

}
