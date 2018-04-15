package com.Services;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.OrderDao;
@WebServlet("/alterOrder.do")
public class alterOrderServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		OrderDao dao=new OrderDao();
		PrintWriter out = response.getWriter();
		String bookName=request.getParameter("bookName");
		String userName=request.getParameter("userName");
		Timestamp buyingTime=Timestamp.valueOf(request.getParameter("buyingTime"));
		boolean success=dao.alterOrder(userName, bookName,buyingTime);
		if(success)
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('发货成功');location='showUserOrder.do';</script></html>");
		}
		else
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('发货失败');window.history.back(-1);</script></html>");
		}
	}
}
