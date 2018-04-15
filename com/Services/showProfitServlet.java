package com.Services;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/showProfit.do")
public class showProfitServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	Connection dbconn=null;
	public void init()
	{
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dburl="jdbc:sqlserver://localhost:1433;DatabaseName=Web";
		String name="FBB";
		String password="123";
		try
		{
			Class.forName(driver);
			 dbconn=DriverManager.getConnection(dburl, name, password);
		}
		catch(ClassNotFoundException e1)
		{
			System.out.println(e1);
		} catch (SQLException e2){}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
    	try
		{
			String sql="select userName,bookAmount,bookPrice,bookLowPrice from [orderOfbigTest]";
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			double totalPrice=0;
			int totalAmount=0;
			while(rst.next())
			{
				String bookPrice=rst.getString("bookPrice");
				String bookLowPrice=rst.getString("bookLowPrice");
				int bookAmount=Integer.parseInt(rst.getString("bookAmount"));
				totalAmount+=bookAmount;
				if(!bookLowPrice.equals("无"))
				{
					double price=Double.parseDouble(bookPrice);
					totalPrice+=price*bookAmount;
				}
				else
				{
					double price=Double.parseDouble(bookLowPrice);
					totalPrice+=price*bookAmount;
				}
			}
			session.setAttribute("totalPrice",totalPrice);
			session.setAttribute("totalAmount",totalAmount);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/showProfit.jsp");
		rd.forward(request, response);
	}
}