package com.Services;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Beans.Book;
import com.Beans.Order;
import com.Beans.User;
import com.Dao.OrderDao;
@WebServlet("/addShopCart.do")
public class addShopCartServlet extends HttpServlet
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
		if(session.getAttribute("user")==null)
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('未登录，前去登录');window.location.href='login.jsp';</script></html>");
		}
		else
		{
			User user=(User)session.getAttribute("user");
			String userName=user.getUserName();
			String userPhone=user.getUserPhone();
			String userAddress=user.getUserAddress();
			Book book=(Book)session.getAttribute("searchBook");
			String bookName=book.getBookName();
			String bookPhoto=book.getBookPhoto();
			String bookPrice=book.getBookPrice();
			String bookLowPrice=book.getBookLowPrice();
			String message=null;
			Order order=new Order(userName,bookName,bookPhoto,bookPrice,bookLowPrice,userPhone,userAddress);
			try
			{
				boolean success=dao.addShopCart(order);
				if(success)
					message="插入成功";
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
				out.print("<script language='javascript'>alert('该书籍，已经加购物车');window.history.back(-1);</script></html>");
			}
			else
			{
				out.print("<html><head><meta charset='UTF-8'></head>");
				out.print("<script language='javascript'>alert('成功加入购物车');window.history.back(-1);</script></html>");
			}
		}
	}
}