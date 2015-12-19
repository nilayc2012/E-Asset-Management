package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.AllocDeallocInterface;
import com.beans.Asset;

 public class AllocDeallocServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
  @EJB(mappedName="AllocDealloc")
  AllocDeallocInterface adi;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String data=request.getParameter("data");
		String operation=request.getParameter("operation");
		RequestDispatcher rsd;
		HttpSession hts=request.getSession();
	
		
		if(data.equals("getData")&&operation.equals("Apply"))
		{
			rsd=request.getRequestDispatcher("assetAllocation.jsp");
			ArrayList<Asset> assetList=new ArrayList<Asset>();
			assetList=adi.getAssetData();
			hts.setAttribute("assetlist",assetList);
			rsd.forward(request, response);
		}
		
		if(data.equals("getData")&&operation.equals("Return"))
		{
			rsd=request.getRequestDispatcher("assetDeallocation.jsp");
			ArrayList<Asset> asstList;
			String username=(String)hts.getAttribute("username");
			asstList=adi.getAllocAssetData(username); 
			System.out.println(asstList.size());
			if(asstList.size()>0)
			{
				hts.setAttribute("asset",asstList);
				rsd.forward(request, response);
			}
			else
			{
				request.setAttribute("data","you don't have any asset to return");
				rsd.forward(request, response);
			}
		}
		
		if(data.equals("Apply"))
		{
			rsd=request.getRequestDispatcher("assetAllocation.jsp");
			String assetId=request.getParameter("choice");
			String username=(String)hts.getAttribute("username");
			String flag=adi.allocAsset(assetId,username);
			if(flag.equals("true"))
			{
				request.setAttribute("data","Asset Allocated");
				ArrayList<Asset> assetList=new ArrayList<Asset>();
				assetList=adi.getAssetData();
				hts.setAttribute("assetlist",assetList);
				rsd.forward(request, response);
			}
			
			else if(flag.equals("false1"))
			{
				request.setAttribute("data","you have asset whose returning date is already over");
				rsd.forward(request, response);
			}
			else
			{
				request.setAttribute("data","Asset already issued");
				hts.setAttribute("assetId",assetId);
				rsd.forward(request, response);
			}
		}
		if(data.equals("Return"))
		{
			rsd=request.getRequestDispatcher("assetDeallocation.jsp");
			String assetId=request.getParameter("choice");
			String username=(String)hts.getAttribute("username");
			String issued=(String)request.getAttribute("opr");

			if(issued==null)
			{
				rsd=request.getRequestDispatcher("ReserveServlet");
				request.setAttribute("assetId",assetId);
				rsd.forward(request,response);
			}
			else
			{
				int fine=adi.deallocAsset(assetId,username);
				ArrayList<Asset> assetList=new ArrayList<Asset>();
				assetList=adi.getAllocAssetData(username);
				System.out.println(assetList);
				hts.setAttribute("asset",assetList);
				
				if(fine>0)
				{
					request.setAttribute("data","Asset Deallocated...<br/>Pay Rs."+fine+" fine");
					rsd.forward(request, response);
				}
				else
				{
					request.setAttribute("data","Asset Deallocated...<br/>No fine");
					rsd.forward(request, response);
				}
			}
		}
		
		if(data.equals("Reserve"))
		{
			rsd=request.getRequestDispatcher("assetAllocation.jsp");
			String username=(String)hts.getAttribute("username");
			String assetId=(String)hts.getAttribute("assetId");
			boolean flag=adi.doReserve(assetId, username);
			if(flag)
			{
				request.setAttribute("data","Asset Reserved");
				rsd.forward(request, response);
			}
			else
			{
				request.setAttribute("data","Asset already Reserved");
				rsd.forward(request, response);
			}
			
		}
	} 
	
	
	
 	  	    
}