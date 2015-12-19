package com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.AdditionInterface;


 public class AdditionServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
  @EJB(mappedName="addAsset")
  AdditionInterface aint;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String assetName=request.getParameter("asset_name");
		String assetDesc=request.getParameter("asset_desc");
		String assetType=request.getParameter("asset_type");
		RequestDispatcher rsdp=request.getRequestDispatcher("assetAddition.jsp");
		
		if(assetName.isEmpty()||assetDesc.isEmpty()||assetType.isEmpty())
		{
			String data="Error: Do not leave any field empty";
			request.setAttribute("data",data);
			rsdp.forward(request,response);
		}
		else
		{
			boolean flag=aint.addAsset(assetName, assetDesc, assetType);
		
			if(flag)
			{
				request.setAttribute("data","Asset Added");
				rsdp.forward(request, response);
			}
		}
	}  	
 	  	    
}