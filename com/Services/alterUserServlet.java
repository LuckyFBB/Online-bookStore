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
import com.Dao.UserDao;
@WebServlet("/alterUser.do")
public class alterUserServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserDao dao=new UserDao();
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		User user1=(User)session.getAttribute("user");
		String name=user1.getUserName();
		String newPhone=request.getParameter("newPhone");
		String newPassword=request.getParameter("newPassword");
		String newAddress=request.getParameter("newAddress");
		User user=dao.alertUser(name, newPassword, newPhone, newAddress);
		if(user!=null)
		{
			session.setAttribute("user", user);
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('修改成功');window.location.href='showUser.jsp';</script></html>");
		}
		else
		{
			out.print("<html><head><meta charset='UTF-8'></head>");
			out.print("<script language='javascript'>alert('修改失败');window.history.go(-1);</script></html>");
		}
	}
}