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
import com.Beans.User;
import com.Dao.UserDao;
@WebServlet("/showAllUser.do")
public class showAllUserServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserDao dao=new UserDao();
		HttpSession session=request.getSession();
		ArrayList<User>allUserList=null;
		allUserList=new ArrayList<User>();
		allUserList=dao.showAllUser();
		session.setAttribute("allUserList", allUserList);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/showAllUser.jsp");
		rd.forward(request, response);		
	}
}