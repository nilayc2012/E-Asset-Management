package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.ProducerBeanRemote;

 public class ReserveServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
  @EJB(mappedName="producerbean")
  ProducerBeanRemote bd;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String assetId=(String)request.getAttribute("assetId");
		System.out.println(bd.getAndSendMessage(assetId));
		request.setAttribute("data","Return");
		request.setAttribute("opr","issued");
		RequestDispatcher rsd=request.getRequestDispatcher("AllocDeallocServlet");
		rsd.forward(request, response);
		
	}  	
 	  	    
}