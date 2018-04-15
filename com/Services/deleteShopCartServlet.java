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
@WebServlet("/deleteShopCart.do")
public class deleteShopCartServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		OrderDao dao=new OrderDao();
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		User user=(User)session.getAttribute("user");
		String userName=user.getUserName();
		String bookName=request.getParameter("bookName");
		boolean success=dao.deleteShopCart(userName, bookName);
		if(success)
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('删除成功');window.location.href='showUserShopCart.do';</script></html>");
		}
	}
}
