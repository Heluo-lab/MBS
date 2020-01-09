package com.mbs.service.impl;

import java.sql.Connection;

import com.mbs.dao.UsersDao;
import com.mbs.dao.impl.UsersDaoImpl;
import com.mbs.db.DBHelper;
import com.mbs.service.UsersService;

public class UsersServiceImpl implements UsersService{
	private UsersDao dao =new UsersDaoImpl();
	//插入用户
	@Override
	public void insertUsers(String usersId,String usersPic) {
		Connection conn =DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			dao.insertUsers(usersId, usersPic, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			DBHelper.release();
		}
	}

}
