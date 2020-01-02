package com.mbs.service.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mbs.dao.SelfDAO;
import com.mbs.dao.impl.SelfDAOImpl;
import com.mbs.dto.UsersInfo;
import com.mbs.service.SelfService;
/**
 * 个人信息具体业务实现类
 * @author heluo
 *
 */

public class SelfServiceImpl implements SelfService{
	
	private Logger log = Logger.getLogger(SelfServiceImpl.class);

	private SelfDAO dao = new SelfDAOImpl();
	@Override
	public UsersInfo querySingleUser(String usersId){
		UsersInfo users = null;
		try {
			users = dao.querySingleUser(usersId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("用户查询出错");
		}
		return users;
	}
	
	
}
