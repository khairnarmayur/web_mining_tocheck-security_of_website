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

import web_mining.dto.Keywords;
@WebServlet("/addKeyword")	
public class AddKeywords extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String keywords=req.getParameter("keywords");
		
		Keywords kw=new Keywords();
		kw.setKeywords(keywords);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("web_mining");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(kw);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Keywords Added Successfully!!!");
		RequestDispatcher rd=req.getRequestDispatcher("MainWebPage.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
}