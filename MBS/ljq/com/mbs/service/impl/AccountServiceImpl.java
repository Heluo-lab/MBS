package com.mbs.service.impl;

import java.sql.Connection;

import com.mbs.dao.AccountDao;
import com.mbs.dao.impl.AccountDaoImpl;
import com.mbs.db.DBHelper;
import com.mbs.service.AccountService;

public class AccountServiceImpl implements AccountService{
	private AccountDao dao =new AccountDaoImpl();
	//查询用户昵称
	@Override
	public boolean queryAccountName(String name) {
		Connection conn =DBHelper.getConnection();
		boolean flag =false;
		try {
			//设置连接为手动提交
			conn.setAutoCommit(false);
			flag =dao.selectAccountName(name, conn);
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
		return flag;
	}
	//查询用户邮箱
	@Override
	public boolean queryAccountEmail(String email) {
		Connection conn =DBHelper.getConnection();
		boolean flag =false;
		try {
			conn.setAutoCommit(false);
			flag =dao.selectAccountEail(email, conn);
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
		return flag;
	}

}
