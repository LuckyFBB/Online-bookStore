package com.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.Beans.Order;

public class OrderDao extends BaseDao
{
	public boolean addAmount(String userName,String bookName)
	{
		String sql="update [shopCartOfbigTest] set bookAmount=1+bookAmount where userName=? and bookName=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1,userName);
			pstmt.setString(2,bookName);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean reduceAmount(String userName,String bookName)
	{
		String sql="update [shopCartOfbigTest] set bookAmount=bookAmount-1 where userName=? and bookName=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1,userName);
			pstmt.setString(2,bookName);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean addShopCart(Order order)
	{
		String sql="insert into [shopCartOfbigTest] (userName,bookName,bookPhoto,bookPrice,bookLowPrice,userPhone,userAddress)values(?,?,?,?,?,?,?)";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1, order.getUserName());
			pstmt.setString(2, order.getBookName());
			pstmt.setString(3, order.getBookPhoto());
			pstmt.setString(4, order.getBookPrice());
			pstmt.setString(5, order.getBookLowPrice());
			pstmt.setString(6, order.getUserPhone());
			pstmt.setString(7, order.getUserAddress());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public Order searchOrder(String userName,String bookName)
	{
		String sql="select * from [shopCartOfbigTest] where userName=? and bookName=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1, userName);
			pstmt.setString(2, bookName);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next())
			{
				String bookPhoto=rst.getString("bookPhoto");
				String bookLowPrice=rst.getString("bookLowPrice");
				String bookPrice=rst.getString("bookPrice");
				int bookAmount=Integer.parseInt(rst.getString("bookAmount"));
				String userPhone=rst.getString("userPhone");
				String userAddress=rst.getString("userAddress");
				Order findOrder=new Order(userName,bookName,bookPhoto,bookPrice,bookLowPrice,bookAmount,userPhone,userAddress);
				return findOrder;
			}
		}	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public boolean addOrder(Order order)
	{
		
		String sql="insert into [orderOfbigTest] (userName,bookName,bookPhoto,bookPrice,bookLowPrice,userPhone,userAddress)values(?,?,?,?,?,?,?)";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1, order.getUserName());
			pstmt.setString(2, order.getBookName());
			pstmt.setString(3, order.getBookPhoto());
			pstmt.setString(4, order.getBookPrice());
			pstmt.setString(5, order.getBookLowPrice());
			pstmt.setString(6, order.getUserPhone());
			pstmt.setString(7, order.getUserAddress());
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean alterOrder(String userName,String bookName,Timestamp buyingTime)
	{
		String sql="update [orderOfbigTest] set bookState='已发货' where userName=? and bookName=? and buyingTime=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1,userName);
			pstmt.setString(2,bookName);
			pstmt.setTimestamp(3,buyingTime);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteShopCart(String userName,String bookName)
	{
		String sql="delete from [shopCartOfbigTest] where userName=? and bookName=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1,userName);
			pstmt.setString(2,bookName);
			pstmt.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<Order> showUserShopCart(String userName)
	{
		ArrayList<Order>userOrderList=new ArrayList<Order>();
		String sql="select * from [shopCartOfbigTest] where userName=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1, userName);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next())
			{
				String bookName=rst.getString("bookName");
				String bookPhoto=rst.getString("bookPhoto");
				String bookLowPrice=rst.getString("bookLowPrice");
				String bookPrice=rst.getString("bookPrice");
				int bookAmount=Integer.parseInt(rst.getString("bookAmount"));
				Order userOrder=new Order(bookName,bookPhoto,bookPrice,bookLowPrice,bookAmount);
				userOrderList.add(userOrder);
			}
			return userOrderList;
		}	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Order> showUserOrder(String userName)
	{
		ArrayList<Order>userOrderList=new ArrayList<Order>();
		String sql="select * from [orderOfbigTest] where userName=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1, userName);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next())
			{
				String bookName=rst.getString("bookName");
				String bookPhoto=rst.getString("bookPhoto");
				String bookLowPrice=rst.getString("bookLowPrice");
				String bookPrice=rst.getString("bookPrice");
				int bookAmount=Integer.parseInt(rst.getString("bookAmount"));
				String bookState=rst.getString("bookState");
				Timestamp buyingTime=rst.getTimestamp("buyingTime");
				Order userOrder=new Order(bookName,bookPhoto,bookPrice,bookLowPrice,bookAmount,bookState,buyingTime);
				userOrderList.add(userOrder);
			}
			return userOrderList;
		}	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Order> showAllUserOrder()
	{
		ArrayList<Order>allUserOrderList=new ArrayList<Order>();
		String sql="select * from [orderOfbigTest]";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			ResultSet rst = pstmt.executeQuery();
			while(rst.next())
			{
				String userName=rst.getString("userName");
				String bookName=rst.getString("bookName");
				String bookPhoto=rst.getString("bookPhoto");
				String bookLowPrice=rst.getString("bookLowPrice");
				String bookPrice=rst.getString("bookPrice");
				int bookAmount=Integer.parseInt(rst.getString("bookAmount"));
				String bookState=rst.getString("bookState");
				String userPhone=rst.getString("userPhone");
				String userAddress=rst.getString("userAddress");
				Timestamp buyingTime=rst.getTimestamp("buyingTime");
				Order userOrder=new Order(userName,bookName,bookPhoto,bookPrice,bookLowPrice,bookAmount,bookState,userPhone,userAddress,buyingTime);
				allUserOrderList.add(userOrder);
			}
			return allUserOrderList;
		}	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}