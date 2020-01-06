package com.mbs.dto;
/**
 * 储存个人信息的DTO对象
 * @author heluo
 *
 */
public class UsersInfo {
	
	private String accountId;
	private String accountName;
	private String accountEmail;
	private String accountPass;
	private String accountBirth;
	private String usersSex;
	private String usersPhone;
	private String usersBirth;
	private String usersAddressProv;
	private String usersAddressCity;
	private String usersAddressCountry;
	private String usersPic;
	
	public UsersInfo() {
	}
	
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
	public String getUsersSex() {
		return usersSex;
	}
	public void setUsersSex(String usersSex) {
		this.usersSex = usersSex;
	}
	public String getUsersPhone() {
		return usersPhone;
	}
	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}
	public String getUsersBirth() {
		return usersBirth;
	}
	public void setUsersBirth(String usersBirth) {
		this.usersBirth = usersBirth;
	}
	public String getUsersAddressProv() {
		return usersAddressProv;
	}
	public void setUsersAddressProv(String usersAddressProv) {
		this.usersAddressProv = usersAddressProv;
	}
	public String getUsersAddressCity() {
		return usersAddressCity;
	}
	public void setUsersAddressCity(String usersAddressCity) {
		this.usersAddressCity = usersAddressCity;
	}
	public String getUsersAddressCountry() {
		return usersAddressCountry;
	}
	public void setUsersAddressCountry(String usersAddressCountry) {
		this.usersAddressCountry = usersAddressCountry;
	}
	public String getUsersPic() {
		return usersPic;
	}
	public void setUsersPic(String usersPic) {
		this.usersPic = usersPic;
	}

	@Override
	public String toString() {
		return "UsersInfo [accountId=" + accountId + ", accountName=" + accountName + ", accountEmail=" + accountEmail
				+ ", accountPass=" + accountPass + ", accountBirth=" + accountBirth + ", usersSex=" + usersSex
				+ ", usersPhone=" + usersPhone + ", usersBirth=" + usersBirth + ", usersAddressProv=" + usersAddressProv
				+ ", usersAddressCity=" + usersAddressCity + ", usersAddressCountry=" + usersAddressCountry
				+ ", usersPic=" + usersPic + "]";
	}
	
	
}
