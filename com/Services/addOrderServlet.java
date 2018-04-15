package com.Services;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Beans.Order;
import com.Beans.User;
import com.Dao.OrderDao;
@WebServlet("/addOrder.do")
public class addOrderServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		User user=(User)session.getAttribute("user");
		String userName=user.getUserName();
		String bookName=request.getParameter("bookName");
		OrderDao dao=new OrderDao();
		Order order=dao.searchOrder(userName, bookName);
		String message=null;
		try
		{
			boolean success=dao.addOrder(order);
			if(success)
			{
				message="购买成功";
				dao.deleteShopCart(userName, bookName);
			}
			else
				message="插入错误";
		}
		catch(Exception e)
		{
			message="异常插入错误";
		}
		if(message=="插入错误"||message=="异常插入错误")
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('购买出错');window.location.href='showUserShopCart.do';</script></html>");
		}
		else
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('购买成功');window.location.href='showUserShopCart.do';</script></html>");
		}
	}	
}