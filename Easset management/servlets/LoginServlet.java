package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.LoginInterface;


 public class LoginServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   @EJB(mappedName="checkuser")
   LoginInterface lin;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String userType=request.getParameter("usertype");
		
		HttpSession hs;
		RequestDispatcher rsd;
		if(username.isEmpty()||password.isEmpty()||userType==null)
		{
			hs=request.getSession();
			hs.setAttribute("data","Don't keep any field empty");
			rsd=request.getRequestDispatcher("index.jsp");
			rsd.forward(request, response);
		}
		
		else
		{
			boolean flag=lin.checkUser(username, password, userType);
			PrintWriter pw=response.getWriter();
		
		
			if(flag && userType.equals("admin"))
			{
				hs=request.getSession();
				hs.setAttribute("usertype",userType);
				rsd=request.getRequestDispatcher("adminLogin.jsp");
				rsd.forward(request, response);
			}
		
			if(flag && userType.equals("borrower"))
			{
				hs=request.getSession();
				hs.setAttribute("usertype",userType);
				hs.setAttribute("username",username);
				rsd=request.getRequestDispatcher("borrowerLogin.jsp");
				rsd.forward(request, response);
			}
			if(!flag)
			{
				hs=request.getSession();
				hs.setAttribute("data","Wrong username or password");
				rsd=request.getRequestDispatcher("index.jsp");
				rsd.forward(request, response);
			}
		}
	}  	
 	  	    
}