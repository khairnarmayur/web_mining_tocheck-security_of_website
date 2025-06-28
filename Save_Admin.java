package web_mining.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_mining.dto.Admin;

@WebServlet("/saveadmindata")
public class Save_Admin extends HttpServlet
{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			String email=req.getParameter("email1");
			String password=req.getParameter("pass1"); 
			
			Admin admin=new Admin();
			admin.setEmail(email);
			admin.setPassword(password);
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("web_mining");
			EntityManager em= emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			em.persist(admin);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.write("Account Details Added Successfully!!!  LOGIN AGAIN");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
}