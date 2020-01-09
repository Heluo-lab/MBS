package com.mbs.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.mbs.dto.UsersInfo;
import com.mbs.pojo.Account;
import com.mbs.service.SelfService;
import com.mbs.service.impl.SelfServiceImpl;
/**
 * 监听用户登录存入session account 账号对象  usersInfo 个人完整信息对象
 * @author 何虎
 *
 */
@WebListener
public class LoginListener implements HttpSessionAttributeListener{

	//监听用户登录
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		String attrName = se.getName();
		if("account".equals(attrName)){
			HttpSession session = se.getSession();
			Account account = (Account)se.getValue();
			String accountId = account.getAccountId();
			SelfService service = new SelfServiceImpl();
			UsersInfo users = service.querySingleUser(accountId);
			session.setAttribute("usersInfo", users);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		String attrName = se.getName();
		if("account".equals(attrName)){
			HttpSession session = se.getSession();
			session.removeAttribute("usersInfo");
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		
	}

}
