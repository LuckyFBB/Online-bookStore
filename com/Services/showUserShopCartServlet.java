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
import com.Beans.Order;
import com.Beans.User;
import com.Dao.OrderDao;
@WebServlet("/showUserShopCart.do")
public class showUserShopCartServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		OrderDao dao=new OrderDao();
		HttpSession session=request.getSession();
		String login=(String) session.getAttribute("login");
	    if(login.equals("user"))
	    {
			User user=(User)session.getAttribute("user");
			String userName=user.getUserName();
			ArrayList<Order>userShopCartList=new ArrayList<Order>();
			userShopCartList=dao.showUserShopCart(userName);
			session.setAttribute("userShopCartList", userShopCartList);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/showUserShopCart.jsp");
			rd.forward(request, response);	
		}
	}
}