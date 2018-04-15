package com.Services;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Beans.Book;
import com.Dao.BookDao;
@WebServlet("/search.do")
public class searchServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BookDao dao=new BookDao();
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		boolean flag=true;
		String searchName=request.getParameter("searchName");
		System.out.println(searchName);
		if(searchName=="")
			flag=false;
		if(flag==false)
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('书名为空');window.history.back(-1);</script></html>");
		}
		else
		{
			Book searchBook=dao.searchBook(searchName);
			if(searchBook!=null)
			{
				session.setAttribute("searchBook", searchBook);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/search.jsp");
				rd.forward(request, response);
			}
			else
			{
				out.print("<html><head><meta charset='UTF-8'></head>");
				out.print("<script language='javascript'>alert('没有这本图书');window.history.back(-1);</script></html>");
			}
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BookDao dao=new BookDao();
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		boolean flag=true;
		String searchName=request.getParameter("searchName");
		System.out.println(searchName);
		if(searchName=="")
			flag=false;
		if(flag==false)
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('书名为空');window.history.back(-1);</script></html>");
		}
		else
		{
			Book searchBook=dao.searchBook(searchName);
			if(searchBook!=null)
			{
				session.setAttribute("searchBook", searchBook);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/search.jsp");
				rd.forward(request, response);
			}	
			else
			{
				out.print("<html><head><meta charset='UTF-8'></head>");
				out.print("<script language='javascript'>alert('没有这本图书');window.history.back(-1);</script></html>");
			}	
		}
	}
}