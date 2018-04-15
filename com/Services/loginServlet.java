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
import com.Beans.User;
import com.Dao.UserDao;
@WebServlet("/login.do")
public class loginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserDao dao=new UserDao();
		PrintWriter out = response.getWriter();
		boolean flag=true;
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String login=request.getParameter("login");
		HttpSession session=request.getSession();
		session.setAttribute("login", login);
		if(name==""||password=="")
			flag=false;
		if(flag==false)
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('用户名和密码没有填完');window.history.back(-1);</script></html>");
		}
		else
		{
			if(login.equals("user"))
			{
				User user=dao.loginCheck(name, password, login);
				if(user!=null)
				{
					session.setAttribute("user", user);
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/userLogined.jsp");
					rd.forward(request, response);
				}
				else
				{
					out.print("<html><head><meta charset='UTF-8'></head>");
					out.print("<script language='javascript'>alert('用户名和密码不匹配');window.history.back(-1);</script></html>");
				}
			}
			else
			{
				User user=dao.loginCheck(name, password, login);
				if(user!=null)
				{
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/manager.jsp");
					rd.forward(request, response);
				}
				else
				{
					out.print("<html><head><meta charset='UTF-8'></head>");
					out.print("<script language='javascript'>alert('用户名和密码不匹配');window.history.back(-1);</script></html>");
				}
			}
		}
	}
}