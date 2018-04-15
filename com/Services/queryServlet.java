package com.Services;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Beans.Book;
import com.Dao.BookDao;
@WebServlet("/query.do")
public class queryServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BookDao dao=new BookDao();
		HttpSession session=request.getSession();
		String choose=request.getParameter("choose");
		request.setAttribute("choose", choose);
		ArrayList<Book>bookList=null;
	    bookList=new ArrayList<Book>();
		if(choose.equals("全部")||choose.equals("all")||choose.equals("login")||choose.equals("notLogin")||choose.equals("register"))
		{
			bookList=dao.queryAllBook(choose);
			session.setAttribute("bookList", bookList);
			if(choose.equals("全部"))
			{
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/query.jsp");
				rd.forward(request, response);
			}
			else if(choose.equals("all"))
			{
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/showAllBook.jsp");
				rd.forward(request, response);
		    }
			else if(choose.equals("login"))
			{
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
		    }
			else if(choose.equals("register"))
			{
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/register.jsp");
				rd.forward(request, response);
		    }
		    else
		    {
		    	RequestDispatcher rd=getServletContext().getRequestDispatcher("/userNotLogin.jsp");
				rd.forward(request, response);
		    }
		}
		else
		{
			bookList=dao.queryTypeBook(choose);
			session.setAttribute("bookList", bookList);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/query.jsp");
			rd.forward(request, response);
		}
	}
}