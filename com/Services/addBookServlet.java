package com.Services;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Dao.BookDao;
@WebServlet("/addBook.do")
public class addBookServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BookDao dao=new BookDao();
		PrintWriter out = response.getWriter();
		String bookName=request.getParameter("bookName");
		String bookType=request.getParameter("bookType");
		String bookPhoto=request.getParameter("bookPhoto");
		String bookWriter=request.getParameter("bookWriter");
		String bookpublisher=request.getParameter("bookpublisher");
		String bookDate=request.getParameter("bookDate");
		String bookContent=request.getParameter("bookContent");
		String bookPrice=request.getParameter("bookPrice");
		String bookLowPrice=request.getParameter("bookLowPrice");
		boolean success=dao.addBook(bookName, bookPhoto, bookType, bookWriter, bookpublisher, bookDate, bookContent, bookPrice, bookLowPrice);
		if(success)
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('成功添加书籍');location='query.do?choose=all';</script></html>");
		}
		else
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('添加失败');window.history.back(-1);</script></html>");
		}
	}
}