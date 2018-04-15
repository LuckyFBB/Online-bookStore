package com.Beans;
import java.io.Serializable;
import java.sql.Timestamp;
public class Order implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String bookName;
	private String bookPhoto;
	private String bookPrice;
	private String bookLowPrice;
	private int bookAmount;
	private String bookState;
	private String userPhone;
	private String userAddress;
	private Timestamp buyingTime;
	public Order(){}
	public Order(String userName, String bookPrice, String bookLowPrice, int bookAmount)
	{
		super();
		this.userName = userName;
		this.bookPrice = bookPrice;
		this.bookLowPrice = bookLowPrice;
		this.bookAmount = bookAmount;
	}
	public Order(String bookName, String bookPhoto, String bookPrice, String bookLowPrice, int bookAmount,
			String bookState,Timestamp buyingTime)
	{
		super();
		this.bookName = bookName;
		this.bookPhoto = bookPhoto;
		this.bookPrice = bookPrice;
		this.bookLowPrice = bookLowPrice;
		this.bookAmount = bookAmount;
		this.bookState = bookState;
		this.buyingTime=buyingTime;
	}
	public Order(String userName, String bookName, String bookPhoto, String bookPrice, String bookLowPrice,
			String userPhone, String userAddress)
	{
		super();
		this.userName = userName;
		this.bookName = bookName;
		this.bookPhoto = bookPhoto;
		this.bookPrice = bookPrice;
		this.bookLowPrice = bookLowPrice;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}
	public Order(String userName, String bookName, String bookPhoto, String bookPrice, String bookLowPrice,
			int bookAmount, String bookState, String userPhone, String userAddress)
	{
		super();
		this.userName = userName;
		this.bookName = bookName;
		this.bookPhoto = bookPhoto;
		this.bookPrice = bookPrice;
		this.bookLowPrice = bookLowPrice;
		this.bookAmount = bookAmount;
		this.bookState = bookState;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}
	public Order(String bookName, String bookPhoto, String bookPrice, String bookLowPrice, int bookAmount)
	{
		super();
		this.bookName = bookName;
		this.bookPhoto = bookPhoto;
		this.bookPrice = bookPrice;
		this.bookLowPrice = bookLowPrice;
		this.bookAmount = bookAmount;
	}
	public Order(String userName, String bookName, String bookPhoto, String bookPrice, String bookLowPrice,
			int bookAmount, String userPhone, String userAddress)
	{
		super();
		this.userName = userName;
		this.bookName = bookName;
		this.bookPhoto = bookPhoto;
		this.bookPrice = bookPrice;
		this.bookLowPrice = bookLowPrice;
		this.bookAmount = bookAmount;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}
	public Order(String userName, String bookName, String bookPhoto, String bookPrice, String bookLowPrice,
			int bookAmount, String bookState, String userPhone, String userAddress,Timestamp buyingTime)
	{
		super();
		this.userName = userName;
		this.bookName = bookName;
		this.bookPhoto = bookPhoto;
		this.bookPrice = bookPrice;
		this.bookLowPrice = bookLowPrice;
		this.bookAmount = bookAmount;
		this.bookState = bookState;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.buyingTime=buyingTime;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getBookName()
	{
		return bookName;
	}
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}
	public String getBookPhoto()
	{
		return bookPhoto;
	}
	public void setBookPhoto(String bookPhoto)
	{
		this.bookPhoto = bookPhoto;
	}
	public String getBookPrice()
	{
		return bookPrice;
	}
	public void setBookPrice(String bookPrice)
	{
		this.bookPrice = bookPrice;
	}
	public String getBookLowPrice()
	{
		return bookLowPrice;
	}
	public void setBookLowPrice(String bookLowPrice)
	{
		this.bookLowPrice = bookLowPrice;
	}
	public int getBookAmount()
	{
		return bookAmount;
	}
	public void setBookAmount(int bookAmount)
	{
		this.bookAmount = bookAmount;
	}
	
	public String getBookState()
	{
		return bookState;
	}
	public void setBookState(String bookState)
	{
		this.bookState = bookState;
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
	public Timestamp getBuyingTime()
	{
		return buyingTime;
	}
	public void setBuyingTime(Timestamp buyingTime)
	{
		this.buyingTime = buyingTime;
	}
}
