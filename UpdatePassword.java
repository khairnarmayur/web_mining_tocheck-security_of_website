package web_mining.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_mining.dto.Admin;//my sql database user name link hear

@WebServlet("/passUpdate")
public class UpdatePassword extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String oldPassword=req.getParameter("pass1");
		String newPassword=req.getParameter("pass2");
		System.out.println("Old Password: "+oldPassword+" New Password: "+newPassword);
		
		HttpSession h = req.getSession();
		Admin admin = (Admin) h.getAttribute("admin");
		String dbpass= admin.getPassword();
		
		if (dbpass.equals(oldPassword)) 
		{
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("web_mining");
			EntityManager em= emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			admin.setPassword(newPassword);
			et.begin();
			em.merge(admin);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.write("Password Updated Sucessfully!!!");
			RequestDispatcher rd=req.getRequestDispatcher("MainWebPage.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.write("Enter Valid Old Password!!!");
			RequestDispatcher rd=req.getRequestDispatcher("UpdatePassword.jsp");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}
}