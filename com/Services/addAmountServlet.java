package com.Services;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Beans.User;
import com.Dao.OrderDao;
@WebServlet("/addAmount.do")
public class addAmountServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		OrderDao dao=new OrderDao();
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		User user1=(User)session.getAttribute("user");
		String userName=user1.getUserName();
		String bookName=request.getParameter("bookName");
		String alter=request.getParameter("alter");
		if(alter.equals("add"))
		{
			boolean success=dao.addAmount(userName, bookName);
			if(success)
			{
				out.print("<html><head><meta charset='UTF-8'></head>");
				out.print("<script language='javascript'>;window.location.href='showUserShopCart.do';</script></html>");
			}
		}
		else
		{
			boolean success=dao.reduceAmount(userName, bookName);
			if(success)
			{
				out.print("<html><head><meta charset='UTF-8'></head>");
				out.print("<script language='javascript'>window.location.href='showUserShopCart.do';</script></html>");
			}
			else
			{
				out.print("<html><head><meta charset='UTF-8'></head>");
				out.print("<script language='javascript'>alert('书本数量不能小于1，你可以选择删除该订单');window.location.href='showUserShopCart.do';</script></html>");
			}
		}
	}
}