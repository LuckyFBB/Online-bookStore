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
@WebServlet("/showUserOrder.do")
public class showUserOrderServlet extends HttpServlet
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
			ArrayList<Order>userOrderList=new ArrayList<Order>();
			ArrayList<Order>userOrderWeiList=new ArrayList<Order>();
			ArrayList<Order>userOrderFaList=new ArrayList<Order>();
			userOrderList=dao.showUserOrder(userName);
			for(Order userOrder:userOrderList)
			{
				if(userOrder.getBookState().equals("未发货"))
					userOrderWeiList.add(userOrder);
				else
					userOrderFaList.add(userOrder);
			}
			session.setAttribute("userOrderFaList", userOrderFaList);
			session.setAttribute("userOrderWeiList", userOrderWeiList);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/showUserOrder.jsp");
			rd.forward(request, response);	
		}
	    else
	    {
	    	ArrayList<Order>allUserOrderList=new ArrayList<Order>();
			ArrayList<Order>allUserOrderFaList=new ArrayList<Order>();
		    ArrayList<Order>allUserOrderWeiList=new ArrayList<Order>();
		    allUserOrderList=dao.showAllUserOrder();
		    for(Order allUserOrder:allUserOrderList)
		    {
		    	if(allUserOrder.getBookState().equals("已发货"))
		    		allUserOrderFaList.add(allUserOrder);
				else
					allUserOrderWeiList.add(allUserOrder);
		    }
				session.setAttribute("allUserOrderFaList", allUserOrderFaList);
				session.setAttribute("allUserOrderWeiList", allUserOrderWeiList);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/showAllOrder.jsp");
			rd.forward(request, response);	
		}
	}
}