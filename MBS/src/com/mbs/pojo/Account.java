package com.mbs.pojo;

import java.io.Serializable;
/**
 * 用户账号表对应实体类
 * @author heluo
 *
 */
public class Account implements Serializable{
	
	private static final long serialVersionUID = 3407291142501397308L;
	
	private String accountId;
	private String accountName;
	private String accountEmail;
	private String accountPass;
	private String accountBirth;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountEmail() {
		return accountEmail;
	}
	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	public String getAccountPass() {
		return accountPass;
	}
	public void setAccountPass(String accountPass) {
		this.accountPass = accountPass;
	}
	public String getAccountBirth() {
		return accountBirth;
	}
	public void setAccountBirth(String accountBirth) {
		this.accountBirth = accountBirth;
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", accountEmail=" + accountEmail
				+ ", accountPass=" + accountPass + ", accountBirth=" + accountBirth + "]";
	}
	
	
}
