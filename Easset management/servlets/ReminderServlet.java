package com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.ProducerBeanRemote;
import com.beans.ReminderBeanInterface;


 public class ReminderServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	 @EJB(mappedName="ReminderBean")
	 ReminderBeanInterface rbi;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println(rbi.getAndSendMessage("start"));
		HttpSession hs=request.getSession();
		hs.setAttribute("opr1","issued");
		RequestDispatcher rsd=request.getRequestDispatcher("index.jsp");
		rsd.forward(request, response);
	}  	
   	  	    
}