package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.NewUserInterface;

 public class RegServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   @EJB(mappedName="storeInDB")
   NewUserInterface newInt;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		String userType=request.getParameter("usertype");
		RequestDispatcher reqDsp=request.getRequestDispatcher("newuser.jsp");
		System.out.println(username+" "+password+" "+password1);
		if(username.isEmpty()||password.isEmpty()||userType==null)
		{
			String data="Error: Enter Values";
			request.setAttribute("data",data);
			reqDsp.forward(request,response);
		}
		
		else if(!password.equals(password1))
		{
			String data="Error: Passwords do not match";
			request.setAttribute("data",data);
			reqDsp.forward(request,response);
		}
		
		else
		{
			String flag=newInt.storeInDB(username, password, userType);
			if(flag.equals("done"))
			{
				request.setAttribute("data","New User Created");
				reqDsp.forward(request,response);
			}
			else if(flag.equals("user exists"))
			{
				String data="Error:Username already exists";
				request.setAttribute("data",data);
				reqDsp.forward(request,response);
			}
			
			else
			{
				String data="Error:There can be only one admin";
				request.setAttribute("data",data);
				reqDsp.forward(request,response);
			}
		}	
	}  	
  	  	    
}