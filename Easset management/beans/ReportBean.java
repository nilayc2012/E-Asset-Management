package com.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ejb.Stateless;

@Stateless(mappedName="report")
public class ReportBean implements ReportInterface
{

	@Override
	public ArrayList<Asset> categoryWiseAsset(String assetType) 
	{
		ArrayList<Asset> assetList=new ArrayList<Asset>();
		Asset asset;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select asset_Id,asset_name,asset_desc,asset_type from assets where asset_type='"+assetType+"'");
			while(rs.next())
			{
				asset=new Asset();
				asset.setAssetId(rs.getInt(1));
				asset.setAssetName(rs.getString(2));
				asset.setAssetDesc(rs.getString(3));
				asset.setAssetType(rs.getString(4));
				assetList.add(asset);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return assetList;
	}

	@Override
	public ArrayList<Transaction> specUser(String username) 
	{
		ArrayList<Transaction> transList=new ArrayList<Transaction>();
		Transaction trans;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from transactions where username='"+username+"'");
			while(rs.next())
			{
				trans=new Transaction();
				trans.setUsername(rs.getString(1));
				trans.setAssetId(rs.getInt(2));
				trans.setAssetName(rs.getString(3));
				trans.setAssetType(rs.getString(4));
				trans.setIssueDate(rs.getString(5));
				trans.setReturningDate(rs.getString(6));
				trans.setReturnedDate(rs.getString(7));
				trans.setFine(rs.getInt(8));
				transList.add(trans);
					
			}
			
			rs=stmt.executeQuery("select * from borrower where username='"+username+"'");
			if(rs.next())
			{
				trans=new Transaction();
				trans.setUsername(rs.getString(1));
				trans.setAssetId(rs.getInt(2));
				trans.setAssetName(rs.getString(3));
				trans.setAssetType(rs.getString(4));
				trans.setIssueDate(rs.getString(5));
				trans.setReturningDate(rs.getString(6));
				transList.add(trans);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return transList;
	}

	@Override
	public ArrayList<Transaction> dueList() 
	{
		ArrayList<Transaction> transList=new ArrayList<Transaction>();
		Transaction trans;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from borrower where returning_date<sysdate");
			
			while(rs.next())
			{
				trans=new Transaction();
				trans.setUsername(rs.getString(1));
				trans.setAssetId(rs.getInt(2));
				trans.setAssetName(rs.getString(3));
				trans.setAssetType(rs.getString(4));
				trans.setIssueDate(rs.getString(5));
				trans.setReturningDate(rs.getString(6));
				transList.add(trans);
					
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return transList;
	}

	@Override
	public ArrayList<Transaction> fineList() 
	{
		ArrayList<Transaction> transList=new ArrayList<Transaction>();
		Transaction trans;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from transactions order by username");
			
			while(rs.next())
			{
				trans=new Transaction();
				trans.setUsername(rs.getString(1));
				trans.setAssetId(rs.getInt(2));
				trans.setAssetName(rs.getString(3));
				trans.setAssetType(rs.getString(4));
				trans.setIssueDate(rs.getString(5));
				trans.setReturningDate(rs.getString(6));
				trans.setReturnedDate(rs.getString(7));
				trans.setFine(rs.getInt(8));
			    transList.add(trans);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return transList;
					
	}

	@Override
	public ArrayList<String> userTypeList() 
	{
		ArrayList<String> userTypeList=new ArrayList<String>();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select username from user_details where usertype!='admin'");
			
			while(rs.next())
			{
				userTypeList.add(rs.getString(1));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userTypeList;
	}

	@Override
	public ArrayList<String> asstTypeList() 
	{
		ArrayList<String> assetTypeList=new ArrayList<String>();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select distinct asset_type from assets");
			
			while(rs.next())
			{
				assetTypeList.add(rs.getString(1));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return assetTypeList;
	}

	@Override
	public ArrayList<Transaction> byDayList(String date) 
	{
		ArrayList<Transaction> transList=new ArrayList<Transaction>();
		Transaction trans;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			System.out.println(date);
			ResultSet rs=stmt.executeQuery("select * from transactions where to_char(issue_date,'dd-mon-yy')='"+date+"' or to_char(returned_date,'dd-mon-yy')='"+date+"'");
			while(rs.next())
			{
				trans=new Transaction();
				trans.setUsername(rs.getString(1));
				trans.setAssetId(rs.getInt(2));
				trans.setAssetName(rs.getString(3));
				trans.setAssetType(rs.getString(4));
				trans.setIssueDate(rs.getString(5));
			    trans.setReturningDate(rs.getString(6));
				trans.setReturnedDate(rs.getString(7));
				trans.setFine(rs.getInt(8));
				transList.add(trans);
					
			}
			
			rs=stmt.executeQuery("select * from borrower where to_char(issue_date,'dd-mon-yy')='"+date+"'");
			while(rs.next())
			{
				trans=new Transaction();
				trans.setUsername(rs.getString(1));
				trans.setAssetId(rs.getInt(2));
				trans.setAssetName(rs.getString(3));
				trans.setAssetType(rs.getString(4));
				trans.setIssueDate(rs.getString(5));
				trans.setReturningDate(rs.getString(6));
				transList.add(trans);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return transList;
	}

	@Override
	public ArrayList<Transaction> byMonthList(String month) 
	{
		ArrayList<Transaction> transList=new ArrayList<Transaction>();
		Transaction trans;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from transactions where to_char(issue_date,'mon')='"+month+"' or to_char(returned_date,'mon')='"+month+"'");
			while(rs.next())
			{
				trans=new Transaction();
				trans.setUsername(rs.getString(1));
				trans.setAssetId(rs.getInt(2));
				trans.setAssetName(rs.getString(3));
				trans.setAssetType(rs.getString(4));
				trans.setIssueDate(rs.getString(5));
				trans.setReturningDate(rs.getString(6));
				trans.setReturnedDate(rs.getString(7));
				trans.setFine(rs.getInt(8));
				transList.add(trans);
					
			}
			
			rs=stmt.executeQuery("select * from borrower where to_char(issue_date,'mon')='"+month+"'");
			while(rs.next())
			{
				trans=new Transaction();
				trans.setUsername(rs.getString(1));
				trans.setAssetId(rs.getInt(2));
				trans.setAssetName(rs.getString(3));
				trans.setAssetType(rs.getString(4));
				trans.setIssueDate(rs.getString(5));
				trans.setReturningDate(rs.getString(6));
				transList.add(trans);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return transList;
	}

	@Override
	public ArrayList<Transaction> byPeriodList(String date1, String date2) 
	{
		ArrayList<Transaction> transList=new ArrayList<Transaction>();
		Transaction trans;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@10.23.0.100:1521:esgdb10","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from transactions where (issue_date between to_date('"+date1+"','dd-mon-yy') and to_date('"+date2+"','dd-mon-yy')) or (returned_date between to_date('"+date1+"','dd-mon-yy') and to_date('"+date2+"','dd-mon-yy'))");
			while(rs.next())
			{
				trans=new Transaction();
				trans.setUsername(rs.getString(1));
				trans.setAssetId(rs.getInt(2));
				trans.setAssetName(rs.getString(3));
				trans.setAssetType(rs.getString(4));
				trans.setIssueDate(rs.getString(5));
				trans.setReturningDate(rs.getString(6));
				trans.setReturnedDate(rs.getString(7));
				trans.setFine(rs.getInt(8));
				transList.add(trans);
					
			}
			
			rs=stmt.executeQuery("select * from borrower where (issue_date between to_date('"+date1+"','dd-mon-yy') and to_date('"+date2+"','dd-mon-yy')) ");
			while(rs.next())
			{
				trans=new Transaction();
				trans.setUsername(rs.getString(1));
				trans.setAssetId(rs.getInt(2));
				trans.setAssetName(rs.getString(3));
				trans.setAssetType(rs.getString(4));
				trans.setIssueDate(rs.getString(5));
				trans.setReturningDate(rs.getString(6));
				transList.add(trans);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return transList;
	
	}
	
public static void main(String[] args) {
	ReportBean rb=new ReportBean();
	System.out.println("hello");
	ArrayList<Transaction> transl=rb.byDayList("22-sep-12");
	System.out.println(transl.size());
	for(Transaction tns:transl)
	{
		System.out.println(tns.getUsername()+"|"+tns.getAssetId()+"|"+tns.getIssueDate()+"|"+tns.getReturnedDate());
	}
}
}
