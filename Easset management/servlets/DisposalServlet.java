package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.*;
import java.util.*;

 public class DisposalServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
 @EJB(mappedName="disposal")
 DisposalInterface dint;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String data=request.getParameter("data");
		RequestDispatcher rsd;
		HttpSession hts=request.getSession();
		if(data.equals("getData"))
		{
			rsd=request.getRequestDispatcher("assetDisposal.jsp");
			ArrayList<Asset> assetList=new ArrayList<Asset>();
			assetList=dint.getAssetData();
			hts.setAttribute("assetlist",assetList);
			rsd.forward(request, response);
		}
		if(data.equals("Delete"))
		{
			rsd=request.getRequestDispatcher("assetDisposal.jsp");
			String assetId=request.getParameter("choice");
			boolean flag=dint.deleteAsset(assetId);
			if(flag)
			{
				request.setAttribute("data","Asset Deleted");
				ArrayList<Asset> assetList=new ArrayList<Asset>();
				assetList=dint.getAssetData();
				hts.setAttribute("assetlist",assetList);
				rsd.forward(request, response);
			}
			else
			{
				request.setAttribute("data","Issued Asset cannot be deleted");
				rsd.forward(request, response);
			}
		}
	}  	
		    
}