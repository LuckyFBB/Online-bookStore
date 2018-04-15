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
@WebServlet("/updateBook.do")
public class updateBookServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BookDao dao=new BookDao();
		HttpSession session=request.getSession();
		String bookname=request.getParameter("bookName");
		Book updateBook=dao.selectUpdateBook(bookname);
		session.setAttribute("updateBook", updateBook);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/updateBook.jsp");
		rd.forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BookDao dao=new BookDao();
		PrintWriter out = response.getWriter();
		String bookName=request.getParameter("bookName");
		String bookPhoto=request.getParameter("bookPhoto");
		String bookType=request.getParameter("bookType");
		String bookWriter=request.getParameter("bookWriter");
		String bookPublisher=request.getParameter("bookPublisher");
		String bookDate=request.getParameter("bookDate");
		String bookContent=request.getParameter("bookContent");
		String bookLowPrice=request.getParameter("bookLowPrice");
		String bookPrice=request.getParameter("bookPrice");
		boolean success=dao.updateBook(bookPhoto, bookType, bookWriter, bookPublisher, bookDate, bookContent, bookLowPrice, bookPrice, bookName);
		if(success)	
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('修改成功');location='query.do?choose=all';</script></html>");
		}
		else
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('修改失败');window.history.back(-1);</script></html>");
		}
	}
}