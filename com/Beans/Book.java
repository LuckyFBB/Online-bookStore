package com.Beans;

import java.io.Serializable;

public class Book implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String bookName;
	private String bookPhoto;
	private String bookType;
	private String bookWriter;
	private String bookPublisher;
	private String bookDate;
	private String bookContent;
	private String bookPrice;
	private String bookLowPrice;
	public Book(){}
	public Book(String bookName)
	{
		super();
		this.bookName = bookName;
	}
	public Book(String bookName, String bookPhoto, String bookType, String bookWriter, String bookPublisher,
			String bookDate, String bookContent, String bookPrice, String bookLowPrice)
	{
		super();
		this.bookName = bookName;
		this.bookPhoto = bookPhoto;
		this.bookType = bookType;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
		this.bookDate = bookDate;
		this.bookContent = bookContent;
		this.bookPrice = bookPrice;
		this.bookLowPrice = bookLowPrice;
	}
	public Book(String bookName, String bookPhoto, String bookType, String bookWriter)
	{
		super();
		this.bookName = bookName;
		this.bookPhoto = bookPhoto;
		this.bookType = bookType;
		this.bookWriter = bookWriter;
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
	public String getBookType()
	{
		return bookType;
	}
	public void setBookType(String bookType)
	{
		this.bookType = bookType;
	}
	public String getBookWriter()
	{
		return bookWriter;
	}
	public void setBookWriter(String bookWriter)
	{
		this.bookWriter = bookWriter;
	}
	public String getBookPublisher()
	{
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher)
	{
		this.bookPublisher = bookPublisher;
	}
	public String getBookDate()
	{
		return bookDate;
	}
	public void setBookDate(String bookDate)
	{
		this.bookDate = bookDate;
	}
	public String getBookContent()
	{
		return bookContent;
	}
	public void setBookContent(String bookContent)
	{
		this.bookContent = bookContent;
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
}