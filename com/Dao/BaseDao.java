package com.Dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao
{
	DataSource dataSource;
	public BaseDao()
	{
		try
		{
			Context context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/webDB");
		}
		catch(NamingException ne)
		{
			System.out.println(ne);
		}
	}
	public Connection getConnection()throws Exception
	{
		return dataSource.getConnection();
	}
}