package com.Beans;
import java.io.Serializable;
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userPassword;
	private String userPhone;
	private String userAddress;
	public User(){}
	public User(String userName, String userPassword)
	{
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public User(String userName, String userPassword, String userPhone, String userAddress)
	{
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserPassword()
	{
		return userPassword;
	}
	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}
	public String getUserPhone()
	{
		return userPhone;
	}
	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}
	public String getUserAddress()
	{
		return userAddress;
	}
	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}
}