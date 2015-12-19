package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.*;


 public class ReportServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
 @EJB(mappedName="report")  
 ReportInterface ri;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("name");
		PrintWriter pw=response.getWriter();
		RequestDispatcher rsd;
		
		if(name.equals("Generate by Category"))
		{
			rsd=request.getRequestDispatcher("categoryOutput.jsp");
			String assetType=request.getParameter("choice");
			ArrayList<Asset> assetList=ri.categoryWiseAsset(assetType);
			request.setAttribute("assetlist",assetList);
			rsd.forward(request,response);
		}
		
		if(name.equals("Generate by username"))
		{
			rsd=request.getRequestDispatcher("specUserOutput.jsp");
			String username=request.getParameter("choice");
			ArrayList<Transaction> transList=ri.specUser(username);
			request.setAttribute("translist",transList);
			rsd.forward(request,response);
		}
		
		if(name.equals("duelist"))
		{
			rsd=request.getRequestDispatcher("dueListOutput.jsp");
			ArrayList<Transaction> transList=ri.dueList();
			request.setAttribute("translist",transList);
			rsd.forward(request,response);
		}
		
		if(name.equals("fineList"))
		{
			rsd=request.getRequestDispatcher("fineListOutput.jsp");
			ArrayList<Transaction> transList=ri.fineList();
			request.setAttribute("translist",transList);
			rsd.forward(request,response);
		}
		
		if(name.equals("borrowlist"))
		{
			rsd=request.getRequestDispatcher("specUser.jsp");
			ArrayList<String> userTypeList=ri.userTypeList();
			request.setAttribute("usertypelist",userTypeList);
			rsd.forward(request,response);
		}
		
		if(name.equals("assetlist"))
		{
			rsd=request.getRequestDispatcher("category.jsp");
			ArrayList<String> assetTypeList=ri.asstTypeList();
			request.setAttribute("assettypelist",assetTypeList);
			rsd.forward(request,response);
		}
		
		if(name.equals("Generate for a day"))
		{
			rsd=request.getRequestDispatcher("dateWiseReportOutput.jsp");
			String day=request.getParameter("day");
			String month=request.getParameter("month");
			String year=request.getParameter("year");
			String date=day+"-"+month+"-"+year;
			System.out.println(date);
			ArrayList<Transaction> byDayList=ri.byDayList(date);
			request.setAttribute("date","day");
			request.setAttribute("bydaylist",byDayList);
			rsd.forward(request,response);
			
			
		}
		
		if(name.equals("Generate for a month"))
		{
			rsd=request.getRequestDispatcher("dateWiseReportOutput.jsp");
			String month=request.getParameter("month");
			ArrayList<Transaction> byMonthList=ri.byMonthList(month);
			request.setAttribute("date","month");
			request.setAttribute("bymonthlist",byMonthList);
			rsd.forward(request,response);
		}
		
		if(name.equals("Generate for a period"))
		{
			rsd=request.getRequestDispatcher("dateWiseReportOutput.jsp");
			String day1=request.getParameter("day1");
			String month1=request.getParameter("month1");
			String year1=request.getParameter("year1");
			String date1=day1+"-"+month1+"-"+year1;
			
			String day2=request.getParameter("day2");
			String month2=request.getParameter("month2");
			String year2=request.getParameter("year2");
			String date2=day2+"-"+month2+"-"+year2;
			
			ArrayList<Transaction> byPeriodList=ri.byPeriodList(date1,date2);
			request.setAttribute("date","period");
			request.setAttribute("byperiodlist",byPeriodList);
			rsd.forward(request,response);
		}
	}  	
	  	    
}