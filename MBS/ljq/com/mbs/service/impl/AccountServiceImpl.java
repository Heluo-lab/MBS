package com.mbs.service.impl;

import java.sql.Connection;

import com.mbs.dao.AccountDao;
import com.mbs.dao.impl.AccountDaoImpl;
import com.mbs.db.DBHelper;
import com.mbs.pojo.Account;
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
			flag =dao.selectAccountEmail(email, conn);
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
	@Override
	public boolean insertAccount(Account account) {
		Connection conn =DBHelper.getConnection();
		boolean flag =false;
		try {
			conn.setAutoCommit(false);
			flag =dao.insertAccount(account, conn);
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
	
	//登录
	//查询用户
	@Override
	public Account queryAccount(String email) {
		Connection conn =DBHelper.getConnection();
		Account account =null;
		try {
			conn.setAutoCommit(false);
			account =dao.selectAccount(email, conn);
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
		return account;
	}

}
