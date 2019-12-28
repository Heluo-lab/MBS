package com.mbs.pojo;

import java.io.Serializable;

/**
 * 
 * @author heluo
 * 用户表对应实体类
 *
 */
public class Users implements Serializable{
	
	private static final long serialVersionUID = 8559947201196262158L;
	
	private String usersId;
	private String usersSex;
	private String usersPhone;
	private String usersBirth;
	private String usersAddressProv;
	private String usersAddressCity;
	private String usersAddressCountry;
	
	public Users() {
	}

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
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

	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", usersSex=" + usersSex + ", usersPhone=" + usersPhone + ", usersBirth="
				+ usersBirth + ", usersAddressProv=" + usersAddressProv + ", usersAddressCity=" + usersAddressCity
				+ ", usersAddressCountry=" + usersAddressCountry + "]";
	}
	
	
}
