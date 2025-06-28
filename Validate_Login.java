package web_mining.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_mining.dto.Admin;

@WebServlet("/validateLogin")
public class Validate_Login extends HttpServlet
{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			String email=req.getParameter("email2");
			String password=req.getParameter("pass2");
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("web_mining");
			EntityManager em= emf.createEntityManager();
			
			Query q=em.createQuery("select a from Admin a where a.email=?1 and a.password=?2");
			q.setParameter(1, email);
			q.setParameter(2, password);
			
			List<Admin> admins=q.getResultList();
			
			if(admins.size()>0)
			{
				HttpSession h = req.getSession();
				h.setAttribute("admin", admins.get(0));
				
				PrintWriter pw=resp.getWriter();
				pw.write("WELCOME!!! LOGIN SUCCESSFULL!!!");
				RequestDispatcher rd=req.getRequestDispatcher("MainWebPage.html");
				rd.include(req, resp);
				resp.setContentType("text/html");
			}
			else 
			{
				PrintWriter pw=resp.getWriter();
				pw.write("Incorrect Account Details!!!  LOGIN AGAIN");
				RequestDispatcher rd=req.getRequestDispatcher("Login.html");
				rd.include(req, resp);
				resp.setContentType("text/html");
			}
		}
}