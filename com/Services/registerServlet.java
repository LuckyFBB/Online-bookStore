package com.Services;
import java.io.IOException;
import java.io.PrintWriter;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Beans.User;
import com.Dao.UserDao;
@WebServlet("/register.do")
public class registerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String message=null;
		boolean flag=true;
		if(name.length()<=4||name.length()>=15)
		{
			flag=false;
			out.print("<script language='javascript'>alert('用户名长度不合适!');window.history.back(-1);</script></html>");
		}
		else if(!password.equals(password1))
		{
			flag=false;
			out.print("<script language='javascript'>alert('两次密码不一样!');window.history.back(-1);</script></html>");
		}
		else if(!phone.matches("[0-9]+")&&phone.length()==11)
		{
			flag=false;
			out.print("<script language='javascript'>alert('电话格式不合适!');window.history.back(-1);</script></html>");
		}
		else if(address=="")
		{
			flag=false;
			out.print("<script language='javascript'>alert('地址不能为空!');window.history.back(-1);</script></html>");
		}
		if(flag)
		{
			User user=new User(name,password, phone, address);
			UserDao dao=new UserDao();
			try
			{
				boolean success=dao.addUser(user);
				if(success)
					message="插入成功";
				else
					message="插入错误";
			}
			catch(Exception e)
			{
				message="异常插入错误";
			}
			System.out.println(message);
			if(message=="插入错误")
			{
				out.print("<html><head><meta charset='UTF-8'></head>");
				out.print("<script language='javascript'>alert('数据库错误');window.history.back(-1);</script></html>");
			}
			else
			{
				out.print("<html><head><meta charset='UTF-8'></head>");
				out.print("<script language='javascript'>alert('注册成功，直接登录');window.location.href='login.jsp';</script></html>");
			}
		}
	}
}