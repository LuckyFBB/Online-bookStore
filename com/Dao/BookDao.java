package com.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.Beans.Book;

public class BookDao extends BaseDao
{
	public boolean addBook(String bookName,String bookPhoto,String bookType,String bookWriter,String bookpublisher,String bookDate,String bookContent,String bookPrice,String bookLowPrice)
	{
		String sql="insert into [bookOfbigTest] (bookName,bookPhoto,bookType,bookWriter,bookpublisher,bookDate,bookContent,bookPrice,bookLowPrice)values(?,?,?,?,?,?,?,?,?)";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1, bookName);
			pstmt.setString(2, bookPhoto);
			pstmt.setString(3, bookType);
			pstmt.setString(4, bookWriter);
			pstmt.setString(5, bookpublisher);
			pstmt.setString(6, bookDate);
			pstmt.setString(7, bookContent);
			pstmt.setString(8, bookPrice);
			pstmt.setString(9, bookLowPrice);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteBook(String bookName)
	{
		String sql="delete from [bookOfbigTest] where bookName=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1,bookName);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<Book> queryAllBook(String choose)
	{
		ArrayList<Book>bookList=new ArrayList<Book>();
		String sql="select * from [bookOfbigTest]";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			ResultSet rst = pstmt.executeQuery();
			while(rst.next())
			{
				String bookName=rst.getString("bookName");
				String bookPhoto=rst.getString("bookPhoto");
				String bookType=rst.getString("bookType");
				String bookWriter=rst.getString("bookWriter");
				String bookPublisher=rst.getString("bookPublisher");
				String bookDate=rst.getString("bookDate");
				String bookContent=rst.getString("bookContent");
				String bookLowPrice=rst.getString("bookLowPrice");
				String bookPrice=rst.getString("bookPrice");
				Book queryBooks=new Book(bookName,bookPhoto,bookType,bookWriter,bookPublisher,bookDate,bookContent,bookPrice,bookLowPrice);
				bookList.add(queryBooks);
			}
			return bookList;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
		return null;
	}
	public ArrayList<Book> queryTypeBook(String choose)
	{
		ArrayList<Book>bookList=new ArrayList<Book>();
		String sql="select * from [bookOfbigTest] where bookType=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1,choose);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next())
			{
				String bookName=rst.getString("bookName");
				String bookPhoto=rst.getString("bookPhoto");
				String bookType=rst.getString("bookType");
				String bookWriter=rst.getString("bookWriter");
				String bookPublisher=rst.getString("bookPublisher");
				String bookDate=rst.getString("bookDate");
				String bookContent=rst.getString("bookContent");
				String bookLowPrice=rst.getString("bookLowPrice");
				String bookPrice=rst.getString("bookPrice");
				Book queryBooks=new Book(bookName,bookPhoto,bookType,bookWriter,bookPublisher,bookDate,bookContent,bookPrice,bookLowPrice);
				bookList.add(queryBooks);
			}
			return bookList;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public Book searchBook(String searchName)
	{
		String sql="select * from [bookOfbigTest] where bookName=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1,searchName);
			ResultSet rst = pstmt.executeQuery();
			if(rst.next())
			{
				String bookName=rst.getString("bookName");
				String bookPhoto=rst.getString("bookPhoto");
				String bookType=rst.getString("bookType");
				String bookWriter=rst.getString("bookWriter");
				String bookPublisher=rst.getString("bookPublisher");
				String bookDate=rst.getString("bookDate");
				String bookContent=rst.getString("bookContent");
				String bookLowPrice=rst.getString("bookLowPrice");
				String bookPrice=rst.getString("bookPrice");
				Book searchBook=new Book(bookName,bookPhoto,bookType,bookWriter,bookPublisher,bookDate,bookContent,bookPrice,bookLowPrice);
				return searchBook;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public Book selectUpdateBook(String bookname)
	{
		String sql="select * from [bookOfbigTest] where bookName=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1,bookname);
			ResultSet rst = pstmt.executeQuery();
			if(rst.next())
			{
				String bookName=rst.getString("bookName");
				String bookPhoto=rst.getString("bookPhoto");
				String bookType=rst.getString("bookType");
				String bookWriter=rst.getString("bookWriter");
				String bookPublisher=rst.getString("bookPublisher");
				String bookDate=rst.getString("bookDate");
				String bookContent=rst.getString("bookContent");
				String bookLowPrice=rst.getString("bookLowPrice");
				String bookPrice=rst.getString("bookPrice");
				Book updateBook=new Book(bookName,bookPhoto,bookType,bookWriter,bookPublisher,bookDate,bookContent,bookPrice,bookLowPrice);
				return updateBook;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
		return null;
	}
	public boolean updateBook(String bookPhoto,String bookType,String bookWriter,String bookPublisher,String bookDate,String bookContent,String bookLowPrice,String bookPrice,String bookName)
	{
		String sql="update [bookOfbigTest] set bookPhoto=?,bookType=?,bookWriter=?,bookPublisher=?,bookDate=?,bookContent=?,bookLowPrice=?,bookPrice=? where bookName=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1,bookPhoto);
			pstmt.setString(2,bookType);
			pstmt.setString(3,bookWriter);
			pstmt.setString(4,bookPublisher);
			pstmt.setString(5,bookDate);
			pstmt.setString(6,bookContent);
			pstmt.setString(7,bookLowPrice);
			pstmt.setString(8,bookPrice);
			pstmt.setString(9,bookName);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
