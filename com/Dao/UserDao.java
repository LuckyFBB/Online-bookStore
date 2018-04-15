package com.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Beans.User;

public class UserDao extends BaseDao
{
	public boolean addUser(User user)
	{
		String sql="insert into [userOfbigTest] (userName,userPassword,userPhone,userAddress)values(?,?,?,?)";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserPhone());
			pstmt.setString(4, user.getUserAddress());
			pstmt.executeUpdate();
		return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public User loginCheck(String name,String password,String login)
	{
		if(login.equals("user"))
		{
			String sql="select * from [userOfbigTest] where userName=? and userPassword=?";
			try(Connection dbconn=dataSource.getConnection();
					PreparedStatement pstmt=dbconn.prepareStatement(sql);)
			{
				
				pstmt.setString(1,name);
				pstmt.setString(2,password);
				ResultSet rst = pstmt.executeQuery();
				if(rst.next())
				{
					String userName=rst.getString("userName");
					String userPassword=rst.getString("userPassword");
					String userPhone=rst.getString("userPhone");
					String userAddress=rst.getString("userAddress");
					User user=new User(userName,userPassword,userPhone,userAddress);
					return user;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			String sql="select * from [managerOfbigTest] where managerName=? and managerPassword=?";
			try(Connection dbconn=dataSource.getConnection();
					PreparedStatement pstmt=dbconn.prepareStatement(sql);)
			{
				pstmt.setString(1,name);
				pstmt.setString(2,password);
				ResultSet rst = pstmt.executeQuery();
				if(rst.next())
				{
					User user=new User(name,password);
					return user;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	public User alertUser(String name,String newPassword,String newPhone,String newAddress)
	{
		String sql="update [userOfbigTest] set userPhone=?,userPassword=?,userAddress=? where userName=?";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			pstmt.setString(1,newPhone);
			pstmt.setString(2,newPassword);
			pstmt.setString(3,newAddress);
			pstmt.setString(4,name);
			pstmt.executeUpdate();
			User user=new User(name,newPassword,newPhone,newAddress);
			return user;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<User> showAllUser()
	{
		ArrayList<User>allUserList=new ArrayList<User>();
		String sql="select * from [userOfbigTest]";
		try(Connection dbconn=dataSource.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);)
		{
			ResultSet rst = pstmt.executeQuery();
			while(rst.next())
			{
				String userName=rst.getString("userName");
				String userPassword=rst.getString("userPassword");
				String userPhone=rst.getString("userPhone");
				String userAddress=rst.getString("userAddress");
				User allUsers=new User(userName,userPassword,userPhone,userAddress);
				allUserList.add(allUsers);	
			}
			return allUserList;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}